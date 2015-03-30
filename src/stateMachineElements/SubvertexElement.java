package stateMachineElements;

import PackagedElements.PackagedElement;

public class SubvertexElement extends PackagedElement {
	protected String name;
	public SubvertexElement(String type, String id, String name) {
		super(type, id);
		this.name = name;
	}

	@Override
	public double compareTo(PackagedElement packagedElement) {
		// TODO Auto-generated method stub
		return -1;
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
