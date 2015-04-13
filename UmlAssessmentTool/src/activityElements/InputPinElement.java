package activityElements;

import packagedElements.PackagedElement;

public class InputPinElement extends ActivityNodes {

	protected String incomingName;
	
	public InputPinElement(String type, String id, String inPartition,
			String name, String incoming) {
		super(type, id, inPartition, name);
		this.incomingName=incoming;
		// TODO Auto-generated constructor stub
	}
	
	public String getIncomingName(){
		return this.incomingName;
	}

	@Override
	public double compareTo(PackagedElement packagedElement) {
		// TODO Auto-generated method stub
		double mark=0;
		if (packagedElement instanceof InputPinElement) {
			InputPinElement student = (InputPinElement)packagedElement;
			// make sure comparison under right type condition
			if (this.getType().compareToIgnoreCase(student.getType())==0) {
				
				// 1 point for identifying right incoming name
				if (this.getIncomingName()!=null) {
					if (student.getIncomingName()!=null) {
						if (this.getIncomingName().compareToIgnoreCase(student.getIncomingName())==0) {
							mark+=1;
						}
					}
				}
				// if a patition exists, judge if the node is in right partition. However, no point should be allocated if it's in wrong partition
				if (this.getInPartition()!=null) {
					if (student.getInPartition()!=null) {
						if (this.getInPartition().compareToIgnoreCase(student.getInPartition())!=0) {
							mark=0;
						}
					}
				}
			}
		}
		return mark;
	}


}
