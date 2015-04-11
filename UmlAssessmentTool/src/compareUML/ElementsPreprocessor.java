package compareUML;

import java.util.ArrayList;
import java.util.HashMap;

import packagedElements.PackagedElement;

/*
 * This class is to preprocess the arraylist created by
 * xmi parser
 */
public class ElementsPreprocessor {

	// private String[] DIAGRAMTYPE = {"usecase", "class", ""};
	protected String[] USECASE_ELEMENT_TYPE = { "uml:Actor", "uml:Usecase", "Association" };
	protected String[] CLASS_ELEMENT_TYPE = { "uml:Class", "Association", "AssociationCLass" };
	protected int diagramType;
	protected ArrayList<PackagedElement> diagramElements;

	// accessors
	public int getDiagramType() {
		return diagramType;
	}

	public ArrayList<PackagedElement> getRawElements() {
		return diagramElements;
	}

	public ElementsPreprocessor(Diagram umlDiagram) {
		// TODO Auto-generated constructor stub
		this.diagramElements = umlDiagram.getElements();
		this.diagramType = umlDiagram.getDiagramType();

	}


	public HashMap<String, ArrayList<PackagedElement>> preprocessForUseCase() {
		HashMap<String, ArrayList<PackagedElement>> result = new HashMap<String, ArrayList<PackagedElement>>();
		if (this.diagramType == 1) {
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
	/**
	 * 
	 * @author Shupeng Hu
	 */
	public HashMap<String, ArrayList<PackagedElement>> preprocessForClass() {
		HashMap<String, ArrayList<PackagedElement>> result = new HashMap<String, ArrayList<PackagedElement>>();
		if (this.diagramType == 2) {
			// can be optimized.
			
			for (String ClassElementType : CLASS_ELEMENT_TYPE) {
				
				ArrayList<PackagedElement> processedElements = new ArrayList<PackagedElement>();

				for (PackagedElement packagedElement : diagramElements) {
					if (packagedElement.getType().compareToIgnoreCase(
							ClassElementType) == 0) {
						processedElements.add(packagedElement);
					}
				}

				result.put(ClassElementType, processedElements);
			}
		}
		return result;
	}

}
