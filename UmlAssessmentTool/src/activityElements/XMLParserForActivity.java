package activityElements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jast.xml.*;
import org.jast.xpath.*;

import packagedElements.PackagedElement;

public class XMLParserForActivity {
	
	
	
	public static ArrayList<PackagedElement> readActivityXMIFile(String filePath)
			throws IOException, XMLError {

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

		if (nodeElementList!=null) {
			for (Content content : nodeElementList) {
				List<Attribute> attributes = content.getAttributes();
				if (attributes.size()>2) {
					String id = attributes.get(1).getValue();
					String name = attributes.get(2).getValue();
					NameIdMap.put(id, name);
				}
				Element e = (Element)content;
				if (e.hasChildren()) {
					Element inputV = e.getChild("inputValue");
					if (inputV!=null) {
						NameIdMap.put(inputV.getAttribute("xmi:id").getValue(), 
								inputV.getAttribute("name").getValue());
					}
				
					Element outputV = e.getChild("outputValue");
					if (outputV!=null) {
						NameIdMap.put(outputV.getAttribute("xmi:id").getValue(), 
								outputV.getAttribute("name").getValue());
					}
					
				}
			}
		}
		if (edgeElementList!=null) {
			for (Content content : edgeElementList) {
				List<Attribute> attributes = content.getAttributes();
				if (attributes.size()>2) {
					String id = attributes.get(1).getValue();
					String name = attributes.get(2).getValue();
					NameIdMap.put(id, name);
				}
				//.......................Salisu.......................
				Element e2 = (Element)content;
				if (e2.hasChildren()) {
					Element weight = e2.getChild("weight");
					if (weight!=null) {
						NameIdMap.put(weight.getAttribute("xmi:id").getValue(), 
								weight.getAttribute("value").getValue());
					}
				}	
			}
		}
		if (groupElementList!=null) {
			for (Content content : groupElementList) {
				List<Attribute> attributes = content.getAttributes();
				if (attributes.size()>2) {
					String id = attributes.get(1).getValue();
					String name = attributes.get(2).getValue();
					NameIdMap.put(id, name);
				}
			}
		}
		
		
		
		System.out.println(NameIdMap);
		
		for (Content node : nodeElementList) {
			
			String inPartition = null;
			String name = null;
			String incomingName = null;
			String outgoingName = null;
			boolean inputValue = false;
			boolean outputValue = false;
			List<Attribute> attributes = node.getAttributes();
			
			Element nodeElement = (Element)node;
			// extracting inPartition from current node element
			Attribute ip = nodeElement.getAttribute("inPartition");
			if (ip!=null) {
				inPartition=NameIdMap.get(ip.getValue());
			}
			
			// extracting outgoing from current node element
			Attribute og = nodeElement.getAttribute("outgoing");
			if (og!=null) {
				outgoingName=NameIdMap.get(og.getValue());
			}
			
			// extracting incoming from current node element
			Attribute ic = nodeElement.getAttribute("incoming");
			if (ic!=null) {
				incomingName=NameIdMap.get(ic.getValue());
			}

			// extracting name from current node element
			Attribute nm = nodeElement.getAttribute("name");
			if (nm!=null) {
				name = nm.getValue();
			}
			switch (attributes.get(0).getValue()) {
			
			//***************************************************ActionNodeElement and Pins**************/
			case "uml:CallOperationAction":
			case "uml:CallBehaviorAction":
			case "uml:OpaqueAction":

				
				
				// extracting inputValue from current node element if exists
				Element iv = nodeElement.getChild("inputValue");
				if (iv!=null) {
					inputValue=true;
					String ipId = null;
					String ipName = null;
					String ipIncoming = null;
					String iN = null;
					
					Attribute iId = iv.getAttribute("id");
					if (iId!=null) {
						ipId = iId.getValue();
					}
					
					Attribute iName = iv.getAttribute("name");
					if (iName!=null) {
						ipName = iName.getValue();
					}
					
					Attribute iIncoming = iv.getAttribute("incoming");
					if (iIncoming!=null) {
						ipIncoming = iIncoming.getValue();
						iN=NameIdMap.get(ipIncoming);
	 
					}
					
					
					PackagedElement ivp = new InputPinElement("inputPin", ipId, inPartition, ipName, iN);
					result.add(ivp);
				}
				
				// extracting outputValue from current node element if exists
				Element ov = nodeElement.getChild("outputValue");
				if (ov!=null) {
					outputValue=true;
					String ipId = null;
					String ipName = null;
					String ipOutgoing = null;
					String oN = null;
					
					Attribute iId = ov.getAttribute("id");
					if (iId!=null) {
						ipId = iId.getValue();
					}
					
					Attribute iName = ov.getAttribute("name");
					if (iName!=null) {
						ipName = iName.getValue();
					}
					
					Attribute iOutgoing = ov.getAttribute("incoming");
					if (iOutgoing!=null) {
						ipOutgoing = iOutgoing.getValue();
						oN=NameIdMap.get(ipOutgoing);
					}
					PackagedElement ovp = new OutputPinElement("outputValue", ipId, inPartition, ipName, oN);
					result.add(ovp);
				}
				
				PackagedElement oa = new ActionNodeElement(attributes.get(0).getValue(),
						attributes.get(1).getValue(),inPartition, name, 
						incomingName, outgoingName, inputValue, outputValue);
				result.add(oa);
				break;
				
			//*****************************************************AcceptSignalElement***********/
			case "uml:AcceptCallAction":
			case "uml:AcceptEventAction":
				
				PackagedElement aea = new AcceptSignalElement(attributes.get(0).getValue(), 
						attributes.get(1).getValue(),inPartition, name, outgoingName);
				result.add(aea);
				break;
				
			//*****************************************************ActivityFinalNodeElement*****/	
			case "uml:ActivityFinalNode":
				
				PackagedElement afn = new ActivityFinalNodeElement(attributes.get(0).getValue(), 
						attributes.get(1).getValue(), inPartition, outgoingName, incomingName);
				result.add(afn);
				break;
				
			//*****************************************************CentralBufferNode*****/	

			default:
				break;
			}
		}
		//.................Salisu......................................
		for (Content edge : edgeElementList) {
			
			
			String type = null;
			String name = null;
			String Id = null;
			String sourceNodeName = null;
			String targetNodeName = null;
			boolean weight = false;	// not needed in compare class, may be later
			
			
			Element edgeElement = (Element)edge;
			
			// extracting name from current node element
				Attribute nm = edgeElement.getAttribute("name");
				if (nm!=null) {
					name = nm.getValue();
				}

				// extracting ID from current node element
					Attribute id = edgeElement.getAttribute("xmi:id");
					if (nm!=null) {
						Id = id.getValue();
					}
					// extracting type from current edge element
					Attribute typ = edgeElement.getAttribute("xmi:id");
					if (nm!=null) {
						type = typ.getValue();
					}

			// extracting SourceNode from current edge element
			Attribute source = edgeElement.getAttribute("source");
			if (source!=null) {
				sourceNodeName=NameIdMap.get(source.getValue());
			}
			
			// extracting incoming from current edge element
			Attribute target = edgeElement.getAttribute("target");
			if (target!=null) {
				targetNodeName=NameIdMap.get(target.getValue());
			}
			Element iv = edgeElement.getChild("weight");
			if (iv!=null) {
				weight=true;
				
				String wiId = null;  // not needed in compare class
				String value = null;	// not needed in compare class
				
				
				Attribute iId = iv.getAttribute("xmi:id");
				if (iId!=null) {
					wiId = iId.getValue();
				}
				
				Attribute vl = iv.getAttribute("value");
				if (vl!=null) {
					value = vl.getValue();
				}
				PackagedElement edg= new EdgeElements(type, Id, name, sourceNodeName, targetNodeName);
				result.add(edg);
			}
			for (Content group : groupElementList) {
				
				
				String gtype = null;
				String gname = null;
				String gId = null;
			  //String Node = null;
				
				
				Element groupElement = (Element)group;
				
				// extracting name from current group element
					Attribute gnm = groupElement.getAttribute("name");
					if (gnm!=null) {
						gname = gnm.getValue();
					}

					// extracting ID from current group element
						Attribute gid = edgeElement.getAttribute("xmi:id");
						if (gid!=null) {
							gId = gid.getValue();
						}
						// extracting type from current group element
						Attribute gtyp = edgeElement.getAttribute("xmi:type");
						if (gtyp!=null) {
							gtype = gtyp.getValue();
						}
			
			PackagedElement grp= new GroupElements(gtype, gId, gname);
			result.add(grp);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		try {
			System.out.println
			(XMLParserForActivity.readActivityXMIFile("C:/Users/Salisu/Documents/GitHub/UmlAssessmentTool/UmlAssessmentTool/ActivitySimple.xmi"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
