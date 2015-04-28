package activityElements;

import packagedElements.PackagedElement;

public class EdgeGuard extends PackagedElement {
	protected String body;
	public EdgeGuard(String type, String id, String value) {
		super(type, id);
		body = value;
	}
	
	public String getBody() {
		return body;
	}
	
	@Override
	public String toString() {
		return body;
	}

	@Override
	public double compareTo(PackagedElement packagedElement) {
		// compare to student's element
				double marks = 0.0;
				if (packagedElement instanceof EdgeGuard) {
					// student's packagedElement
					EdgeGuard studentElement = (EdgeGuard) packagedElement;
							
					if (this.getType().compareToIgnoreCase(studentElement.getType()) == 0) {
					
						if (this.getBody()!=null){
							if (this.getBody().compareToIgnoreCase(studentElement.getBody())==0);
							marks++;
						}
					}
				}
		// TODO Auto-generated method stub
		return marks;
	}

	// 
}

