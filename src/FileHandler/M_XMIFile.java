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
import org.jdom2.input.SAXBuilder;

public class M_XMIFile {
	
	public static List<PackagedElement> packagedList = new ArrayList<PackagedElement>();
	
	public static void readXMIFile(String fileName) throws JDOMException, IOException {
		
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
									
									generalization = extractChildAttributeValues(childrenElements, generalizationId);
								}
							}
						}
						
						packagedList.add(new GeneralizableElement(attributeArray[0], attributeArray[1],
								attributeArray[2], generalization));
						System.out.println(attributeArray[0]+" # "+attributeArray[1]+" # "
								+attributeArray[2]+" # "+generalization);
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
									
									generalization = extractChildAttributeValues(childrenElements, generalizationId);
								}
								
								if (childElement.getName().equals("include")) {
									
									String inludeAdditionId = childElement.getAttributeValue("addition");
									
									inludeAddition = extractChildAttributeValues(childrenElements, inludeAdditionId);
								}
								
								if (childElement.getName().equals("extend")) {
									
									String excludeAdditionnId = childElement.getAttributeValue("extendedCase");
									
									extensionAddition = extractChildAttributeValues(childrenElements, excludeAdditionnId);
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
						System.out.println(attributeArray[0]+" # "+attributeArray[1]+" # "+attributeArray[2]
								+" # "+generalization+" # "+inludeAddition+" # "+extensionAddition
								+" # "+extensionPoints);
					}// end of usecase
					
					if (attributeArray[0].equals("uml:Association")) {
						
						String firstMember=null;
						
						String secondMember=null;
						
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
						
						packagedList.add(new AssociationElement(attributeArray[1], firstMember, secondMember));
						System.out.println(attributeArray[0]+" # "+attributeArray[1]+" # "+firstMember+" # "+secondMember);
					}// end of association
					
				}// end of UseCase diagram
				
				//else if (){} // for other types of UML diagrams
			}
		}
	}
	
	public static String[] extractAttributeValues(Element element) {
			
			List<Attribute> list = element.getAttributes();
			
			String[] attributeArray = new String[list.size()];
			
			for (int i = 0; i < list.size(); ++i) {
				
				attributeArray[i] = list.get(i).getValue();
			}
			
			return attributeArray;
	}
	
	public static String extractChildAttributeValues(List<Element> childrenElements, String id) {
		
		String generalization=null;
		
		for (Element element2 : childrenElements) {
			
			String[] attributeArray2 = extractAttributeValues(element2);
			
			if (element2.getName().equals("packagedElement")) {
				
				if (attributeArray2[1].equals(id)) {
					
					generalization=attributeArray2[2];
				}
			}
		}
		
		return generalization;
	}
	
	public List<PackagedElement> getPackagedList() {
		
		return packagedList;
	}
	
	public static void main(String[] args) throws JDOMException, IOException {
		
		M_XMIFile.readXMIFile("project1.xmi");
	}
}