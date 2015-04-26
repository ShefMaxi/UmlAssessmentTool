package compareUML;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fileHandler.XMIFileParser;

public class DiagramAssignment {
	private List<Diagram> diagrams = new ArrayList<Diagram>();
	private String username = "", studentName = "";
	
	public DiagramAssignment(List<String> xmiPaths) {
		
		XMIFileParser fileParser = new XMIFileParser();
		for (String path : xmiPaths) {
			Diagram diagram = fileParser.readXMIFile(path);
			if (diagram == null) {
				this.diagrams.add(diagram);
			} else {
				// add information for error
			}
		}
	}
	
	// accessors
	public List<Diagram> getDiagrams() {
		return diagrams;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void markAssignment(List<Diagram> lecturerDiagrams) {
		for (Diagram lectDiagram : lecturerDiagrams) {
			Diagram stuDiagram = getDiagramByType(lectDiagram.getDiagramType());
			if (stuDiagram != null) {
				AssessmentMark assessor = new AssessmentMark(stuDiagram, lectDiagram);
			} else {
				// add information for missing diagram
			}
			
		}
	}
	
	private Diagram getDiagramByType(int type) {
		for (Diagram diagram : this.diagrams) {
			if (diagram.getDiagramType() == type) {
				return diagram;
			}
		}
		return null;
	}
	

}
