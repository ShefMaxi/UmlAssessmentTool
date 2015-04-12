package activityElements;

import java.util.HashSet;

import packagedElements.PackagedElement;

public class JoinNodeElement extends ActivityNodes {
	
	
	protected String outgoingName;
	protected HashSet<String> incomingNamePaths;
	
	public JoinNodeElement(String type, String id, String inPartition,
			String name,String outgoingName, HashSet<String> incomingNamePaths) {
		super(type, id, inPartition, name);
		this.outgoingName=outgoingName;
		this.incomingNamePaths=incomingNamePaths;
		// TODO Auto-generated constructor stub
	}
	
	public String getOutgoingName(){
		return this.outgoingName;
	}
	
	public HashSet<String> getIncomingNamePaths(){
		return this.incomingNamePaths;
	}

	@Override
	public double compareTo(PackagedElement packagedElement) {
		// TODO Auto-generated method stub
		double mark=0;
		if (packagedElement instanceof JoinNodeElement) {
			JoinNodeElement student = (JoinNodeElement)packagedElement;
			// make sure comparison under right type condition
			if (this.getType().compareToIgnoreCase(student.getType())==0) {
				
				// 0.5 point for identifying right incoming names
				if (this.getIncomingNamePaths()!=null) {
					if (student.getIncomingNamePaths()!=null) {
						mark+=0.5;
					}
				}
				// 0.5 point for identifying right outgoing name
				if (this.getOutgoingName()!=null) {
					if (this.getOutgoingName()!=null) {
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
