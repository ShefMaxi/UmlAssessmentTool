package fileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jast.xml.*;
import org.jast.xpath.*;

import com.sun.org.apache.bcel.internal.generic.I2F;

public class SynonymDictionary {
	private String filePath = "";
	private Map<String, List<String>> synonymDictionary = new HashMap<String, List<String>>();
	
	// constructor
	public SynonymDictionary(String xmlPath) {
		filePath = xmlPath;
		try {
			readXMLFile();
			System.out.println("no error.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("has error.");
		}
	}
	
	// accessor
	public Map<String, List<String>> getSynonymDictionary() {
		return synonymDictionary;
	}

	// read XML file
	private void readXMLFile() throws IOException, XMLError {
		// read file from path
		File xmiFile = new File(filePath);
		XMLReader reader = new XMLReader(xmiFile);
		org.jast.xml.Document document = reader.readDocument();

		// search dictionary
		XPath dictionaryPath = new XPath(
				"//dictionary/*");
		Iterator<Content> iterator = dictionaryPath.match(document).iterator();
		while (iterator.hasNext()) {
			Content content = iterator.next();
			if (content.getName().compareToIgnoreCase("word") == 0) {
				List<Content> contents = content.getContents();
				List<String> synonymStrings = new ArrayList<String>();
				String key = null;
				for (Content contentLine : contents) {
					if (contentLine.getName().compareToIgnoreCase("to") == 0) {
						synonymStrings.add(contentLine.getText());
					} else if (contentLine.getName().compareToIgnoreCase("from") == 0) {
						key = contentLine.getText();
					}
				}
				if (key != null) {
					this.synonymDictionary.put(key, synonymStrings);
				}
			}	
		}
	}
	
	public static void main(String[] args) {
		SynonymDictionary dictionary = new SynonymDictionary("C:/Users/Paul/Documents/GitHub/UmlAssessmentTool/UmlAssessmentTool/synonym.xml");
		System.out.println(dictionary.getSynonymDictionary());
	}
}
