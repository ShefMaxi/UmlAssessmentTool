package activityElements;

import packagedElements.PackagedElement;

public class ActionNodeElement extends ActivityNodes {

	
	protected String incomingName;
	protected String outgoingName;
	protected boolean inputValue;
	protected boolean outputValue;
	
	public ActionNodeElement(String type, String id, String inPartition,String name,
			String incomingName,String outgoingName,boolean inputValue,boolean outputValue) {
		super(type, id, inPartition, name);
		this.incomingName=incomingName;
		this.outgoingName=outgoingName;
		this.inputValue=inputValue;
		this.outputValue=outputValue;
		// TODO Auto-generated constructor stub
	}

	public String getIncomingName(){
		return incomingName;
	}
	
	public String getOutgoingName(){
		return outgoingName;
	}
	
	public boolean getInputValue(){
		return inputValue;
	}
	
	public boolean getOutputValue(){
		return outputValue;
	}
	@Override
	public double compareTo(PackagedElement packagedElement) {
		// TODO Auto-generated method stub
		double mark=0;
		if (packagedElement instanceof ActionNodeElement) {
			ActionNodeElement student = (ActionNodeElement)packagedElement;
			// make sure comparison under right type condition
			if (this.getName().compareToIgnoreCase(student.getName())==0) {
				
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
				
	
				// -0.25 point for not identifying input pin on action node
				if (this.getInputValue()^student.getInputValue()) {
					mark-=0.25;
					if (mark<=0) {
						mark=0;
					}
				}
				// -0.25 point for not identifying output pin on action node
				if (this.getOutputValue()^student.getOutputValue()) {
					mark-=0.25;
					if (mark<=0) {
						mark=0;
					}
				}
				// if a patition exists, judge if the node is in right partition
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
