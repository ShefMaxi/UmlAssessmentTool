package compareUML;

import java.io.IOException;

import org.jdom2.JDOMException;

import FileHandler.XMIFileParser;
import FileHandler.ZipFileHandler;

public class MAIN {
	public static void main(String[] args) throws JDOMException, IOException {
		//CompareH h=new CompareH();
		GUI frame=new GUI();
		frame.setVisible(true);
		try{
			XMIFileParser lecturerXMI = new XMIFileParser();
			String lecuturerPath = frame.getLecuturerPath();
			if(lecuturerPath.endsWith(".xmi")){
				lecturerXMI.readXMIFile(lecuturerPath);
				System.out.println(lecturerXMI.getPackagedList());
			}
			
			ZipFileHandler studentsZip = new ZipFileHandler();
			String studentPat = frame.getStudentPath();
			if(studentPat.endsWith(".zip")){
				studentsZip.extractFile(studentPat);
				for(String str : studentsZip.getEntriesList()){
					XMIFileParser studentXMI = new XMIFileParser();
					studentXMI.readXMIFile(str);
					studentXMI.getPackagedList();
			}
			}
		}catch (NullPointerException e){
			
		}
		
		
		/*try {
			//M_XMIFile.readXMIFile(args[0]);
		} catch (IOException e) {
			// TODO: handle exception
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
