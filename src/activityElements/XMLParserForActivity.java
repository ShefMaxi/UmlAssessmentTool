package activityElements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jast.xml.*;
import org.jast.xpath.*;

import stateMachineElements.Guard;
import stateMachineElements.SubvertexElement;
import stateMachineElements.TransitionElement;
import packagedElements.PackagedElement;

public class XMLParserForActivity {
	
	
	
	public static ArrayList<PackagedElement> readStateMachineXMIFile(String filePath)
			throws IOException, XMLError {

		HashMap<String, String> NameIdMap = new HashMap<>();
		
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
		
		
		
		
//		List<Content> allContents = rootContent.getContents();

//		for (Content content : allContents) {
//			if (content.getName().compareToIgnoreCase("subvertex") == 0) {
//				List<org.jast.xml.Attribute> attributes = content
//						.getAttributes();
//				SubvertexElement element = new SubvertexElement(attributes.get(
//						0).getValue(), attributes.get(1).getValue(), attributes
//						.get(2).getValue());
//				result.add(element);
//				matchingMap.put(attributes.get(1).getValue(),
//						(SubvertexElement) result.get(result.size() - 1));
//
//			} else if (content.getName().compareToIgnoreCase("transition") == 0) {
//				List<org.jast.xml.Attribute> attributes = content
//						.getAttributes();
//				TransitionElement element = new TransitionElement(attributes
//						.get(0).getValue(), attributes.get(1).getValue(),
//						matchingMap.get(attributes.get(2).getValue()),
//						matchingMap.get(attributes.get(3).getValue()));
//				if (attributes.size() == 5) {
//					element.setGuard(new Guard(content.getContent(0)
//							.getAttributes().get(1).getValue()));
//				}
//				result.add(element);
//			}
//		}

		return result;
	}
	
	public static void main(String[] args) {
		
		try {
			System.out.println
			(XMLParserForActivity.readStateMachineXMIFile("/Users/zhangyan/GitHub/UmlAssessmentTool/activity diagram.xmi"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
