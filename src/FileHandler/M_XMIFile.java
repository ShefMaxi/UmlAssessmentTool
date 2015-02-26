package FileHandler;

import PackagedElements.AssociationElements;
import PackagedElements.PackagedElement;
import PackagedElements.UMLElement;
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
						
						String excludeAddition=null;
						
						String extensionPoint=null;
						
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
									
									excludeAddition = extractChildAttributeValues(childrenElements, excludeAdditionnId);
								}
								if (childElement.getName().equals("extensionPoint")) {
									
									extensionPoint = childElement.getAttributeValue("name");
								}
							}
						}
						
						packagedList.add(new UseCaseElement(attributeArray[0], attributeArray[1],
								attributeArray[2], generalization, inludeAddition, excludeAddition,
								extensionPoint));
						System.out.println(attributeArray[0]+" # "+attributeArray[1]+" # "+attributeArray[2]
								+" # "+generalization+" # "+inludeAddition+" # "+excludeAddition
								+" # "+extensionPoint);
					}// end of usecase
					
					////////////////////////////////////////////association
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
		
		M_XMIFile.readXMIFile("project9.xmi");
		
		//System.out.println(packagedList);
	}
}


///////////////////////////////////////////////////////////////////////////////////////////////
/*public class M_XMIFile {
	// add .jar
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			List<PackagedElement> a = M_XMIFile.readXMIFile();
			a.toString();
			System.out.println("READ.");
			//ExampleXMIDriver.print(list);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Can't read.");
		}
	}

	/**
	 * @throws JDOMException
	 * @throws IOException
	 *\/
	public static List<PackagedElement> readXMIFile() throws JDOMException, IOException {
		// initializtion
		SAXBuilder xmiBuilder = new SAXBuilder();
		Document document = xmiBuilder.build(new File("project11.xmi"));
		// get root element
		Element rootElement = document.getRootElement();
		
		
		// print all attributes
		System.out.println("\n");
		
		// get all children element
		List<Element> childrenElements = rootElement.getChildren();
		List<PackagedElement> packagedList=null;
		packagedList = new ArrayList<PackagedElement>();

		// print the attributes of all elements
		for (Element element : childrenElements) {
			if (element.getName().equals("packagedElement")){
			System.out.println("\nnext element: ");
			
			//////////////////////////////////////////////////////////////////
			List<Attribute> list = element.getAttributes();
			
			
			String[] attributeArray = new String[list.size()];
			for (int i = 0; i < list.size(); ++i) {
				Attribute attr = (Attribute) list.get(i);
				String attrName = attr.getName();
				String attrValue = attr.getValue();
				attributeArray[i] = attrValue;
				

			}
			//List<PackagedElement>
			if (attributeArray[0].equals("uml:Association")){
				/////////////
				String[] ownedEnd = new String[2];
				int i=0;
				List<Element> nextChildrenElements = element.getChildren();
				if (nextChildrenElements.size() > 0) {
					for (Element element2 : nextChildrenElements) {
						if (element2.getName().equals("ownedEnd")){
							
							ownedEnd[i] = element2.getAttributeValue("type");
							//////////////////
							/*for(PackagedElement p : packagedList){
								String temp = p.getId();
								if (ownedEnd[i].equals(temp))
									ownedEnd[i]=p.getType();
							}*\/
								//System.out.println(p.getId());
							//////////////////
							i++;
						}
					}
				}
				///////////////////
				
				/////////
				packagedList.add(new AssociationElements( attributeArray[1], ownedEnd[0], ownedEnd[1]));
			}
			else{
				packagedList.add(new UMLElement(attributeArray[0], attributeArray[1], attributeArray[2]));
			}
			
			
			System.out.println(packagedList.get(packagedList.size() - 1));
			
			
			}
			
		}//for(AssociationElements a : packagedList)
			//System.out.println(a);
		//for(PackagedElement p : packagedList)
			//System.out.println(p.getId());
		//System.out.println(packagedList);
		return packagedList;
	}
	
	//--------------------------------------------------------------------------------


}*/
