package compareUML;

import java.util.ArrayList;
import java.util.HashMap;

import packagedElements.PackagedElement;

/*
 * This class is to preprocess the arraylist created by
 * xmi parser
 */
public class ElementsPreprocessor {
	// usecase		 : 1
	// class		 : 2
	// activity		 : 3
	// statemachine	 : 4
	
	protected String[] USECASE_ELEMENT_TYPE = { "uml:Actor", "uml:Usecase", "Association" };
	protected String[] CLASS_ELEMENT_TYPE = { "uml:Class", "Association", "AssociationCLass" };
	protected String[] ACTIVITY_ELEMENT_TYPE = {"uml:ActionNodeElement","uml:AcceptSignalElement",
			"uml:ActivityFinalNodeElement","uml:CentralBufferNodeElement","uml:JoinNodeElement",
			"uml:ForkNodeElement","uml:InitialNodeElement","uml:ControlFlow","uml:group","uml:InputPin","uml:OutputPin"};
	
	protected String[] STATE_MACHINE_ELEMENT_TYPE = {"uml:State", "uml:Pseudostate", "uml:FinalState", "transition"};
	protected int diagramType;
	protected ArrayList<PackagedElement> diagramElements;

	// accessors
	public int getDiagramType() {
		return diagramType;
	}

	public ArrayList<PackagedElement> getRawElements() {
		return diagramElements;
	}

	// constructor
	public ElementsPreprocessor(Diagram umlDiagram) {
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
	
	public HashMap<String, ArrayList<PackagedElement>> preprocessForActivity() {
		HashMap<String, ArrayList<PackagedElement>> result = new HashMap<String, ArrayList<PackagedElement>>();
		if (this.diagramType == 3) {
			// can be optimized.
			
			for (String ActivityElementType : ACTIVITY_ELEMENT_TYPE) {
				
				ArrayList<PackagedElement> processedElements = new ArrayList<PackagedElement>();

				for (PackagedElement packagedElement : diagramElements) {
					if (packagedElement.getType().compareToIgnoreCase(
							ActivityElementType) == 0) {
						processedElements.add(packagedElement);
					}
				}

				result.put(ActivityElementType, processedElements);
			}
		}
		return result;
	}

	public HashMap<String, ArrayList<PackagedElement>> preprocessForStateMachine() {
		HashMap<String, ArrayList<PackagedElement>> result = new HashMap<>();
		if (this.diagramType == 4) {
			for (String elementType  : STATE_MACHINE_ELEMENT_TYPE) {
				ArrayList<PackagedElement> processedElements = new ArrayList<>();
				for (PackagedElement packagedElement : diagramElements) {
					if (packagedElement.getType().compareToIgnoreCase(elementType) == 0) {
						processedElements.add(packagedElement);
					}
				}
				result.put(elementType, processedElements);
			}
		}
		return result;
	}
	
}
