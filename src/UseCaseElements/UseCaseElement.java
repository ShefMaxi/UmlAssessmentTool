package UseCaseElements;
//written by yan zhang
public class UseCaseElement extends GeneralizableElement {

	private String includeAddition;
	private String excludeAddition;
	private String extensionPoint;
	
	public UseCaseElement(String type, String id, String name,
			String generalization, String inludeAddition, String excludeAddition, String extensionPoint) {
		super(type, id, name, generalization);
		// TODO Auto-generated constructor stub
		this.includeAddition=inludeAddition;
		this.excludeAddition=excludeAddition;
		this.extensionPoint=extensionPoint;
	}
	
	public String getIncludeAddition(){
		return this.includeAddition;
	}
	
	public String getExcludeAddition(){
		return this.excludeAddition;
	}
	
	public String getExtensionPoint(){
		return this.extensionPoint;
	}

}
