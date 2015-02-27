package UseCaseElements;

import java.util.ArrayList;

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

}
