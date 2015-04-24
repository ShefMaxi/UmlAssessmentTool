package fileHandler;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.io.*;

public class ZipFileHandler {
	private Map<String, String> studentInfoMap = null;
	
	public List<String> extractFile(String inputFile, String extension) {
		List<String> entriesList = new ArrayList<String>();
		String destinationFile = System.getProperty("java.io.tmpdir");
		destinationFile = destinationFile.replace('\\', '/');
		if(!destinationFile.endsWith("/"))
			destinationFile = destinationFile+"/";
		 
		if(extension.equals("txt"))
			destinationFile = destinationFile+inputFile.substring(0, inputFile.length()-4)+"/";
		else
			destinationFile = inputFile.substring(0, inputFile.length()-4)+"/";
		
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
				
				/*if (name.endsWith(".zip")) {
					extractFile(name); //extractFile(name,destinationFile+zipEntry.getName());
					file.delete();
				}*/
				
				if (name.endsWith("."+extension)) {
					entriesList.add(name);
				}
				is.close();
				fos.close();
			}
			zipFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entriesList;
	}
	
	public Map<String,List<String>> getStudentFiles(String inputFile) {
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		TextReader reader = new TextReader(extractFile(inputFile, "txt"));
		this.studentInfoMap = reader.getStudentInfoMap();
		for (Map.Entry<String, String> entry : reader.getStudentFilePathMap().entrySet()) {
			List<String> list = new ArrayList<String>();
			list.addAll(extractFile(entry.getValue(), "xmi"));
			map.put(entry.getKey(), list);
		}
		return map;
	}
	
	public Map<String, String> getStudentInfoMap() {
		return studentInfoMap;
	}
	
	public static void main(String[] args) {
		ZipFileHandler zipFileHandler = new ZipFileHandler();
		System.out.println(zipFileHandler.getStudentFiles("test.zip"));
	}
}