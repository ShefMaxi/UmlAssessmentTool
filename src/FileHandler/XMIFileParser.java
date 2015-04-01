package FileHandler;

import PackagedElements.PackagedElement;
import UseCaseElements.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.ElementFilter;
import org.jdom2.input.SAXBuilder;

public class XMIFileParser {
	// usecase 		: 1
	// class  		: 2
	// activity		: 3
	// statemachine : 4
	
	private List<PackagedElement> packagedList= null;
	
	public void readXMIFile(String fileName) throws JDOMException, IOException {
		packagedList = new ArrayList<PackagedElement>();
		SAXBuilder xmiBuilder = new SAXBuilder();
		
		Document document = xmiBuilder.build(new File(fileName));
		
		Element rootElement = document.getRootElement();
		
		List<Element> childrenElements = rootElement.getChildren();
		
		for (Element element : childrenElements) {
			
			String[] attributeArray = extractAttributeValues(element);
			
			if (element.getName().equals("packagedElement")) {
				
				if (attributeArray[0].equals("uml:Actor") || attributeArray[0].equals("uml:UseCase")
						|| attributeArray[0].equals("uml:Association")) {
					
					if (attributeArray[0].equals("uml:Actor")) {
						
						String generalization=null;
						
						List<Element> nextChildrenElements = element.getChildren();
						
						if (nextChildrenElements.size()>0) {
							
							for (Element childElement: nextChildrenElements) {
								
								if (childElement.getName().equals("generalization")) {
									
									String generalizationId = childElement.getAttributeValue("general");
									
									generalization = extractChildAttributeValues(childrenElements, generalizationId)[1];
								}
							}
						}
						
						packagedList.add(new GeneralizableElement(attributeArray[0], attributeArray[1],
								attributeArray[2], generalization));
					}// end of actor
					
					if (attributeArray[0].equals("uml:UseCase")) {
						
						String generalization=null;
						
						String inludeAddition=null;
						
						String extensionAddition=null;
						
						ArrayList<String> extensionPoints=new ArrayList<String>();
						
						List<Element> nextChildrenElements = element.getChildren();
						
						if (nextChildrenElements.size()>0) {
							
							for (Element childElement: nextChildrenElements) {
								
								if (childElement.getName().equals("generalization")) {
									
									String generalizationId = childElement.getAttributeValue("general");
									
									generalization = extractChildAttributeValues(childrenElements, generalizationId)[1];
								}
								
								if (childElement.getName().equals("include")) {
									
									String inludeAdditionId = childElement.getAttributeValue("addition");
									
									inludeAddition = extractChildAttributeValues(childrenElements, inludeAdditionId)[1];
								}
								
								if (childElement.getName().equals("extend")) {
									
									String excludeAdditionnId = childElement.getAttributeValue("extendedCase");
									
									extensionAddition = extractChildAttributeValues(childrenElements, excludeAdditionnId)[1];
								}
								if (childElement.getName().equals("extensionPoint")) {
									
									String extensionPoint = childElement.getAttributeValue("name");
									
									extensionPoints.add(extensionPoint);
								}
							}
						}
						
						packagedList.add(new UseCaseElement(attributeArray[0], attributeArray[1],
								attributeArray[2], generalization, inludeAddition, extensionAddition,
								extensionPoints));
					}// end of usecase
					
					if (attributeArray[0].equals("uml:Association")) {
						
						String[] firstMember=null;
						String[] secondMember=null;
						String[] ownedEnd = new String[2];
						
						int i=0;
						
						List<Element> nextChildrenElements = element.getChildren();
						
						if (nextChildrenElements.size()>0) {
							
							for ( Element childElement: nextChildrenElements) {
								
								if (childElement.getName().equals("ownedEnd")) {
									
									ownedEnd[i] = childElement.getAttributeValue("type");
									
									i++;
								}
									
								firstMember = extractChildAttributeValues(childrenElements, ownedEnd[0]);
								
								secondMember = extractChildAttributeValues(childrenElements, ownedEnd[1]);
								}
							}
						
						packagedList.add(new AssociationElement(attributeArray[1], firstMember[1], secondMember[1], firstMember[0], secondMember[0]));
					}// end of association
					
				}// end of UseCase diagram
				
				//else if (){} // for other types of UML diagrams
			}
		}
	}
	
	private String[] extractAttributeValues(Element element) {
			
			List<Attribute> list = element.getAttributes();
			
			String[] attributeArray = new String[list.size()];
			
			for (int i = 0; i < list.size(); ++i) {
				
				attributeArray[i] = list.get(i).getValue();
			}
			
			return attributeArray;
	}
	
	private String[] extractChildAttributeValues(List<Element> childrenElements, String id) {
		
		String[] generalization= new String[2];
		
		for (Element element2 : childrenElements) {
			
			String[] attributeArray2 = extractAttributeValues(element2);
			
			if (element2.getName().equals("packagedElement")) {
				
				if (attributeArray2[1].equals(id)) {
					generalization[0] = attributeArray2[0];
					generalization[1]=attributeArray2[2];
					return generalization;
				}
			}
		}
		
		return generalization;
	}
	
	public ArrayList<PackagedElement> getPackagedList() {
		
		return (ArrayList<PackagedElement>)packagedList;
	}

	public int checkDiagramType(String filePath) throws JDOMException, IOException {
		SAXBuilder xmiBuilder = new SAXBuilder();
		Document document = xmiBuilder.build(new File(filePath));
		Element root = document.getRootElement();
		ElementFilter filter = new org.jdom2.filter.ElementFilter("usecase");
		for (Element element : root.getDescendants(filter)) {
			System.out.println(element.getTextNormalize());
		}
		return 0;
	}
	
	public List<PackagedElement> readStateMachineXMIFile() {
		return new ArrayList<>();
	}

	public static void main(String[] args) {
		XMIFileParser parser = new XMIFileParser();
		try {
			parser.checkDiagramType("maxitester1.xmi");
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}