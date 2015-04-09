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
		
		for (Content node : nodeElementList) {
			
			String inPartition = null;
			String name = null;
			String incomingName = null;
			String outgoingName = null;
			boolean inputValue = false;
			boolean outputValue = false;
			List<Attribute> attributes = node.getAttributes();
			
			switch (attributes.get(0).getValue()) {
			case "uml:OpaqueAction":
				for (Attribute attribute : attributes) {
					if (attribute.getIdentifier().equals("inPartition")) {
						inPartition=NameIdMap.get(attribute.getValue());
					}
					if (attribute.getIdentifier().equals("outgoing")) {
						outgoingName=NameIdMap.get(attribute.getValue());
					}
					if (attribute.getIdentifier().equals("incoming")) {
						incomingName=NameIdMap.get(attribute.getValue());
					}
					if (node.hasContents()) {
						Element e = (Element) node.getContent(1);
						System.out.println(e);
					}
					
				}
				if (attributes.size()>3) {
					name = attributes.get(2).getValue();
				}

				PackagedElement oa = new ActionNodeElement(attributes.get(0).getValue(),
						attributes.get(1).getValue(),inPartition, name, 
						incomingName, outgoingName, inputValue, outputValue);
				result.add(oa);
				break;

			default:
				break;
			}
		}
		
		


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
