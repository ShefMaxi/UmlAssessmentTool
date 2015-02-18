package FileHandler;
import FileHandler.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.io.*;
import java.nio.file.Path;

public class ExtractZipContents {
	

	public ExtractZipContents() {
		// TODO Auto-generated constructor stub
	}

	public  static String  extractFile()//(String fileName) 
	{
				
	
		try {
			ZipFile zipFile = new ZipFile("code_examples.zip");
			Enumeration<?> enu = zipFile.entries();
			while (enu.hasMoreElements()) {
				ZipEntry zipEntry = (ZipEntry) enu.nextElement();

				String name = zipEntry.getName();
				long size = zipEntry.getSize();
				long compressedSize = zipEntry.getCompressedSize();
				System.out.printf("name: %-20s | size: %6d | compressed size: %6d\n", 
						name, size, compressedSize);

				File file = new File(name);
				if (name.endsWith("/"))
					//if (file.exists())
				{
					file.mkdirs();
					continue;
					//file.flush();
				}
					

				//boolean parent = file.createNewFile();// getParentFile();
				//if (parent != null) {
					//File path =new File ("C:/Users/Salisu/workspace/ExtractedFolder/");
					//path.mkdirs();
					//parent.mkdirs();
				//}
				//path.close();

				InputStream is = zipFile.getInputStream(zipEntry);
				FileOutputStream fos = new FileOutputStream(file);
				byte[] bytes = new byte[1024];
				int length;
				while ((length = is.read(bytes)) >= 0) {
					fos.write(bytes, 0, length);
				}
				is.close();
				fos.close();

			}
			zipFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	

}