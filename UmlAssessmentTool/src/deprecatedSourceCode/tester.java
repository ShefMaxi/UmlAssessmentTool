package deprecatedSourceCode;
import java.io.IOException;
import java.util.ArrayList;

import org.jdom2.JDOMException;

import compareUML.*;
import fileHandler.*;
import packagedElements.PackagedElement;
import useCaseElements.*;
public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XMIFileParser xp= new XMIFileParser();
		xp.readXMIFile("/Users/zhangyan/Desktop/maxi test/test1.xmi");
		ArrayList<PackagedElement> a = xp.getPackagedList();
		a.toString();
	}

}
