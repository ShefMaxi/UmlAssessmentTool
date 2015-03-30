package ClassElements;

import java.util.ArrayList;
import java.util.HashMap;

import PackagedElements.PackagedElement;


public class ClassElement extends PackagedElement{
protected String name;
protected ArrayList<String> operation;
protected ArrayList<String> generalization;
protected ArrayList<HashMap<String, String>> attribute;
protected boolean generalizable;
	public ClassElement(String type, String id,String name,ArrayList<String> operation,ArrayList<String> generalization,ArrayList<HashMap<String, String>> attribute) {
		super(type, id);		
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
public ArrayList<String> getGeneralization() {
	if (!generalizable) {
		return null;
	}
	return this.generalization;
}
@Override
public double compareTo(PackagedElement packagedElement) {
	// TODO Auto-generated method stub
	return 0;
}
}
