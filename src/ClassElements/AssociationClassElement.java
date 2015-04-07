package ClassElements;

import java.util.ArrayList;
import java.util.HashMap;

import PackagedElements.PackagedElement;

public class AssociationClassElement extends ClassAssociationElement{
	protected ArrayList<String> operation;
	protected ArrayList<HashMap<String, String>> attribute;
	public AssociationClassElement(String type, String firstMemberName, String firstMemberLowerValue,
			String firstMemberUpperValue, String firstMemberEndRole, String secondMemberName,
			String secondMemberLowerValue, String secondMemberUpperValue, String secondMemberEndRole,
			ArrayList<String> operation, ArrayList<HashMap<String, String>> attribute) {
	//public AssociationClassElement(String type, String name,ArrayList<String> operation,ArrayList<HashMap<String, String>> attribute,String firstMemberName,String secondMemberName){
		super(type, firstMemberName, firstMemberLowerValue, firstMemberUpperValue, firstMemberEndRole,
				secondMemberName, secondMemberLowerValue, secondMemberUpperValue, secondMemberEndRole);
		this.operation=operation;
		this.attribute=attribute;
	}
	public ArrayList<String> getOperation(){
		return this.operation;
	}
	public ArrayList<HashMap<String, String>> getAttribute(){
		return this.attribute;
	}
	public String toString() {
		return super.toString() + " operation : " + operation + " attribute : " + attribute;
	}
	
	@Override
	public double compareTo(PackagedElement packagedElement) {
		double marks=0.0;
		
		return marks;
	}
}
