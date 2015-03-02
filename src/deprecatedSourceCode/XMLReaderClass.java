package deprecatedSourceCode;

import java.awt.print.Printable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.AttributeType;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import PackagedElements.PackagedElement;
import UseCaseElements.AssociationElement;
import UseCaseElements.GeneralizableElement;

public class XMLReaderClass {

	public XMLReaderClass() {
		// TODO Auto-generated constructor stub
	}
	public void readXMI(){
		
	}
	public static List<PackagedElement> readXMIFile() throws JDOMException, IOException {
	
		SAXBuilder xmiBuilder = new SAXBuilder();
		Document document = xmiBuilder.build(new File("project9.xmi"));
		// get root element
		Element rootElement = document.getRootElement();
		
		List<Element> childList= rootElement.getChildren();
		
		List<PackagedElement> packagedList = new ArrayList<PackagedElement>();

		for (Element element: childList){
			if(element.getName().equals("packagedElement"));
			List<Attribute> list = element.getAttributes();
			String [] AllAttributeValues = new String[list.size()];
			String [] AllAttributeName = new String[list.size()];
			for(int i=0; i<list.size(); i++){
				Attribute attribute= (Attribute)list.get(i);
				String attrName = attribute.getName();
				String attrValue = attribute.getValue();
				AllAttributeName[i] = attrName;
				AllAttributeValues[i] = attrValue;
				}
			List<Element> nextChildrenElements = element.getChildren();
		
			if (AllAttributeValues[0].equals("uml:Association")){
				/////////////
				String[] ownedEnd = new String[2];
				int i=0;
				
				if (nextChildrenElements.size() > 0) {
					for (Element element2 : nextChildrenElements) {
						if (element2.getName().equals("ownedEnd")){
							ownedEnd[i] = element2.getAttributeValue("type");
							i++;
							}
						}
				}
				packagedList.add(new AssociationElement( AllAttributeValues[1], ownedEnd[0], ownedEnd[1]));
			}
			 if (AllAttributeValues[0].equals("uml:Actor")){
				String [] generalization =new String[2];
				int g=0;
				if(nextChildrenElements.size()>0){
					for (Element element3: nextChildrenElements){
						if (element3.getName().equals("generalization")){
							generalization[g]=element3.getAttributeValue("general");
							g++;
						}
					}
				}
				packagedList.add(new GeneralizableElement(  AllAttributeValues[0],AllAttributeValues[1], AllAttributeValues[2], generalization[1]));
			}
		 if (AllAttributeValues[0].equals("uml:UseCase")){
			
		}
		}
		
		System.out.println(packagedList);
		return packagedList;
	}
	public static void main(String args[]) throws JDOMException{
		try
		{
		XMLReaderClass.readXMIFile();
	} catch(IOException e)
		{
		System.out.println("were here");
		}
	}
}
