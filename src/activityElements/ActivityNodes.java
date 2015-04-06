package activityElements;

import PackagedElements.PackagedElement;

public abstract class ActivityNodes extends PackagedElement {

	protected String inPartition;
	protected String name;
	
	public ActivityNodes(String type, String id, String inPartition, String name) {
		super(type, id);
		this.inPartition=inPartition;
		this.name=name;
		// TODO Auto-generated constructor stub
	}
	
	public String getType(){
		return this.type;
	}
	
	public String getId(){
		return this.id;
	}
	
	public String getInPartition(){
		return this.inPartition;
	}
	
	public String getName(){
		return this.name;
	}

	@Override
	public abstract double compareTo(PackagedElement packagedElement);

}
