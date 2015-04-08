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
				if (this.getOutgoingName().compareToIgnoreCase(studentNode.getOutgoingName())==0) {
					mark++;
					
					// judgement for inpartition condition, if not same, 0.5 point should be deduced from this marking point
					if (this.inPartition!=null) {
						if (this.getInPartition().compareToIgnoreCase(studentNode.getInPartition())!=0) {
							mark=mark-0.5;
						}
					}
				}
			}
		}
		return mark;
	}
	
	
	
}
