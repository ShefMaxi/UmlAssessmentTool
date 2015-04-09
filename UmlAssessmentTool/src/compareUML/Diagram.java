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
}
