package activityElements;

import packagedElements.PackagedElement;

public class CentralBufferNodeElement extends ActivityNodes {

	
	protected String incomingName;	
	protected String outgoingName;
	
	public CentralBufferNodeElement(String type, String id, String inPartition,
			String name, String incomingName,String outgoingName) {
		super(type, id, inPartition, name);
		this.outgoingName=outgoingName;
		this.incomingName=incomingName;
		// TODO Auto-generated constructor stub
	}
	
	public String getIncomingName(){
		return this.incomingName;
	}
	
	public String getOutgoingName(){
		return this.outgoingName;
	}

	@Override
	public double compareTo(PackagedElement packagedElement) {
		// TODO Auto-generated method stub
		double mark=0;
		if (packagedElement instanceof CentralBufferNodeElement) {
			CentralBufferNodeElement student = (CentralBufferNodeElement)packagedElement;
			// make sure comparison under right type condition
			if (this.getName()!=null) {
				if (this.getName().compareToIgnoreCase(student.getType())==0) {
					
					if (this.getIncomingName()!=null) {
						if (this.getOutgoingName()!=null) {
							if (this.getIncomingName().compareToIgnoreCase(student.getIncomingName())==0) {
								mark+=0.5;
							}
							if (this.getOutgoingName().compareToIgnoreCase(student.getOutgoingName())==0) {
								mark+=0.5;
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
			
		}
		return mark;
	}


}
