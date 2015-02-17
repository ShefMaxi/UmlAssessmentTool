package FileHandler;
//import ExampleXMIDriver;
//import ExtractZipContents;

import java.io.File;


public class ExtractFileTest {

	public ExtractFileTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ExtractZipContents extractZipContent = new ExtractZipContents();
		
		extractZipContent.extractFile("gradebook.zip");
		try {
			ExampleXMIDriver.readXMIFile();
			System.out.println("READ.");
			//ExampleXMIDriver.print(list);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Can't read.");
		}
	}

}
