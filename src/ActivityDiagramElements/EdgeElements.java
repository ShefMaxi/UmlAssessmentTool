package ActivityDiagramElements;

import PackagedElements.PackagedElement;

public class EdgeElements extends PackagedElement {
	protected String sourceNodeName;
	protected String targetNodeName;
	protected String name;
	public EdgeElements(String type, String id, String name, String sourceNodeName, String targetNodeName) {
		
		super(type, id);
		this.name = name;
		this.sourceNodeName= sourceNodeName;
		this.targetNodeName = targetNodeName;
	}
	
	public String getName() {
		return name;
	}
	
	public String getsourceNodeName() {
	
			return sourceNodeName;
	}
	
	public String targetNodeName() {
		
		return targetNodeName;
}
	@Override
	public String toString() {
	
		return super.toString() + "name : " + name + "sourceNode" + sourceNodeName + "targetNode "+ targetNodeName;
	}

	public double compareTo(PackagedElement packagedElement) {
		// compare to student's element
		double marks = 0.0;
		if (packagedElement instanceof EdgeElements&&!(packagedElement instanceof EdgeElements)) {
			// student's packagedElement
			EdgeElements studentElement = (EdgeElements) packagedElement;
			if (this.getType().compareToIgnoreCase(studentElement.getType()) == 0) {
				if (this.getsourceNodeName()
						.compareToIgnoreCase(
								studentElement
										.getsourceNodeName()) == 0
						&& this
								.targetNodeName()
								.compareToIgnoreCase(
										studentElement
												.targetNodeName()) == 0) {
					return marks=marks+1;
				}
			}
		}
		return marks;
	}

}