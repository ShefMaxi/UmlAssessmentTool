package deprecatedSourceCode;
import java.io.IOException;
import java.util.ArrayList;

import org.jdom2.JDOMException;

import compareUML.*;
import FileHandler.*;
import PackagedElements.PackagedElement;
import UseCaseElements.*;
public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XMIFileParser xp= new XMIFileParser();
		try {
			xp.readXMIFile("/Users/zhangyan/Desktop/maxi test/test1.xmi");
			ArrayList<PackagedElement> a = xp.getPackagedList();
			a.toString();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
