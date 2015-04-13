package activityElements;

import packagedElements.PackagedElement;

public class InitialNodeElement extends ActivityNodes {

	protected String outgoingName;
	
	public InitialNodeElement(String type, String id, String inPartition, String name,String outgoingName) {
		super(type, id, inPartition, name);
		this.outgoingName=outgoingName;
		// TODO Auto-generated constructor stub
	}
	
	public String getType(){
		return this.type;
	}
	
	public String getOutgoingName(){
		return this.outgoingName;
	}
	
	public String getInPartition(){
		return inPartition;
	}

	@Override
	public double compareTo(PackagedElement packagedElement) {
		double mark = 0;
		
		// basic comparison for identifying same type and outgoing name
		if (packagedElement instanceof InitialNodeElement) {
			InitialNodeElement studentNode = (InitialNodeElement)packagedElement;
			if (this.getType().compareToIgnoreCase(studentNode.getType())==0) {
				// 1 point for identifying right outgoing name
				if (this.getOutgoingName()!=null) {
					if (studentNode.getOutgoingName()!=null) {
						if (this.getOutgoingName().compareToIgnoreCase(studentNode.getOutgoingName())==0) {
							mark+=1;
						}
					}
				}
					
				// judgement for inpartition condition, if not same, 0.5 point should be deduced from this marking point
				if (this.getInPartition()!=null) {
					if (studentNode.getInPartition()!=null) {
						if (this.getInPartition().compareToIgnoreCase(studentNode.getInPartition())!=0) {
							mark=0;
						}
					}
				}
			}
		}
		return mark;
	}
	
	
	
}
