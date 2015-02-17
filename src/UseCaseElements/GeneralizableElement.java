package UseCaseElements;

import PackagedElements.PackagedElement;

public class GeneralizableElement extends PackagedElement {
	protected String generalization;
	protected boolean generalizable;
	protected String name;
	public GeneralizableElement(String type, String id, String name, String generalization) {
		// TODO Auto-generated constructor stub
		super(type, id);
		this.name = name;
		if (generalizable) {
			this.generalization = generalization;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public String getGeneralization() {
		if (!generalizable) {
			return null;
		}
		return generalization;
	}
	
	public boolean isGeneralizable() {
		return this.generalizable;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "name : " + name;
	}
	public static void main(String[] args) {
		
	}
}