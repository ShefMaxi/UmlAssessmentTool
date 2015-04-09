package packagedElements;

public abstract class PackagedElement {	// abstract
	protected String type;
	protected String id;
	
	public PackagedElement(String type, String id) {
		// TODO Auto-generated constructor stub
		this.type = type;
		this.id = id;
	}

	public String getType() {
		return type;
	}
	public String getId() {
		return id;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "type : " + type + " id : " + id;
	}
	
	public abstract double compareTo(PackagedElement packagedElement);
}
