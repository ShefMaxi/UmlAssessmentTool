package fileHandler;

import activityElements.AcceptSignalElement;
import activityElements.ActionNodeElement;
import activityElements.ActivityFinalNodeElement;
import activityElements.CentralBufferNodeElement;
import activityElements.EdgeElements;
import activityElements.EdgeGuard;
import activityElements.ForkNodeElement;
import activityElements.GroupElements;
import activityElements.InitialNodeElement;
import activityElements.InputPinElement;
import activityElements.JoinNodeElement;
import activityElements.OutputPinElement;
import classElements.*;
import packagedElements.*;
import useCaseElements.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jast.xml.*;
import org.jast.xpath.*;

import compareUML.Diagram;
import stateMachineElements.Guard;
import stateMachineElements.SubvertexElement;
import stateMachineElements.TransitionElement;

public class XMIFileParser {
	// usecase 		: 1
	// class 		: 2
	// activity 	: 3
	// statemachine : 4

	private ArrayList<PackagedElement> packagedList = null;

	private int checkDiagramType(String filePath) {
		File xmiFile = new File(filePath);
		XMLReader reader;
		org.jast.xml.Document document;
		try {
			reader = new XMLReader(xmiFile);
			document = reader.readDocument();
		} catch (Exception e) {
			return 0;
		}
		
		// reader.close();
		XPath usecasePath1 = new XPath(
				"//packagedElement[@xmi:type='uml:Actor']");
		XPath usecasePath2 = new XPath("//packagedElement[@xmi:type='uml:UseCase']");
		XPath classPath = new XPath("//packagedElement[@xmi:type='uml:Class']");
		XPath activityPath = new XPath(
				"//packagedElement[@xmi:type='uml:Activity']");
		XPath stateMachinePath = new XPath(
				"//packagedElement[@xmi:type='uml:StateMachine']");

		if (usecasePath1.match(document).size() != 0 || usecasePath2.match(document).size() != 0) {
			return 1;
		} else if (classPath.match(document).size() != 0) {
			return 2;
		} else if (activityPath.match(document).size() != 0) {
			return 3;
		} else if (stateMachinePath.match(document).size() != 0) {
			return 4;
		}

		return 0;
	}

	private ArrayList<PackagedElement> readStateMachineXMIFile(String filePath)
			throws IOException, XMLError {

		ArrayList<PackagedElement> result = new ArrayList<>();
		File xmiFile = new File(filePath);
		XMLReader reader = new XMLReader(xmiFile);
		org.jast.xml.Document document = reader.readDocument();
		
		HashMap<String, SubvertexElement> matchingMap = new HashMap<>();
		XPath query = new XPath("//packagedElement/region");
		List<Content> contentsList = query.match(document);
		// ------------------start
		for (Content region : contentsList) {
			List<Content> allContents = region.getContents();
			for (Content content : allContents) {
				if (content.getName().compareToIgnoreCase("subvertex") == 0) {
					List<org.jast.xml.Attribute> attributes = content
							.getAttributes();
					SubvertexElement element = new SubvertexElement(attributes
							.get(0).getValue(), attributes.get(1).getValue(),
							attributes.get(2).getValue());
					result.add(element);
					matchingMap.put(attributes.get(1).getValue(),
							(SubvertexElement) result.get(result.size() - 1));
				}
			}
		}

		for (Content region : contentsList) {
			List<Content> allContents = region.getContents();
			for (Content content : allContents) {
				if (content.getName().compareToIgnoreCase("transition") == 0) {
					List<org.jast.xml.Attribute> attributes = content
							.getAttributes();
					TransitionElement element = new TransitionElement(
							attributes.get(0).getValue(), attributes.get(1)
									.getValue(), matchingMap.get(attributes
									.get(2).getValue()),
							matchingMap.get(attributes.get(3).getValue()));
					if (attributes.size() == 5) {
						element.setGuard(new Guard(content.getContent(0)
								.getAttributes().get(1).getValue()));
					}
					result.add(element);
				}
			}

		}
		// ------------------end

		return result;
	}

	private ArrayList<PackagedElement> readClassXMIFile(String filePath)
			throws IOException, XMLError, JDOMException {

		ArrayList<PackagedElement> packagedList = new ArrayList<>();
		SAXBuilder xmiBuilder = new SAXBuilder();
		Document document = xmiBuilder.build(new File(filePath));
		Element rootElement = document.getRootElement();
		List<Element> childrenElements = rootElement.getChildren();

		for (Element element : childrenElements) {
			String[] attributeArray = extractAttributeValues(element);

			if (element.getName().equals("packagedElement")) {
				if (attributeArray[0].equals("uml:Class")) {
					ArrayList<String> operation = null;
					operation = new ArrayList<>();
					String generalization = null;
					HashMap<String, String> map = null;
					map = new HashMap<>();
					ArrayList<HashMap<String, String>> attribute = null;
					attribute = new ArrayList<>();
					List<Element> nextChildrenElements = element.getChildren();
					if (nextChildrenElements.size() > 0) {
						for (Element childElement : nextChildrenElements) {
							if (childElement.getName().equals("ownedAttribute")) {
								String attr = childElement
										.getAttributeValue("name");
								String type = childElement.getChild("type")
										.getAttributeValue("href");
								type = type.substring(
										type.lastIndexOf('#') + 1,
										type.length());
								map.put(attr, type);
								attribute.add(map);
							} else if (childElement.getName().equals(
									"ownedOperation")) {
								String attr = childElement
										.getAttributeValue("name");
								operation.add(attr);
							} else if (childElement.getName().equals(
									"generalization")) {
								String generalizationId = childElement
										.getAttributeValue("general");
								generalization = extractChildAttributeValues(
										childrenElements, generalizationId)[1];
							}
						}
					}
					packagedList.add(new ClassElement(attributeArray[0],
							attributeArray[2], operation, generalization,
							attribute));
				}// end of class

				if (attributeArray[0].equals("uml:Association")) {
					String firstMemberName = null;
					String secondMemberName = null;
					String[] lowerValue = new String[2];
					String[] upperValue = new String[2];
					String[] endRole = new String[2];
					String type = "Association";
					String[] ownedEnd = new String[2];
					int i = 0;
					List<Element> nextChildrenElements = element.getChildren();
					if (nextChildrenElements.size() > 0) {
						for (Element childElement : nextChildrenElements) {
							if (childElement.getName().equals("ownedEnd")) {
								ownedEnd[i] = childElement
										.getAttributeValue("type");
								if (childElement
										.getAttributeValue("aggregation") != null) {
									if (childElement.getAttributeValue(
											"aggregation").equals("shared"))
										type = "Aggregation";
									else if (childElement.getAttributeValue(
											"aggregation").equals("composite"))
										type = "Composition";
								}
								if (childElement.getChild("lowerValue") != null) {
									if (childElement.getChild("lowerValue")
											.getAttributeValue("value") != null) {
										lowerValue[i] = childElement.getChild(
												"lowerValue")
												.getAttributeValue("value");
									} else
										lowerValue[i] = "0";
								} else
									lowerValue[i] = "1";
								if (childElement.getChild("upperValue") != null) {
									if (childElement.getChild("upperValue")
											.getAttributeValue("value") != null) {
										upperValue[i] = childElement.getChild(
												"upperValue")
												.getAttributeValue("value");
									} else
										upperValue[i] = "0";
								} else
									upperValue[i] = "1";
							}
							endRole[i] = childElement.getAttributeValue("name");
							i++;
						}
						firstMemberName = extractNames(childrenElements,
								ownedEnd[0]);
						secondMemberName = extractNames(childrenElements,
								ownedEnd[1]);
					}
					packagedList.add(new ClassAssociationElement(type,
							firstMemberName, lowerValue[0], upperValue[0],
							endRole[0], secondMemberName, lowerValue[1],
							upperValue[1], endRole[1]));
					//System.out.println(type);
				}// end of association

				if (attributeArray[0].equals("uml:AssociationClass")) {
					ArrayList<String> operation = null;
					operation = new ArrayList<>();
					HashMap<String, String> map = null;
					map = new HashMap<>();
					ArrayList<HashMap<String, String>> attribute = null;
					attribute = new ArrayList<>();
					String firstMemberName = null;
					String secondMemberName = null;
					String[] lowerValue = new String[2];
					String[] upperValue = new String[2];
					String[] endRole = new String[2];
					String type = "AssociationClass";
					String[] ownedEnd = new String[2];
					int i = 0;
					List<Element> nextChildrenElements = element.getChildren();
					if (nextChildrenElements.size() > 0) {
						for (Element childElement : nextChildrenElements) {
							if (childElement.getName().equals("ownedAttribute")) {
								String attr = childElement
										.getAttributeValue("name");
								String attrType = childElement.getChild("type")
										.getAttributeValue("href");
								attrType = attrType.substring(
										attrType.lastIndexOf('#') + 1,
										attrType.length());
								map.put(attr, attrType);
								attribute.add(map);
							} else if (childElement.getName().equals(
									"ownedOperation")) {
								String attr = childElement
										.getAttributeValue("name");
								operation.add(attr);
							} else if (childElement.getName()
									.equals("ownedEnd")) {
								ownedEnd[i] = childElement
										.getAttributeValue("type");
								if (childElement
										.getAttributeValue("aggregation") != null) {
									if (childElement.getAttributeValue(
											"aggregation").equals("shared"))
										type = "AggregationClass";
									else if (childElement.getAttributeValue(
											"aggregation").equals("composite"))
										type = "CompositionClass";
								}
								if (childElement.getChild("lowerValue") != null) {
									if (childElement.getChild("lowerValue")
											.getAttributeValue("value") != null) {
										lowerValue[i] = childElement.getChild(
												"lowerValue")
												.getAttributeValue("value");
									} else
										lowerValue[i] = "0";
								} else
									lowerValue[i] = "1";
								if (childElement.getChild("upperValue") != null) {
									if (childElement.getChild("upperValue")
											.getAttributeValue("value") != null) {
										upperValue[i] = childElement.getChild(
												"upperValue")
												.getAttributeValue("value");
									} else
										upperValue[i] = "0";
								} else
									upperValue[i] = "1";
								endRole[i] = childElement
										.getAttributeValue("name");
								i++;
							}
						}
						firstMemberName = extractNames(childrenElements,
								ownedEnd[0]);
						secondMemberName = extractNames(childrenElements,
								ownedEnd[1]);
					}
					packagedList.add(new AssociationClassElement(type, attributeArray[2],
							firstMemberName, lowerValue[0], upperValue[0],
							endRole[0], secondMemberName, lowerValue[1],
							upperValue[1], endRole[1], operation, attribute));
				}// end of class association
			}
		}		
		return packagedList;
	}

	private ArrayList<PackagedElement> readUsecaseXMIFile(String filePath)
			throws JDOMException, IOException {
		packagedList = new ArrayList<PackagedElement>();
		SAXBuilder xmiBuilder = new SAXBuilder();
		Document document = xmiBuilder.build(new File(filePath));
		Element rootElement = document.getRootElement();
		List<Element> childrenElements = rootElement.getChildren();

		for (Element element : childrenElements) {
			String[] attributeArray = extractAttributeValues(element);

			if (element.getName().equals("packagedElement")) {
				if (attributeArray[0].equals("uml:Actor")) {
					String generalization = null;
					List<Element> nextChildrenElements = element.getChildren();
					if (nextChildrenElements.size() > 0) {
						for (Element childElement : nextChildrenElements) {
							if (childElement.getName().equals("generalization")) {
								String generalizationId = childElement
										.getAttributeValue("general");
								generalization = extractChildAttributeValues(
										childrenElements, generalizationId)[1];
							}
						}
					}
					packagedList.add(new GeneralizableElement(
							attributeArray[0], attributeArray[1],
							attributeArray[2], generalization));
				}// end of actor

				if (attributeArray[0].equals("uml:UseCase")) {
					String generalization = null;
					String inludeAddition = null;
					String extensionAddition = null;
					ArrayList<String> extensionPoints = new ArrayList<String>();
					List<Element> nextChildrenElements = element.getChildren();
					if (nextChildrenElements.size() > 0) {
						for (Element childElement : nextChildrenElements) {
							if (childElement.getName().equals("generalization")) {
								String generalizationId = childElement
										.getAttributeValue("general");
								generalization = extractChildAttributeValues(
										childrenElements, generalizationId)[1];
							}
							if (childElement.getName().equals("include")) {
								String inludeAdditionId = childElement
										.getAttributeValue("addition");
								inludeAddition = extractChildAttributeValues(
										childrenElements, inludeAdditionId)[1];
							}
							if (childElement.getName().equals("extend")) {
								String excludeAdditionnId = childElement
										.getAttributeValue("extendedCase");
								extensionAddition = extractChildAttributeValues(
										childrenElements, excludeAdditionnId)[1];
							}
							if (childElement.getName().equals("extensionPoint")) {
								String extensionPoint = childElement
										.getAttributeValue("name");
								extensionPoints.add(extensionPoint);
							}
						}
					}
					packagedList.add(new UseCaseElement(attributeArray[0],
							attributeArray[1], attributeArray[2],
							generalization, inludeAddition, extensionAddition,
							extensionPoints));
				}// end of usecase

				if (attributeArray[0].equals("uml:Association")) {
					String[] firstMember = null;
					String[] secondMember = null;
					String[] ownedEnd = new String[2];
					int i = 0;
					List<Element> nextChildrenElements = element.getChildren();
					if (nextChildrenElements.size() > 0) {
						for (Element childElement : nextChildrenElements) {
							if (childElement.getName().equals("ownedEnd")) {
								ownedEnd[i] = childElement
										.getAttributeValue("type");
								i++;
							}
							firstMember = extractChildAttributeValues(
									childrenElements, ownedEnd[0]);
							secondMember = extractChildAttributeValues(
									childrenElements, ownedEnd[1]);
						}
					}
					packagedList.add(new AssociationElement(attributeArray[1],
							firstMember[1], secondMember[1], firstMember[0],
							secondMember[0]));
				}// end of association
			}
		}
		return packagedList;

	}

	private ArrayList<PackagedElement> readActivityXMIFile(String filePath)
			throws IOException, XMLError {
		
		// writen by yan zhang and salisu
		HashMap<String, String> NameIdMap=null;
		NameIdMap = new HashMap<>();
		ArrayList<PackagedElement> result = new ArrayList<>();
		File xmiFile = new File(filePath);
		XMLReader reader = new XMLReader(xmiFile);
		org.jast.xml.Document document = reader.readDocument();

		XPath query = new XPath("//node");
		XPath query2 = new XPath("//edge");
		XPath query3 = new XPath("//group");
		List<Content> nodeElementList = query.match(document);
		List<Content> edgeElementList = query2.match(document);
		List<Content> groupElementList = query3.match(document);
		
		// create id-name map for the whole document
		if (nodeElementList!=null) {
			for (Content content : nodeElementList) {
				List<org.jast.xml.Attribute> attributes = content.getAttributes();
				if (attributes.size()>2) {
					String id = attributes.get(1).getValue();
					String name = attributes.get(2).getValue();
					NameIdMap.put(id, name);
				}
                
                org.jast.xml.Element e = (org.jast.xml.Element)content;
				if (e.hasChildren()) {
					org.jast.xml.Element inputV = e.getChild("inputValue");
					if (inputV!=null) {
						NameIdMap.put(inputV.getAttribute("xmi:id").getValue(), 
								inputV.getAttribute("name").getValue());
					}
				
					org.jast.xml.Element outputV = e.getChild("outputValue");
					if (outputV!=null) {
						NameIdMap.put(outputV.getAttribute("xmi:id").getValue(), 
								outputV.getAttribute("name").getValue());
					}
					
				}
			}
		}
		if (edgeElementList!=null) {
			for (Content content : edgeElementList) {
				List<org.jast.xml.Attribute> attributes = content.getAttributes();
				if (attributes.size()>2) {
					String id = attributes.get(1).getValue();
					String name = attributes.get(2).getValue();
					NameIdMap.put(id, name);
				}
                //.......................Salisu.......................
				org.jast.xml.Element e2 = (org.jast.xml.Element)content;
				if (e2.hasChildren()) {
					org.jast.xml.Element weight = e2.getChild("weight");
					if (weight!=null) {
						NameIdMap.put(weight.getAttribute("xmi:id").getValue(), 
								weight.getAttribute("value").getValue());
					}
				}
				if (e2.hasChildren()) {
					org.jast.xml.Element guard = e2.getChild("guard");
					if (guard!=null) {
						NameIdMap.put(guard.getAttribute("xmi:id").getValue(), 
								guard.getAttribute("xmi:type").getValue());
						
					}
				}
			}
		}
		if (groupElementList!=null) {
			for (Content content : groupElementList) {
				List<org.jast.xml.Attribute> attributes = content.getAttributes();
				if (attributes.size()>2) {
					String id = attributes.get(1).getValue();
					String name = attributes.get(2).getValue();
					NameIdMap.put(id, name);
				}
			}
		}
        //System.out.println(NameIdMap);
                
         
                
                
		//************** node Element builder ******************************************/
		for (Content node : nodeElementList) {
			
			String inPartition = null;
			String name = null;
			String incomingName = null;
			String outgoingName = null;
			boolean inputValue = false;
			boolean outputValue = false;
			List<org.jast.xml.Attribute> attributes = node.getAttributes();
			
			org.jast.xml.Element nodeElement = (org.jast.xml.Element)node;
			// extracting inPartition from current node element
			org.jast.xml.Attribute ip = nodeElement.getAttribute("inPartition");
			if (ip!=null) {
				inPartition=NameIdMap.get(ip.getValue());
			}
			
			// extracting outgoing from current node element
			org.jast.xml.Attribute og = nodeElement.getAttribute("outgoing");
			if (og!=null) {
				outgoingName=NameIdMap.get(og.getValue());
			}
			
			// extracting incoming from current node element
			org.jast.xml.Attribute ic = nodeElement.getAttribute("incoming");
			if (ic!=null) {
				incomingName=NameIdMap.get(ic.getValue());
			}

			// extracting name from current node element
			org.jast.xml.Attribute nm = nodeElement.getAttribute("name");
			if (nm!=null) {
				name = nm.getValue();
			}
			
		
			// builders 
			switch (attributes.get(0).getValue()) {
			
			//***************************************************ActionNodeElement and Pins**************/
			case "uml:CallOperationAction":
			case "uml:CallBehaviorAction":
			case "uml:OpaqueAction":

				
				
				// extracting inputValue from current node element if exists
				org.jast.xml.Element iv = nodeElement.getChild("inputValue");
				if (iv!=null) {
					inputValue=true;
					String ipId = null;
					String ipName = null;
					String ipIncoming = null;
					String iN = null;
					
					org.jast.xml.Attribute iId = iv.getAttribute("id");
					if (iId!=null) {
						ipId = iId.getValue();
					}
					
					org.jast.xml.Attribute iName = iv.getAttribute("name");
					if (iName!=null) {
						ipName = iName.getValue();
					}
					
					org.jast.xml.Attribute iIncoming = iv.getAttribute("incoming");
					if (iIncoming!=null) {
						ipIncoming = iIncoming.getValue();
						iN=NameIdMap.get(ipIncoming);
	 
					}
					
					
					PackagedElement ivp = new InputPinElement("uml:InputPin", ipId, inPartition, ipName, iN);
					result.add(ivp);
				}
				
				// extracting outputValue from current node element if exists
				org.jast.xml.Element ov = nodeElement.getChild("outputValue");
				if (ov!=null) {
					outputValue=true;
					String ipId = null;
					String ipName = null;
					String ipOutgoing = null;
					String oN = null;
					
					org.jast.xml.Attribute iId = ov.getAttribute("id");
					if (iId!=null) {
						ipId = iId.getValue();
					}
					
					org.jast.xml.Attribute iName = ov.getAttribute("name");
					if (iName!=null) {
						ipName = iName.getValue();
					}
					
					org.jast.xml.Attribute iOutgoing = ov.getAttribute("incoming");
					if (iOutgoing!=null) {
						ipOutgoing = iOutgoing.getValue();
						oN=NameIdMap.get(ipOutgoing);
					}
					PackagedElement ovp = new OutputPinElement("uml:OutputPin", ipId, inPartition, ipName, oN);
					result.add(ovp);
				}
				
				PackagedElement oa = new ActionNodeElement("uml:ActionNodeElement",
						attributes.get(1).getValue(),inPartition, name, 
						incomingName, outgoingName, inputValue, outputValue);
				result.add(oa);
				break;
				
			//*****************************************************AcceptSignalElement***********/
			case "uml:AcceptCallAction":
			case "uml:AcceptEventAction":
				
				PackagedElement aea = new AcceptSignalElement("uml:AcceptSignalElement", 
						attributes.get(1).getValue(),inPartition, name, outgoingName);
				result.add(aea);
				break;
				
			//*****************************************************ActivityFinalNodeElement*****/	
			case "uml:ActivityFinalNode":
				
				PackagedElement afn = new ActivityFinalNodeElement("uml:ActivityFinalNodeElement", 
						attributes.get(1).getValue(), inPartition, name, incomingName);
				result.add(afn);
				break;
				
			//*****************************************************CentralBufferNode, object node*****/	
			case "uml:CentralBufferNode":
				
				PackagedElement cbn = new CentralBufferNodeElement("uml:CentralBufferNodeElement", 
						attributes.get(1).getValue(), inPartition, name, incomingName, outgoingName);
				result.add(cbn);
				break;
				
			//******************************************************merge/joinNodeElement***********/
			case "uml:JoinNode":
			case "uml:MergeNode":
				HashSet<String> incomingNamePaths=new HashSet<String>();
				// extracting incoming from current node element
				org.jast.xml.Attribute jog = nodeElement.getAttribute("incoming");
				if (jog!=null) {
					String incomingIds = jog.getValue();
					
					if (incomingIds!=null) {
						
						String[] temp = incomingIds.split(" ");
						for (String jid : temp) {
							String jName = NameIdMap.get(jid);
							incomingNamePaths.add(jName);
						}
					}
				}
			
				PackagedElement jn = new JoinNodeElement("uml:JoinNodeElement", 
						attributes.get(1).getValue(), inPartition, name, outgoingName, incomingNamePaths);
				
				result.add(jn);
				break;
				
				//*****************************************************Fork/DecisionNodeElement***************/
			case "uml:ForkNode":
			case "uml:DecisionNode":	
				HashSet<String> outgoingNamePaths=new HashSet<String>();
				// extracting incoming from current node element
				org.jast.xml.Attribute fog = nodeElement.getAttribute("outgoing");
				if (fog!=null) {
					String outgoingIds = fog.getValue();
					
					if (outgoingIds!=null) {
						
						String[] temp = outgoingIds.split(" ");
						for (String jid : temp) {
							String jName = NameIdMap.get(jid);
							outgoingNamePaths.add(jName);
						}
					}
				}
				
				PackagedElement fn = new ForkNodeElement("uml:ForkNodeElement", 
						attributes.get(1).getValue(), inPartition, name, outgoingNamePaths, incomingName);
				result.add(fn);
				break;
				
				
				
			//*****************************************************InitialNodeElement***************/
			case "uml:InitialNode":
				
				PackagedElement in = new InitialNodeElement(attributes.get(0).getValue(), 
						attributes.get(1).getValue(), inPartition, name, outgoingName);
				result.add(in);
				break;
				
			default:
				
				System.out.println("Can't parse this element!");
				System.out.println("error element type: "+attributes.get(0).getValue());
				break;
			}
		}
                
        //**************************** edge and group element builders ***********************/
        //.................Salisu......................................
        for (Content edge : edgeElementList) {
            
            
            String type = null;
            String name = null;
            String Id = null;
            String sourceNodeName = null;
            String targetNodeName = null;
            boolean guard = false;	// not needed in compare class, may be later
            if (guard) {;};// destroy warnings
            if (type==null) {};// destroy warnings
            
            org.jast.xml.Element edgeElement = (org.jast.xml.Element)edge;
            
            // extracting name from current node element
            org.jast.xml. Attribute nm = edgeElement.getAttribute("name");
            if (nm!=null) {
                name = nm.getValue();
            }
            else{
            	name=null;
            }
            
            // extracting ID from current node element
            org.jast.xml.Attribute id = edgeElement.getAttribute("xmi:id");
            if (nm!=null) {
                Id = id.getValue();
            }
            // extracting type from current edge element
            org.jast.xml.Attribute typ = edgeElement.getAttribute("xmi:type");
            if (nm!=null) {
                type = typ.getValue();
            }
            
            // extracting SourceNode from current edge element
            org.jast.xml.Attribute source = edgeElement.getAttribute("source");
            if (source!=null) {
                sourceNodeName=NameIdMap.get(source.getValue());
            }
            
            // extracting incoming from current edge element
            org.jast.xml.Attribute target = edgeElement.getAttribute("target");
            if (target!=null) {
                targetNodeName=NameIdMap.get(target.getValue());
            }
            org.jast.xml.Element iv = edgeElement.getChild("guard");
			if (iv!=null) {
				guard=true;
				
				String gdId = null;  
				String value = null;	
				String gbody=null;
				
				org.jast.xml.Attribute iId = iv.getAttribute("xmi:id");
				if (iId!=null) {
					gdId = iId.getValue();
				}
				
				org.jast.xml.Attribute vl = iv.getAttribute("xmi:type");
				if (vl!=null) {
					value = vl.getValue();
				}
				 gbody=iv.getChild("body").getText();
				 PackagedElement eguard= new EdgeGuard(value, gdId, gbody);
				 result.add(eguard);
			}
				PackagedElement edg= new EdgeElements(type, Id, name, sourceNodeName, targetNodeName);
				result.add(edg);
				
			
            for (Content group : groupElementList) {
                
                
                String gtype = null;
                String gname = null;
                String gId = null;
                //String Node = null;
                if (gtype==null) {;};// destroy warnings
                
                
                org.jast.xml.Element groupElement = (org.jast.xml.Element)group;
                
                // extracting name from current group element
                org.jast.xml.Attribute gnm = groupElement.getAttribute("name");
                if (gnm!=null) {
                    gname = gnm.getValue();
                }
                
                // extracting ID from current group element
                org.jast.xml.Attribute gid = edgeElement.getAttribute("xmi:id");
                if (gid!=null) {
                    gId = gid.getValue();
                }
                // extracting type from current group element
                org.jast.xml.Attribute gtyp = edgeElement.getAttribute("xmi:type");
                if (gtyp!=null) {
                    gtype = gtyp.getValue();
                }
                
                PackagedElement grp= new GroupElements("uml:group", gId, gname);
                result.add(grp);
            }
        }
		
		return result;
	}

	public Diagram readXMIFile(String filePath) {
		Diagram diagram = null;
		int diagramType = this.checkDiagramType(filePath);
		System.out.println("start reading");
		try {
			switch (diagramType) {
			case 1:
				diagram = new Diagram(readUsecaseXMIFile(filePath), diagramType);
				break;
			case 2:
				diagram = new Diagram(readClassXMIFile(filePath), diagramType);

				break;
			case 3:
				diagram = new Diagram(readActivityXMIFile(filePath),
						diagramType);
				break;
			case 4:
				diagram = new Diagram(readStateMachineXMIFile(filePath),
						diagramType);
				break;
			default:
				break;
			}
		} catch (Exception e) {
			// exception
		}
		return diagram;
	}

	private String extractNames(List<Element> childrenElements, String id) {
		String name = null;
		for (Element element2 : childrenElements) {
			String[] attributeArray2 = extractAttributeValues(element2);
			if (element2.getName().equals("packagedElement")) {
				if (attributeArray2[1].equals(id)) {
					name = attributeArray2[2];
					return name;
				}
			}
		}
		return name;
	}

	private String[] extractAttributeValues(Element element) {
		List<Attribute> list = element.getAttributes();
		String[] attributeArray = new String[list.size()];
		for (int i = 0; i < list.size(); ++i) {
			attributeArray[i] = list.get(i).getValue();
		}
		return attributeArray;
	}

	private String[] extractChildAttributeValues(
			List<Element> childrenElements, String id) {
		String[] generalization = new String[2];
		for (Element element2 : childrenElements) {
			String[] attributeArray2 = extractAttributeValues(element2);
			if (element2.getName().equals("packagedElement")) {
				if (attributeArray2[1].equals(id)) {
					generalization[0] = attributeArray2[0];
					generalization[1] = attributeArray2[2];
					return generalization;
				}
			}
		}
		return generalization;
	}

//	public static void main(String[] args) throws JDOMException {
//		XMIFileParser parser = new XMIFileParser();
//		try {
//			parser.checkDiagramType("project7.xmi");
//			ArrayList<PackagedElement> output = parser
//					.readClassXMIFile("project7.xmi");
//			for (PackagedElement packagedElement : output) {
//				System.out.println(packagedElement);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (XMLError e) {
//			e.printStackTrace();
//		}
//	}

	public ArrayList<PackagedElement> getPackagedList() {
		return (ArrayList<PackagedElement>) packagedList;
	}

}