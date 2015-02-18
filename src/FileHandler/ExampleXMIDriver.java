package FileHandler;

import FileHandler.*;
import PackagedElements.AssociationElements;
import PackagedElements.PackagedElement;
import PackagedElements.UMLElement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.PackageElement;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class ExampleXMIDriver {
	// add .jar
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ExampleXMIDriver.readXMIFile();
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
	 */
	public static List<Element> readXMIFile() throws JDOMException, IOException {
		// initializtion
		SAXBuilder xmiBuilder = new SAXBuilder();
		Document document = xmiBuilder.build(new File("project9.xmi"));
		// get root element
		Element rootElement = document.getRootElement();
		
		
		// print all attributes
		System.out.println("\n");
		
		// get all children element
		List<Element> childrenElements = rootElement.getChildren();
		
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
			List<PackagedElement> packagedList = new ArrayList<PackagedElement>();
			if (attributeArray[0].equals("uml:Association")){
				/////////////
				String[] ownedEnd = new String[2];
				int i=0;
				List<Element> nextChildrenElements = element.getChildren();
				if (nextChildrenElements.size() > 0) {
					for (Element element2 : nextChildrenElements) {
						if (element2.getName().equals("ownedEnd")){
							ownedEnd[i] = element2.getAttributeValue("type");
							i++;
						}
					}
				}
				/////////
				packagedList.add(new AssociationElements( attributeArray[1], ownedEnd[0], ownedEnd[1]));
			}
			else{
				packagedList.add(new UMLElement(attributeArray[0], attributeArray[1], attributeArray[2]));
			}
			
			
			System.out.println(packagedList.get(packagedList.size() - 1));
			
			
			}
			
		}
		
		return childrenElements;
	}
	
	//--------------------------------------------------------------------------------

	public static void printElements(List<Element> list) {
		for (int i = 0; i < list.size(); ++i) {
			Element ele = list.get(i);
			String attrName = ele.getName();
			//System.out.println("Element : " + attrName);
		}
	}

	public static void print(String str) {
		
		System.out.println(str);
	}
}
