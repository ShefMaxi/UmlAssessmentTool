package activityElements;

import packagedElements.PackagedElement;

public class SendSignalElement extends ActivityNodes {

	protected String incomingName;
	protected String outgoingName;
	
	public SendSignalElement(String type, String id, String inPartition,
			String name,String incomingName,String outgoingName) {
		super(type, id, inPartition, name);
		this.incomingName=incomingName;
		this.outgoingName=outgoingName;
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
		if (packagedElement instanceof SendSignalElement) {
			SendSignalElement student = (SendSignalElement)packagedElement;
			// make sure comparison under right type condition
			if (this.getType().compareToIgnoreCase(student.getType())==0) {
				
				// 0.5 point for identifying right incoming name
				if (this.getIncomingName()!=null) {
					if (student.getIncomingName()!=null) {
						if (this.getIncomingName().compareToIgnoreCase(student.getIncomingName())==0) {
							mark+=0.5;
						}
					}
				}
				// 0.5 point for identifying right outgoing name
				if (this.getOutgoingName()!=null) {
					if (student.getOutgoingName()!=null) {
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
		return mark;
	}

}
