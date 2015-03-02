package deprecatedSourceCode;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.io.*;

public class testZipFiles {

	public  static List<String>  extractFile(String inputFile, String destinationname ){
		
		List<String> list = new ArrayList<String>();
		
		try {
			
			ZipFile zipFile = new ZipFile(inputFile);
			Enumeration<?> enu = zipFile.entries();
			
			while (enu.hasMoreElements()) {
				
				ZipEntry zipEntry = (ZipEntry) enu.nextElement();
				String name = destinationname+zipEntry.getName();
				File file = new File(name);
				
				if (name.endsWith("/")){
					file.mkdirs();
					continue;
				}
				
				InputStream is = zipFile.getInputStream(zipEntry);
				FileOutputStream fos = new FileOutputStream(name);
				byte[] bytes = new byte[1024];
				int length;
				
				while ((length = is.read(bytes)) >= 0) {
					fos.write(bytes, 0, length);
				}
				
				if (name.endsWith(".zip")){
					extractFile(name,destinationname+zipEntry.getName());
					file.delete();
				}
				
				if (name.endsWith(".java")){
				list.add(name);
				}
				
				is.close();
				fos.close();
			}
			
			zipFile.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		testZipFiles extractZipContent = new testZipFiles();
		
		extractZipContent.extractFile("C:/Users/Dell/workspace/test/code_examples.zip","C:/Temp/");
		
		try {
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Can't read.");
		}
	}
}
