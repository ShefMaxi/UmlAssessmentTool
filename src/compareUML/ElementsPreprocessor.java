package compareUML;

import java.util.ArrayList;
import java.util.HashMap;

import PackagedElements.PackagedElement;

/*
 * This class is to preprocess the arraylist created by
 * xmi parser
 */
public class ElementsPreprocessor {

	// private String[] DIAGRAMTYPE = {"usecase", "class", ""};
	protected String[] USECASE_ELEMENT_TYPE = { "uml:Actor", "uml:Usecase", "Association" };
	protected String diagramType;
	protected ArrayList<PackagedElement> diagramElements;

	// accessors
	public String getDiagramType() {
		return diagramType;
	}

	public ArrayList<PackagedElement> getRawElements() {
		return diagramElements;
	}

	public ElementsPreprocessor(ArrayList<PackagedElement> elements) {
		// TODO Auto-generated constructor stub
		this.diagramElements = elements;
		identifyDiagramType();

	}

	protected boolean identifyDiagramType() {
		for (PackagedElement packagedElement : diagramElements) {
			if (packagedElement.getType().compareToIgnoreCase("uml:Actor") == 0) {
				this.diagramType = "UseCase";
				return true;
			} else if (packagedElement.getType().compareToIgnoreCase("uml:Class") == 0) {
				this.diagramType = "uml:Class";
				return true;
			} else if (packagedElement.getType().compareToIgnoreCase(
					"OpaqueAction") == 0) {
				this.diagramType = "Activity";
				return true;
			} else if (packagedElement.getType().compareToIgnoreCase("uml:State") == 0) {
				// need to re-check
				this.diagramType = "StateMachine";
				return true;
			}
		}
		return false;
	}

	public HashMap<String, ArrayList<PackagedElement>> preprocessForUseCase() {
		HashMap<String, ArrayList<PackagedElement>> result = new HashMap<String, ArrayList<PackagedElement>>();
		if (this.diagramType.compareToIgnoreCase("usecase") == 0) {
			// can be optimized.
			
			for (String usecaseElementType : USECASE_ELEMENT_TYPE) {
				
				ArrayList<PackagedElement> processedElements = new ArrayList<PackagedElement>();

				for (PackagedElement packagedElement : diagramElements) {
					if (packagedElement.getType().compareToIgnoreCase(
							usecaseElementType) == 0) {
						processedElements.add(packagedElement);
					}
				}

				result.put(usecaseElementType, processedElements);
			}
		}
		return result;
	}

}
