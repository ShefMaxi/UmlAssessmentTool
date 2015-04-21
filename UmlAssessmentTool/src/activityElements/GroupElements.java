package activityElements;

import packagedElements.PackagedElement;

public class GroupElements extends PackagedElement {
	protected String name;
	public GroupElements(String type, String id, String name) {
		
		super(type, id);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	
	@Override
	public String toString() {
	
		return super.toString() + " " +"name : " + name;
	}

	public double compareTo(PackagedElement packagedElement) {
		// compare to student's element
		double marks = 0.0;
		if (packagedElement instanceof GroupElements) {
			// student's packagedElement
			GroupElements studentElement = (GroupElements) packagedElement;
			if (this.getType().compareToIgnoreCase(studentElement.getType()) == 0) {
				if (this.getType().compareToIgnoreCase(studentElement.getType()) == 0) {
					if (this.getName()!=null){
						if (this.getName().compareToIgnoreCase(
							(studentElement).getName()) == 0) {
						marks++;
						}
					}
				}
			}
			return marks;
		}
		return marks;
	}

}