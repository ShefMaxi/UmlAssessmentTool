package compareUML;

import java.io.IOException;

import org.jdom2.JDOMException;

import FileHandler.M_XMIFile;
import FileHandler.M_ZipFiles;

public class MAIN {
	public static void main(String[] args) throws JDOMException, IOException {
		//CompareH h=new CompareH();
		GUI frame=new GUI();
		frame.setVisible(true);
		try{
			M_XMIFile lecturerXMI = new M_XMIFile();
			String lecuturerPath = frame.getLecuturerPath();
			if(lecuturerPath.endsWith(".xmi")){
				lecturerXMI.readXMIFile(lecuturerPath);
				lecturerXMI.getPackagedList();
			}
			
			M_ZipFiles studentsZip = new M_ZipFiles();
			String studentPat = frame.getStudentPath();
			if(studentPat.endsWith(".zip")){
				studentsZip.extractFile(studentPat);
				for(String str : studentsZip.getEntriesList()){
					M_XMIFile studentXMI = new M_XMIFile();
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
