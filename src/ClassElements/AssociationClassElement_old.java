package ClassElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import PackagedElements.PackagedElement;

public class AssociationClassElement_old extends PackagedElement{
	protected String name;
	protected ArrayList<String> operation;
	protected ArrayList<HashMap<String, String>> attribute;
	protected String firstMemberName;
	protected String secondMemberName;
	public AssociationClassElement_old(String type, String name,ArrayList<String> operation,ArrayList<HashMap<String, String>> attribute,String firstMemberName,String secondMemberName){
		super(type, null);
		this.name=name;
		this.operation=operation;
		this.attribute=attribute;
		this.firstMemberName=firstMemberName;
		this.secondMemberName=secondMemberName;
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
	public String getFirstMemberName() {
		return this.firstMemberName;
	}
	public String getSecondMemberName() {
		return this.secondMemberName;
	}
	@SuppressWarnings("unchecked")
	@Override
	public double compareTo(PackagedElement packagedElement) {
		double marks=0.0;
		if (packagedElement instanceof AssociationClassElement_old){
			AssociationClassElement_old studentElement=(AssociationClassElement_old) packagedElement;
			//the 2 classes linked with association class must be correct
			if(this.getFirstMemberName().compareToIgnoreCase(studentElement.getFirstMemberName())==0&&this.getSecondMemberName().compareToIgnoreCase(studentElement.getSecondMemberName())==0){
			//compare association class name
			if(this.getName().compareToIgnoreCase(studentElement.getName())==0){
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
