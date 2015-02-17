package UseCaseElements;

import PackagedElements.PackagedElement;

public class GeneralizableElement extends PackagedElement {
	protected String generalization;//goal object id
	protected boolean generalizable;
	protected String name;
	public GeneralizableElement(String type, String id, String name, String generalization) {
		// TODO Auto-generated constructor stub
		super(type, id);
		this.name = name;
		if (generalization != null) {
			this.generalizable = true;
			this.generalization = generalization;
		} else {
			this.generalizable = false;
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

}