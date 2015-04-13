package stateMachineElements;

import packagedElements.PackagedElement;

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
		if (packagedElement instanceof TransitionElement) {
			TransitionElement transitionElement = (TransitionElement) packagedElement;
			if (this.sourceElement.getType().compareToIgnoreCase(
					transitionElement.getSourceElement().getType()) != 0) {
				return 0;
			}
			if (this.targetElement.getType().compareToIgnoreCase(
					transitionElement.getTargetElement().getType()) != 0) {
				return 0;
			}
			if (this.sourceElement.getName().compareToIgnoreCase(
					transitionElement.getSourceElement().getName()) != 0) {
				return 0;
			}
			if (this.targetElement.getName().compareToIgnoreCase(
					transitionElement.getTargetElement().getName()) == 0) {
				if (guard != null && transitionElement.getGuard() != null) {
					if (guard.getValue().compareToIgnoreCase(
							transitionElement.getGuard().getValue()) == 0) {
						return 1.0;
					}
				}
				if (guard == null && transitionElement.getGuard() == null) {
					return 1.0;
				}
				return 0.75;
			}
		}
		return 0.0;
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
