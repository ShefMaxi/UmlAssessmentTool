package stateMachineElements;

import packagedElements.PackagedElement;

public class SubvertexElement extends PackagedElement {
	protected String name;
	public SubvertexElement(String type, String id, String name) {
		super(type, id);
		this.name = name;
	}

	@Override
	public double compareTo(PackagedElement packagedElement) {
		if (packagedElement instanceof SubvertexElement) {
			SubvertexElement subvertexElement = (SubvertexElement) packagedElement;
			if (this.name.compareToIgnoreCase(subvertexElement.getName()) == 0) {
				return 1.0;
			}
		}
		return 0.0;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " name : " + name;
	}
}
