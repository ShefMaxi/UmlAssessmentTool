package fileHandler;

import classElements.*;
import packagedElements.*;
import useCaseElements.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
	// usecase		 : 1
	// class		 : 2
	// activity		 : 3
	// statemachine	 : 4

	
	private ArrayList<PackagedElement> packagedList = null;

	private int checkDiagramType(String filePath) throws IOException, XMLError {
		File xmiFile = new File(filePath);
		XMLReader reader = new XMLReader(xmiFile);
		org.jast.xml.Document document = reader.readDocument();
		// reader.close();
		XPath usecasePath = new XPath(
				"//packagedElement[@xmi:type='uml:Actor']");
		XPath classPath = new XPath(
				"//packagedElement[@xmi:type='uml:Class']");
		XPath activityPath = new XPath(
				"//packagedElement[@xmi:type='uml:Activity']");
		XPath stateMachinePath = new XPath(
				"//packagedElement[@xmi:type='uml:StateMachine']");

		if (usecasePath.match(document).size() != 0) {
			System.out.println("usecase");
			return 1;
		} else if (classPath.match(document).size() != 0) {
			System.out.println("class");
			return 2;
		} else if (activityPath.match(document).size() != 0) {
			System.out.println("activity");
			return 3;
		} else if (stateMachinePath.match(document).size() != 0) {
			System.out.println("state machine");
			return 4;
		}

		return 0;
	}

	public static void main(String[] args) throws JDOMException {
		XMIFileParser parser = new XMIFileParser();
		try {
			parser.checkDiagramType("project7.xmi");
			ArrayList<PackagedElement> output = parser.readClassXMIFile("project7.xmi");
			for (PackagedElement packagedElement : output) {
				System.out.println(packagedElement);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XMLError e) {
			e.printStackTrace();
		}
	}

	private ArrayList<PackagedElement> readStateMachineXMIFile(String filePath)
			throws IOException, XMLError {

		ArrayList<PackagedElement> result = new ArrayList<>();
		File xmiFile = new File(filePath);
		XMLReader reader = new XMLReader(xmiFile);
		org.jast.xml.Document document = reader.readDocument();

		XPath query = new XPath("//region");
		List<Content> contentsList = query.match(document);
		Content rootContent = contentsList.get(0);

		HashMap<String, SubvertexElement> matchingMap = new HashMap<>();
		List<Content> allContents = rootContent.getContents();

		for (Content content : allContents) {
			if (content.getName().compareToIgnoreCase("subvertex") == 0) {
				List<org.jast.xml.Attribute> attributes = content
						.getAttributes();
				SubvertexElement element = new SubvertexElement(attributes.get(
						0).getValue(), attributes.get(1).getValue(), attributes
						.get(2).getValue());
				result.add(element);
				matchingMap.put(attributes.get(1).getValue(),
						(SubvertexElement) result.get(result.size() - 1));

			} else if (content.getName().compareToIgnoreCase("transition") == 0) {
				List<org.jast.xml.Attribute> attributes = content
						.getAttributes();
				TransitionElement element = new TransitionElement(attributes
						.get(0).getValue(), attributes.get(1).getValue(),
						matchingMap.get(attributes.get(2).getValue()),
						matchingMap.get(attributes.get(3).getValue()));
				if (attributes.size() == 5) {
					element.setGuard(new Guard(content.getContent(0)
							.getAttributes().get(1).getValue()));
				}
				result.add(element);
			}
		}

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
								String attr = childElement.getAttributeValue("name");
								String type = childElement.getChild("type").getAttributeValue("href");
								type = type.substring(type.lastIndexOf('#')+1, type.length());
								map.put(attr, type);
								attribute.add(map);
							}
							else if (childElement.getName().equals("ownedOperation")) {
								String attr = childElement.getAttributeValue("name");
								operation.add(attr);
							}
							else if (childElement.getName().equals("generalization")) {
								String generalizationId = childElement.getAttributeValue("general");
								generalization = extractChildAttributeValues(
										childrenElements, generalizationId)[1];
							}
						}
					}
					packagedList.add(new ClassElement(attributeArray[0], 
							attributeArray[2], operation, generalization, attribute));
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
								ownedEnd[i] = childElement.getAttributeValue("type");
								if(childElement.getAttributeValue("aggregation") != null) {
									if(childElement.getAttributeValue("aggregation").equals("shared"))
										type = "Aggregation";
									else if(childElement.getAttributeValue("aggregation").equals("composite"))
										type = "Composition";
								}
								if(childElement.getChild("lowerValue") != null) {
									if(childElement.getChild("lowerValue").getAttributeValue("value") != null) {
										lowerValue[i] = childElement.getChild("lowerValue")
												.getAttributeValue("value");
									}
									else 
										lowerValue[i] = "0";
								}
								else
									lowerValue[i] = "1";
								if(childElement.getChild("upperValue") != null) {
									if(childElement.getChild("upperValue").getAttributeValue("value") != null) {
										upperValue[i] = childElement.getChild("upperValue")
												.getAttributeValue("value");
									}
									else 
										upperValue[i] = "0";
								}
								else
									upperValue[i] = "1";
							}
							endRole[i] = childElement.getAttributeValue("name");
							i++;
						}
						firstMemberName = extractNames(childrenElements, ownedEnd[0]);
						secondMemberName = extractNames(childrenElements, ownedEnd[1]);
					}
					// please fix this error
					packagedList.add(new ClassAssociationElement(type, firstMemberName,
							lowerValue[0], upperValue[0], endRole[0], secondMemberName,
							lowerValue[1], upperValue[1], endRole[1]));
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
							//endRole[i] = childElement.getAttributeValue("name");
							if (childElement.getName().equals("ownedAttribute")) {
								String attr = childElement.getAttributeValue("name");
								String attrType = childElement.getChild("type").getAttributeValue("href");
								attrType = attrType.substring(attrType.lastIndexOf('#')+1, attrType.length());
								map.put(attr, attrType);
								attribute.add(map);
							}
							else if (childElement.getName().equals("ownedOperation")) {
								String attr = childElement.getAttributeValue("name");
								operation.add(attr);
							}
							else if (childElement.getName().equals("ownedEnd")) {
								ownedEnd[i] = childElement.getAttributeValue("type");
								if(childElement.getAttributeValue("aggregation") != null) {
									if(childElement.getAttributeValue("aggregation").equals("shared"))
										type = "AggregationClass";
									else if(childElement.getAttributeValue("aggregation").equals("composite"))
										type = "CompositionClass";
								}
								if(childElement.getChild("lowerValue") != null) {
									if(childElement.getChild("lowerValue").getAttributeValue("value") != null) {
										lowerValue[i] = childElement.getChild("lowerValue")
												.getAttributeValue("value");
									}
									else 
										lowerValue[i] = "0";
								}
								else
									lowerValue[i] = "1";
								if(childElement.getChild("upperValue") != null) {
									if(childElement.getChild("upperValue").getAttributeValue("value") != null) {
										upperValue[i] = childElement.getChild("upperValue")
												.getAttributeValue("value");
									}
									else 
										upperValue[i] = "0";
								}
								else
									upperValue[i] = "1";
								endRole[i] = childElement.getAttributeValue("name");
								i++;
							}
							//endRole[i] = childElement.getAttributeValue("name");
							//i++;
						}
						firstMemberName = extractNames(childrenElements, ownedEnd[0]);
						secondMemberName = extractNames(childrenElements, ownedEnd[1]);
					}
					packagedList.add(new AssociationClassElement(type, firstMemberName,
							lowerValue[0], upperValue[0], endRole[0], secondMemberName,
							lowerValue[1], upperValue[1], endRole[1], operation, attribute));
				}// end of class association
			}
		}
		return packagedList;
	}
	
	private ArrayList<PackagedElement> readUsecaseXMIFile(String filePath) throws JDOMException, IOException {
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
								String generalizationId = childElement.getAttributeValue("general");
								generalization = extractChildAttributeValues(
										childrenElements, generalizationId)[1];
							}
						}
					}
					packagedList.add(new GeneralizableElement(attributeArray[0],
							attributeArray[1], attributeArray[2], generalization));
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
								String generalizationId = childElement.getAttributeValue("general");
								generalization = extractChildAttributeValues(
										childrenElements, generalizationId)[1];
							}
							if (childElement.getName().equals("include")) {
							String inludeAdditionId = childElement.getAttributeValue("addition");
								inludeAddition = extractChildAttributeValues(
										childrenElements, inludeAdditionId)[1];
							}
							if (childElement.getName().equals("extend")) {
								String excludeAdditionnId = childElement.getAttributeValue("extendedCase");
								extensionAddition = extractChildAttributeValues(
										childrenElements,excludeAdditionnId)[1];
							}
							if (childElement.getName().equals("extensionPoint")) {
								String extensionPoint = childElement.getAttributeValue("name");
								extensionPoints.add(extensionPoint);
							}
						}
					}
					packagedList.add(new UseCaseElement(attributeArray[0], attributeArray[1], attributeArray[2],
							generalization, inludeAddition, extensionAddition, extensionPoints));
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
								ownedEnd[i] = childElement.getAttributeValue("type");
								i++;
							}
							firstMember = extractChildAttributeValues(childrenElements, ownedEnd[0]);
							secondMember = extractChildAttributeValues(childrenElements, ownedEnd[1]);
						}
					}
					packagedList.add(new AssociationElement(attributeArray[1], firstMember[1],
							secondMember[1], firstMember[0], secondMember[0]));
				}// end of association
			}
		}
		return packagedList;
		
	}
	
	private ArrayList<PackagedElement> readActivityXMIFile(String filePath) {
		return new ArrayList<>();
	}
	
	public Diagram readXMIFile(String filePath) throws IOException, XMLError, JDOMException {
		Diagram diagram = null;
		int diagramType = this.checkDiagramType(filePath);
		switch (diagramType) {
		case 1:
			diagram = new Diagram(readUsecaseXMIFile(filePath), diagramType);
			break;
		case 2:
			diagram = new Diagram(readClassXMIFile(filePath), diagramType);

			break;
		case 3:
			diagram = new Diagram(readActivityXMIFile(filePath), diagramType);
			break;
		case 4:
			diagram = new Diagram(readStateMachineXMIFile(filePath), diagramType);
			break;
		default:
			break;
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

	public ArrayList<PackagedElement> getPackagedList() {
		return (ArrayList<PackagedElement>) packagedList;
	}

}