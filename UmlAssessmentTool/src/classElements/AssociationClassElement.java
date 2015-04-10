package classElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import packagedElements.PackagedElement;

public class AssociationClassElement extends ClassAssociationElement{
	protected ArrayList<String> operation;
	protected ArrayList<HashMap<String, String>> attribute;
	protected String name;
	public AssociationClassElement(String type, String name,String firstMemberName, String firstMemberLowerValue,
			String firstMemberUpperValue, String firstMemberEndRole, String secondMemberName,
			String secondMemberLowerValue, String secondMemberUpperValue, String secondMemberEndRole,
			ArrayList<String> operation, ArrayList<HashMap<String, String>> attribute) {
		super(type, firstMemberName, firstMemberLowerValue, firstMemberUpperValue, firstMemberEndRole,
				secondMemberName, secondMemberLowerValue, secondMemberUpperValue, secondMemberEndRole);
		this.operation=operation;
		this.attribute=attribute;
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	public ArrayList<String> getOperation(){
		return this.operation;
	}
	public ArrayList<HashMap<String, String>> getAttribute(){
		return this.attribute;
	}
	public String toString() {
		return super.toString() + " name : " + name + " operation : " + operation + " attribute : " + attribute;
	}
	
	@Override
	public double compareTo(PackagedElement packagedElement) {
		double marks=0.0;
		System.out.println("get into this compareTo method 1");
		if (packagedElement instanceof AssociationClassElement){
			AssociationClassElement studentElement=(AssociationClassElement) packagedElement;
			//the 2 classes linked with association class must be correct
			if(this.getFirstMemberName().compareToIgnoreCase(studentElement.getFirstMemberName())==0&&this.getSecondMemberName().compareToIgnoreCase(studentElement.getSecondMemberName())==0){
			//compare association class name
			if(this.getName().compareToIgnoreCase(studentElement.getName())==0){
				marks++;
			}
			//compare multiplicity,1 point each for correct multiplicity
			if(this.getFirstMemberUpperValue().compareToIgnoreCase(studentElement.getFirstMemberUpperValue())==0&&this.getFirstMemberLowerValue().compareToIgnoreCase(studentElement.getFirstMemberLowerValue())==0){
				marks++;
			}
			if(this.getSecondMemberLowerValue().compareToIgnoreCase(studentElement.getSecondMemberLowerValue())==0&&this.getSecondMemberUpperValue().compareToIgnoreCase(studentElement.getSecondMemberUpperValue())==0){
				marks++;
			}
			//compare end roles
			if(this.getFirstMemberEndRole().compareToIgnoreCase(studentElement.getFirstMemberEndRole())==0&&this.getSecondMemberEndRole().compareToIgnoreCase(studentElement.getSecondMemberEndRole())==0){
				marks++;
			}
			//compare operation(name)
		    String[] operations=(String[]) studentElement.getOperation().toArray();
		    for(int i=0;i<operations.length;i++){
		    if(this.operation.contains(operations[i])){
		    	marks++;
		    }
		    }
		  //compare attribute(name,type)
		    //get every HashMap from ArrayList
			HashMap<String, String>[] lecAttributes=(HashMap<String, String>[]) this.getAttribute().toArray();
		    HashMap<String, String>[] stuAttributes=(HashMap<String, String>[]) studentElement.getAttribute().toArray();
		    //get a pair(name,type) from per HashMap and compare them
		    for(int i=0;i<lecAttributes.length;i++){
		    Map.Entry<String, String> lecturer=(Map.Entry<String, String>) lecAttributes[i];
		    for(int j=0;j<stuAttributes.length;j++){	    	
		    Map.Entry<String, String> student=(Map.Entry<String, String>) stuAttributes[j];
		    if(lecturer.getKey().compareToIgnoreCase(student.getKey())==0&&lecturer.getValue().compareToIgnoreCase(student.getValue())==0){
		    	marks++;
		    }
		    }
		    }
		}
		}
		return marks;
	}
}
