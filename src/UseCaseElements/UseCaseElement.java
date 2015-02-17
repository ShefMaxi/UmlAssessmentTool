package UseCaseElements;
//written by yan zhang
public class UseCaseElement extends GeneralizableElement {

	private String includeAddition;
	private String excludeAddition;
	private String extensionPoint;
	private boolean hasIncludeAddition;
	private boolean hasExcludeAddition;
	private boolean hasExtensionPoint;
	
	public UseCaseElement(String type, String id, String name,
			String generalization, String inludeAddition, String excludeAddition, String extensionPoint) {
		super(type, id, name, generalization);
		
		
		if (inludeAddition!=null) {
			this.hasIncludeAddition=true;
			this.includeAddition=inludeAddition;

		} else {
			this.hasIncludeAddition=false;
		}
		
		if (excludeAddition!=null) {
			this.hasExcludeAddition=true;
			this.excludeAddition=excludeAddition;

		} else {
			this.hasExcludeAddition=false;
		}
		
		if (extensionPoint!=null) {
			this.hasExtensionPoint=true;
			this.extensionPoint=extensionPoint;

		} else {
			this.hasExtensionPoint=false;
		}
	}
	
	public boolean hasIncludeAdditionLink(){
		return this.hasIncludeAddition;
	}
	
	public boolean hasExcludeAdditionLink(){
		return this.hasExcludeAddition;
	}
	
	public boolean hasExtensionAdditionLink(){
		return this.hasExtensionPoint;
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
