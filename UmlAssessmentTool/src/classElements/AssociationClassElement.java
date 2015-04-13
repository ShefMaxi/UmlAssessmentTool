package classElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import packagedElements.PackagedElement;

public class AssociationClassElement extends ClassAssociationElement{
	protected double totalpoints=0;
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
		getTotalPoints();
	}
	public void getTotalPoints(){
		this.totalpoints=this.totalpoints+1+this.operation.size()+this.attribute.size()+2+1+1;
		
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
		if (packagedElement instanceof AssociationClassElement){
			AssociationClassElement studentElement=(AssociationClassElement) packagedElement;
			//the 2 classes linked with association class must be correct
			if(this.getFirstMemberName().compareToIgnoreCase(studentElement.getFirstMemberName())==0&&this.getSecondMemberName().compareToIgnoreCase(studentElement.getSecondMemberName())==0){
			marks=marks+1/totalpoints;
				//compare association class name
			if(this.getName().compareToIgnoreCase(studentElement.getName())==0){
				marks=marks+1/totalpoints;
			}
			//compare multiplicity,1 point each for correct multiplicity
			if(this.getFirstMemberUpperValue().compareToIgnoreCase(studentElement.getFirstMemberUpperValue())==0&&this.getFirstMemberLowerValue().compareToIgnoreCase(studentElement.getFirstMemberLowerValue())==0){
				marks=marks+1/totalpoints;
			}
			if(this.getSecondMemberLowerValue().compareToIgnoreCase(studentElement.getSecondMemberLowerValue())==0&&this.getSecondMemberUpperValue().compareToIgnoreCase(studentElement.getSecondMemberUpperValue())==0){
				marks=marks+1/totalpoints;
			}
			//compare end roles
			if(this.getFirstMemberEndRole()!=null&&this.getSecondMemberEndRole()!=null&&studentElement.getFirstMemberEndRole()!=null&&studentElement.getSecondMemberEndRole()!=null){
			if(this.getFirstMemberEndRole().compareToIgnoreCase(studentElement.getFirstMemberEndRole())==0&&this.getSecondMemberEndRole().compareToIgnoreCase(studentElement.getSecondMemberEndRole())==0){
				marks=marks+1/totalpoints;
			}
			}
			//compare operation(name)
		    ArrayList<String> operations=studentElement.getOperation();
		    for(Object obj:operations){
		    	if(this.operation.contains(obj)){
		    		marks=marks+this.operation.size()/totalpoints;
		    	}
		    }	    
		    //compare attribute(name,type)
		    //get every HashMap from ArrayList
		    for(Object lecObj:this.getAttribute()){
		    	for(Object stuObj:studentElement.getAttribute()){
		    		//get every pair<type,name> from per HashMap
		    		Set<Map.Entry<String, String>> lecEntrySet = ((HashMap<String, String>) lecObj).entrySet();
		    		Set<Map.Entry<String, String>> stuEntrySet = ((HashMap<String, String>) stuObj).entrySet();
		    		 Iterator lec = lecEntrySet.iterator();
		    		 Iterator stu = stuEntrySet.iterator();
		    		Map.Entry<String, String> lecturer=(Map.Entry<String, String>)lec.next();
		    		Map.Entry<String, String> student=(Map.Entry<String, String>) stu.next();
		    		if(lecturer.getKey().compareToIgnoreCase(student.getKey())==0&&lecturer.getValue().compareToIgnoreCase(student.getValue())==0){
		    			marks=marks+this.attribute.size()/totalpoints;
		    	    }
		    	}
		    }	   	    
		}
		}
		return marks;
	}
}
