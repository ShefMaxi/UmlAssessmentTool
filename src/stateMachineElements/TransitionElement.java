package stateMachineElements;

import PackagedElements.PackagedElement;

public class TransitionElement extends PackagedElement {
	protected String name;
	protected SubvertexElement sourceElement;
	protected SubvertexElement targetElement;
	public TransitionElement(String id, String name, SubvertexElement source, SubvertexElement target) {
		super("transition", id);
		this.name = name;
		this.sourceElement = source;
		this.targetElement = target;
	}
	
	@Override
	public double compareTo(PackagedElement packagedElement) {
		// TODO Auto-generated method stub
		return -1;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " name : " + name + " source : " 
				+ sourceElement.getName() + " target : " + targetElement.getName();
	}
}
