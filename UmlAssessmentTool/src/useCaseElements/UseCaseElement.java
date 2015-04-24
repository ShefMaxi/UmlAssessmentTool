package useCaseElements;

import java.util.ArrayList;

import packagedElements.PackagedElement;

//written by yan zhang
public class UseCaseElement extends GeneralizableElement {

	private String includeAddition;
	private String extensionAddition;
	private ArrayList<String> extensionPoints;
	private boolean hasIncludeAddition;
	private boolean hasExtensionAddition;
	private boolean hasExtensionPoint;

	public UseCaseElement(String type, String id, String name,
			String generalization, String inludeAddition,
			String extensionAddition, ArrayList<String> extensionPoints) {
		super(type, id, name, generalization);

		if (inludeAddition != null) {
			this.hasIncludeAddition = true;
			this.includeAddition = inludeAddition;
		} else {
			this.hasIncludeAddition = false;
		}

		if (extensionAddition != null) {
			this.hasExtensionAddition = true;
			this.extensionAddition = extensionAddition;
		} else {
			this.hasExtensionAddition = false;
		}

		if (extensionPoints != null) {
			this.hasExtensionPoint = true;
			this.extensionPoints = extensionPoints;

		} else {
			this.hasExtensionPoint = false;
		}
	}

	// accessors
	public boolean hasIncludeAdditionLink() {
		return this.hasIncludeAddition;
	}

	public boolean hasExtensionAdditionLink() {
		return this.hasExtensionAddition;
	}

	public boolean hasExtensionPoint() {
		return this.hasExtensionPoint;
	}

	public String getIncludeAddition() {
		return this.includeAddition;
	}

	public String getExtensionAddition() {
		return this.extensionAddition;
	}

	public ArrayList<String> getExtensionPoint() {
		return this.extensionPoints;
	}
	public double compareTo(PackagedElement packagedElement){
		double marks=0.0;
		if(packagedElement instanceof UseCaseElement){
			UseCaseElement studentElement=(UseCaseElement) packagedElement;
			// compare usecase name							
			if(this.getType().compareToIgnoreCase(studentElement.getType())==0){								
				if(this.getName().compareToIgnoreCase(studentElement.getName())==0){
					marks++;
					//compare generalization
				    if(this.isGeneralizable()==true&&studentElement.isGeneralizable()==true){		
				    	if(this.getGeneralization().compareToIgnoreCase(studentElement.getGeneralization())==0){
				    		marks++;
				    	}
				    }
				}
			}				
			//compare inludeAddition
			if(this.hasIncludeAdditionLink()==true&&studentElement.hasIncludeAdditionLink()==true){
				if(this.getIncludeAddition().compareToIgnoreCase(studentElement.getIncludeAddition())==0){
					marks++;
				}
			}
			//compare excludeAddition
			if(this.hasExtensionAdditionLink()==true&&studentElement.hasExtensionAdditionLink()==true){
				if(this.getExtensionAddition().compareToIgnoreCase(studentElement.getExtensionAddition())==0){
					marks++;
				}
				}
			//compare extensionPoints
//			if(this.getExtensionPoint().equals(studentElement.getExtensionPoint())){
//				marks++;
//			}
//			else{}
		}
		return marks;
	}
}

