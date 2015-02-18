package compareUML;

import java.util.ArrayList;

import PackagedElements.PackagedElement;
import UseCaseElements.*;
public class StudentExample {
	protected ArrayList<PackagedElement> umlElements;
	protected String fileName;
	public StudentExample() {
		// TODO Auto-generated constructor stub
		this.umlElements = new ArrayList<PackagedElement>();
		fileName = "usecase demo";
		this.umlElements.add(new GeneralizableElement("Actor", "xcfghjop", "Paul",null));
		this.umlElements.add(new GeneralizableElement("Actor", "asdfghjk", "Mike",null));
		this.umlElements.add(new UseCaseElement("UseCase", "werfghjm", "New usecase",null,null,null,null));
		this.umlElements.add(new UseCaseElement("UseCase", "werfghjm", "New usecase",null,null,null,null));		
		this.umlElements.add(new AssociationElement("xdfthyjklop", "xcfghjop", "werfghjm"));
		this.umlElements.add(new AssociationElement("wertghjkop", "asdfghjk", "werfghjm"));
		
		
	}
	
	public ArrayList<PackagedElement> getUmlElements() {
		return umlElements;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.umlElements.toString();
	}
}
