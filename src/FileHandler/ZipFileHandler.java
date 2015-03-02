package FileHandler;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.io.*;

public class ZipFileHandler {
	
	private List<String> entriesList = new ArrayList<String>();
	
	public  void extractFile(String inputFile) {
		
		String destinationFile = "C:/Uml Assessment Tool/";
		
		File dir = new File(destinationFile);
		
		dir.mkdir();
		
		try {
			
			ZipFile zipFile = new ZipFile(inputFile);
			
			Enumeration<?> enu = zipFile.entries();
			
			while (enu.hasMoreElements()) {
				
				ZipEntry zipEntry = (ZipEntry) enu.nextElement();
				
				String name = destinationFile+zipEntry.getName();
				
				name = name.toLowerCase();
				
				File file = new File(name);
				
				if (name.endsWith("/")) {
					
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
				
				if (name.endsWith(".zip")) {
					
					extractFile(name); //extractFile(name,destinationFile+zipEntry.getName());
					
					file.delete();
				}
				
				if (name.endsWith(".xmi")) {
					
					entriesList.add(name);
				}
								
				is.close();
				
				fos.close();
			}
			
			zipFile.close();
			
			if (entriesList.size()==0) {
				
				System.out.println("This zip file does not contain any XMI file");
				
				System.exit(0);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getEntriesList() {
		return (ArrayList<String>)entriesList;
	}
}
