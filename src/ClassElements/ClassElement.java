package classElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import packagedElements.PackagedElement;


public class ClassElement extends PackagedElement{
protected String name;
protected ArrayList<String> operation;
protected String generalization;
protected ArrayList<HashMap<String, String>> attribute;
protected boolean generalizable;
	public ClassElement(String type, String name,ArrayList<String> operation,String generalization,ArrayList<HashMap<String, String>> attribute) {
		super(type, null);		
		this.name=name;
		this.operation=operation;
		this.attribute=attribute;
		if (generalization != null) {
			this.generalizable = true;
			this.generalization = generalization;
		} else {
			this.generalizable = false;
		}
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
public boolean isGeneralizable() {
	return this.generalizable;
}
public String getGeneralization() {
	if (!generalizable) {
		return null;
	}
	return this.generalization;
}
public String toString() {
	return super.toString() + " name : " + name + " operation : " + operation 
			+ " attribute : " + attribute + " generalization : " + generalization;
}
@SuppressWarnings({ "unchecked" })
@Override
public double compareTo(PackagedElement packagedElement) {
	double marks=0.0;		
	if (packagedElement instanceof ClassElement){
		ClassElement studentElement=(ClassElement) packagedElement;
		//compare class name
		if(this.getName().compareToIgnoreCase(studentElement.getName())==0){
			marks++;
		}
		//compare generalization
	    if(this.isGeneralizable()==true&&studentElement.isGeneralizable()==true){		
	    	if(this.getGeneralization().compareToIgnoreCase(studentElement.getGeneralization())==0){
	    		marks++;
	    	}
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
	return marks;
}
}
