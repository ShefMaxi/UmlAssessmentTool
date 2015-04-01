package stateMachineElements;

import PackagedElements.PackagedElement;

public class TransitionElement extends PackagedElement {
	protected String name;
	protected SubvertexElement sourceElement;
	protected SubvertexElement targetElement;
	protected Guard guard = null;
	public TransitionElement(String id, String name, SubvertexElement source, SubvertexElement target) {
		super("transition", id);
		this.name = name;
		this.sourceElement = source;
		this.targetElement = target;
	}
	
	public void setGuard(Guard guard) {
		this.guard = guard;
	}
	
	public Guard getGuard() {
		return guard;
	}
	
	public SubvertexElement getSourceElement() {
		return sourceElement;
	}
	
	public SubvertexElement getTargetElement() {
		return targetElement;
	}
	
	@Override
	public double compareTo(PackagedElement packagedElement) {
		// TODO Auto-generated method stub
		return -1;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if (this.guard == null) {
			return super.toString() + " name : " + name + " source : " 
				+ sourceElement.getName() + " target : " + targetElement.getName();
		}
		return super.toString() + " name : " + name + " source : " 
		+ sourceElement.getName() + " target : " + targetElement.getName() + " guard : " + this.guard;
	}
}
