package compareUML;

import java.util.ArrayList;

import PackagedElements.PackagedElement;
import UseCaseElements.AssociationElement;
import UseCaseElements.UMLElement;

public class StudentExample {
	protected ArrayList<PackagedElement> umlElements;
	protected String fileName;
	public StudentExample() {
		// TODO Auto-generated constructor stub
		this.umlElements = new ArrayList<PackagedElement>();
		fileName = "usecase demo";
		this.umlElements.add(new UMLElement("Actor", "xcfghjop", "Paul"));
		this.umlElements.add(new UMLElement("Actor", "asdfghjk", "Mike"));
		this.umlElements.add(new UMLElement("UseCase", "werfghjm", "New usecase"));
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
