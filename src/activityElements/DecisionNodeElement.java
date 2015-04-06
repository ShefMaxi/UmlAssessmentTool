package activityElements;

import java.util.HashSet;

import PackagedElements.PackagedElement;

public class DecisionNodeElement extends ActivityNodes {

	
	protected HashSet<String> incomingPaths;
	protected HashSet<String> outgoingPaths;
	
	public DecisionNodeElement(String type, String id, String inPartition,
			String name,HashSet<String> incomingPaths,HashSet<String> outgoingPaths) {
		super(type, id, inPartition, name);
		this.incomingPaths=incomingPaths;
		this.outgoingPaths=outgoingPaths;
		// TODO Auto-generated constructor stub
	}
	
	public HashSet<String> getIncomingPaths(){
		return incomingPaths;
	}

	public HashSet<String> getOutgoingPaths(){
		return outgoingPaths;
	}
	@Override
	public double compareTo(PackagedElement packagedElement) {
		// TODO Auto-generated method stub
		double mark=0;
		if (packagedElement instanceof DecisionNodeElement) {
			DecisionNodeElement student = (DecisionNodeElement)packagedElement;
			// make sure comparison under right type condition
			if (this.getType().compareToIgnoreCase(student.getType())==0) {
				
				// search through the paths of lecture's standard answer
				if (this.getIncomingPaths().containsAll(student.getIncomingPaths())) {
					mark++;
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
