package classElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
	    ArrayList<String> operations=studentElement.getOperation();
	    for(Object obj:operations){
	    	if(this.operation.contains(obj)){
	    		marks++;
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
	    	    	marks++;
	    	    }
	    	}
	    }	   	    
	}
	return marks;
}
}
