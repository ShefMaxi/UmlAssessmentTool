package useCaseElements;


import java.util.ArrayList;

import packagedElements.PackagedElement;

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

	public double compareTo(PackagedElement packagedElement) {
		// compare to student's element
		double marks = 0.0;
		if (packagedElement instanceof GeneralizableElement&&!(packagedElement instanceof UseCaseElement)) {
			// student's packagedElement
			GeneralizableElement studentElement = (GeneralizableElement) packagedElement;
			if (this.getType().compareToIgnoreCase(studentElement.getType()) == 0) {
				if (this.getName().compareToIgnoreCase(
						(studentElement).getName()) == 0) {
					marks++;
				}
			}
		}
		return marks;
	}

}