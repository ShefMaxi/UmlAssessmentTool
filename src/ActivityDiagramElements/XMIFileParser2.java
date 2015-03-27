package ActivityDiagramElements;

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

public class XMIFileParser2 {
	
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
					
					if (attributeArray[0].equals("uml:Activity")) {
						
						String sourceNodeName=null;
						String targetNodeName=null;
						
						List<Element> nextChildrenElements = element.getChildren();
						
						if (nextChildrenElements.size()>0) {
							
							for (Element childElement: nextChildrenElements) {
								
								if (childElement.getName().equals("edge")) {
									String type = childElement.getAttributeValue("xmi:type");
									String id = childElement.getAttributeValue("xmi:id");
									String name = childElement.getAttributeValue("name");
									String source = childElement.getAttributeValue("source");
									String target = childElement.getAttributeValue("target");
									
									sourceNodeName = extractChildAttributeValues(childrenElements, source)[1];
									targetNodeName = extractChildAttributeValues(childrenElements, target)[1];
									packagedList.add(new EdgeElements(type, id,name, sourceNodeName, targetNodeName));
								}
								
								if (childElement.getName().equals("group")) {
									String type = childElement.getAttributeValue("xmi:type");
									String id = childElement.getAttributeValue("xmi:id");
									
									String name= childElement.getAttributeValue("name");
										packagedList.add(new GroupElements(type, id,name));
									//group = extractChildAttributeValues(childrenElements, groupName)[1];
								}
								
								if (childElement.getName().equals("node")) {
									
									String type = childElement.getAttributeValue("xmi:type");
									String id = childElement.getAttributeValue("xmi:id");
									
									String name= childElement.getAttributeValue("name");
									String incoming = childElement.getAttributeValue("incoming");
									String outgoing = childElement.getAttributeValue("outgoing");
									
									String incomingNodeName = extractChildAttributeValues(childrenElements, incoming)[1];
									String outgoingNodeName = extractChildAttributeValues(childrenElements, outgoing)[1];
								}
								
							}
						}
						
						//packagedList.add(new ActivityDiagramElements(attributeArray[0], attributeArray[1],attributeArray[2], node, edge, group));
					}// end of usecase
					
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
}
