package compareUML;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jast.xml.XMLError;
import org.jdom2.JDOMException;

import fileHandler.XMIFileParser;

public class DiagramAssignment {
	private List<Diagram> diagrams = new ArrayList<Diagram>();
	private String username = "", studentName = "";
	
	public DiagramAssignment(List<String> xmiPaths) {
		XMIFileParser fileParser = new XMIFileParser();
		for (String path : xmiPaths) {
				diagrams.add(fileParser.readXMIFile(path));

		}
	}

}
