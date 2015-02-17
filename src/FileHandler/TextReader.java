package FileHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.util.ArrayList;

import com.sun.org.apache.regexp.internal.recompile;

public abstract class TextReader {

	public TextReader() {
		// TODO Auto-generated constructor stub
	}
	
	public static ArrayList<String> parseTextFile(String path) {
		ArrayList<String> result = new ArrayList<String>();
		BufferedReader textReader = null;
		try {
			textReader = new BufferedReader(new FileReader(path));
			String firstLine = textReader.readLine();
			result.add(firstLine.substring(firstLine.indexOf("(") + 1, firstLine.indexOf(")")));	// find out the name
			String lastLine = null;
			while (textReader.ready()) {
				lastLine = textReader.readLine();
				if (lastLine.indexOf("Filename: ") > -1) {
					result.add(lastLine.substring(lastLine.lastIndexOf("Filename: ") + 10));
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
		return result;
	}
	
	public static void main(String[] args) {
		ArrayList<String> a = TextReader.parseTextFile("UML Exercise 1  Requirements_aca12aa_"
			+ "attempt_2013-11-14-14-15-40.txt");
		System.out.println(a.get(0));
		System.out.println(a.get(1));

	}

}
