package activityElements;

import java.util.HashSet;

import packagedElements.PackagedElement;

public class ForkNodeElement extends ActivityNodes {

	protected HashSet<String> outgoingNamePaths;
	protected String incomingName;
	
	public ForkNodeElement(String type, String id, String inPartition,
			String name,HashSet<String> outgoingNamePaths,String incomingName) {
		super(type, id, inPartition, name);
		this.outgoingNamePaths=outgoingNamePaths;
		this.incomingName=incomingName;
		// TODO Auto-generated constructor stub
	}

	public HashSet<String> getOutgoingNamePaths(){
		return this.outgoingNamePaths;
	}
	
	public String getincomingName(){
		return this.incomingName;
	}
	
	@Override
	public double compareTo(PackagedElement packagedElement) {
		// TODO Auto-generated method stub
		double mark=0;
		if (packagedElement instanceof ForkNodeElement) {
			ForkNodeElement student = (ForkNodeElement)packagedElement;
			// make sure comparison under right type condition
			if (this.getType().compareToIgnoreCase(student.getType())==0) {
				
				// 0.5 point for identifying right incoming name
				if (this.getincomingName()!=null) {
					if (student.getincomingName().compareToIgnoreCase(this.getincomingName())==0) {
						mark+=0.5;
					}
				}
				// 0.5 point for identifying right outgoing names
				if (this.getOutgoingNamePaths()!=null) {
					if (this.getOutgoingNamePaths()!=null) {
						mark+=0.5;
					}
				}
				// if a patition exists, judge if the node is in right partition. 
				// However, no point should be allocated if it's in wrong partition
				if (this.getInPartition().compareToIgnoreCase(student.getInPartition())!=0) {
					mark=0;
				}
				
			}
		}
		return mark;
	}

}
