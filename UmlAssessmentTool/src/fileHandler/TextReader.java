package fileHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

// an example of how to use this class is provided in the bottom

public class TextReader {
	private Map<String, String> studentInfoMap = new HashMap<>();
	private Map<String, String> studentFilePathMap = new HashMap<>();
	
	public TextReader(List<String> textFilePaths) {
		// process all text files
		for (String textFile : textFilePaths) {
			parseTextFile(textFile);
		}
	}
	
	// accessors
	public Map<String, String> getStudentFilePathMap() {
		return studentFilePathMap;
	}
	
	public Map<String, String> getStudentInfoMap() {
		return studentInfoMap;
	}
	
	
	public void parseTextFile(String path) {
		BufferedReader textReader = null;
		try {
			textReader = new BufferedReader(new FileReader(path));
			
			String rootPath = "";
			if (path.contains("\\")) {
				rootPath = path.substring(0, path.lastIndexOf("\\") + 1);
			} else {
				rootPath = path.substring(0, path.lastIndexOf("/") + 1);
			}
			
			String firstLine = textReader.readLine();
			// find username and student name
			String studentUsername = firstLine.substring(firstLine.indexOf("(") + 1, firstLine.indexOf(")"));	
			String studentName = firstLine.substring(firstLine.indexOf(" ") + 1, firstLine.indexOf("(") - 1);
			this.studentInfoMap.put(studentUsername, studentName);
			
			String lastLine = "";
			while (textReader.ready()) {
				lastLine = textReader.readLine();
				if (lastLine.indexOf("Filename: ") > -1) {
					this.studentFilePathMap.put(studentUsername, rootPath + lastLine.substring(lastLine.indexOf(":") + 2));
					break;
				}
			}
			
		} catch (IOException e) {
			System.err.println("File not found.");
		} finally {
			try {
				textReader.close();
			} catch (IOException e2) {
				System.err.println("fail to close file.");
			}
		}
		return;
	}
	
	/*
	 * This is an example of how to use TextReader
	 */
	
//	public static void main(String[] args) {
//		
//		ArrayList<String> a = new ArrayList<>();
//		a.add("C:/Users/Paul/Documents/GitHub/UmlAssessmentTool/UmlAssessmentTool/UML Exercise 1  Requirements_aca12aa_attempt_2013-11-14-14-15-40.txt");
//		TextReader reader = new TextReader(a);
//		reader.getStudentFilePathMap();
//		reader.getStudentInfoMap();
//
//	}

}
