package compareUML;

import java.util.ArrayList;

import packagedElements.PackagedElement;

// usecase		 : 1
// class		 : 2
// activity		 : 3
// statemachine	 : 4

public class Diagram {
	private ArrayList<PackagedElement> allElements;
	private int diagramType = 0;
	public Diagram(ArrayList<PackagedElement> elements, int diagramType) {
		this.allElements = elements;
		this.diagramType = diagramType;
	}
	
	public ArrayList<PackagedElement> getElements() {
		return allElements;
	}
	
	public int getDiagramType() {
		return diagramType;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String diagramTypeString;
		switch (diagramType) {
		case 1:
			diagramTypeString = "UseCase Diagram";
			break;
		case 2:
			diagramTypeString = "Class Diagram";
			break;
		case 3:
			diagramTypeString = "Activity Diagram";
			break;
		case 4:
			diagramTypeString = "StateMachine Diagram";
			break;
		default:
			diagramTypeString = "Unrecogized diagram";
			break;
		}
		return diagramTypeString + " : contains " + allElements.size() + " elements..." ;
	}
}
