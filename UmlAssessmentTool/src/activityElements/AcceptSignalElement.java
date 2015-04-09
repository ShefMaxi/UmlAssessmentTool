package activityElements;

import packagedElements.PackagedElement;

public class AcceptSignalElement extends ActivityNodes {

	protected String outgoingName;
	
	public AcceptSignalElement(String type, String id, String inPartition,
			String name, String outgoingName) {
		super(type, id, inPartition, name);
		this.outgoingName=outgoingName;
		// TODO Auto-generated constructor stub
	}
	
	public String getOutgoingName(){
		return this.outgoingName;
	}

	@Override
	public double compareTo(PackagedElement packagedElement) {
		// TODO Auto-generated method stub
		double mark=0;
		if (packagedElement instanceof AcceptSignalElement) {
			AcceptSignalElement student = (AcceptSignalElement)packagedElement;
			// make sure comparison under right type condition
			if (this.getType().compareToIgnoreCase(student.getType())==0) {
				
				// 1 point for identifying right outgoing name
				if (this.getOutgoingName()!=null) {
					if (this.getOutgoingName().compareToIgnoreCase(student.getOutgoingName())==0) {
						mark+=1;
					}
				}
				// if a patition exists, judge if the node is in right partition. However, no point should be allocated if it's in wrong partition
				if (this.getInPartition().compareToIgnoreCase(student.getInPartition())!=0) {
					mark=0;
				}
				
			}
		}
		return mark;
	}

}
