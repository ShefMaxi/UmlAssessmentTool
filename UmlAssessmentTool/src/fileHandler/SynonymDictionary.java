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
	private boolean isCorrect = true;
	
	
	// constructor
	public SynonymDictionary(String xmlPath) {
		filePath = xmlPath;
		try {
			readXMLFile();
		} catch (Exception e) {
			e.printStackTrace();
			this.isCorrect = false;
		}
	}
	
	// accessors
	public Map<String, List<String>> getSynonymDictionary() {
		return synonymDictionary;
	}
	
	//check if the dictionary is correct
	public boolean checkDictionary() {
		return isCorrect;
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
		
		// if can't find dictionary
		if (iterator.hasNext() == false) {
			this.isCorrect = false;
		}
		
		while (iterator.hasNext()) {
			// each word
			Content content = iterator.next();
			
			if (content.getName().compareToIgnoreCase("word") == 0) {
				List<Content> contents = content.getContents();
				List<String> synonymStrings = new ArrayList<String>();
				String key = null;
				for (Content contentLine : contents) {
					if (contentLine.getName().compareToIgnoreCase("to") == 0) {
						synonymStrings.add(contentLine.getText());
					} else if (contentLine.getName().compareToIgnoreCase("from") == 0) {
						// if more than duplicate from exist in one word
						if (key != null) {
							this.isCorrect = false;
						}
						key = contentLine.getText();
					} else {
						// if unrelated content exist
						this.isCorrect = false;
					}
				}
				if (key != null && synonymStrings.size() != 0) {
					this.synonymDictionary.put(key, synonymStrings);
				} else {
					// if there is no from/ no to in one word
					this.isCorrect = false;
				}
			}
		}
	}
	public static void main(String[] args) {
		SynonymDictionary dictionary = new SynonymDictionary("C:/Users/Paul/Documents/GitHub/UmlAssessmentTool/UmlAssessmentTool/synonym.xml");
		System.out.println(dictionary.isCorrect);
		System.out.println(dictionary.getSynonymDictionary());
		String aString = "C:/Users/Paul/Documents/GitHub/UmlAssessmentTool/UmlAssessmentTool/synonym.xml";
		System.out.println(aString.substring(aString.lastIndexOf(".")));
	}

}
