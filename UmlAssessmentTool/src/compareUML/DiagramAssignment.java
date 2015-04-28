package compareUML;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import fileHandler.XMIFileParser;

public class DiagramAssignment {
	private List<Diagram> diagrams = new ArrayList<Diagram>();
	private String username = "", studentName = "";
    private StudentFeedback studentFeedback;
    private String stuFolderPath;
	
	public DiagramAssignment(String username, String studentName, List<String> xmiPaths) {
		this.username = username;
		this.studentName = studentName;
		XMIFileParser fileParser = new XMIFileParser();
		for (String path : xmiPaths) {
			Diagram diagram = fileParser.readXMIFile(path);
			if (diagram != null) {
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
	
	public StudentFeedback getSingleStudentFeedback() {
		return this.studentFeedback;
	}
	
	public void setStudentPath(String stuPath){
		this.stuFolderPath=stuPath;
	}
	
	public void markAssignment(List<Diagram> lecturerDiagrams) {
		List<DiagramFeedback> feedbacks = new ArrayList<DiagramFeedback>();
		for (Diagram lectDiagram : lecturerDiagrams) {
			Diagram stuDiagram = getDiagramByType(lectDiagram.getDiagramType());
			if (stuDiagram != null) {
				AssessmentMark assessor = new AssessmentMark(stuDiagram, lectDiagram);
			
				DiagramFeedback sdf = new DiagramFeedback(assessor.getFinalMarks(), 
						stuDiagram.getDiagramType(), assessor.getFeedBack());
				feedbacks.add(sdf);
			} else {
				// add information for missing diagram
			}	
		}
		studentFeedback = new StudentFeedback(studentName, username, feedbacks);
		try {
			PrintWriter pw = null;
			if (username!=null) {
				pw = new PrintWriter(new File(stuFolderPath+"/"+username+".txt"));
				pw.append(studentFeedback.toString());
			} else {
				System.out.println("invalid username");
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("file");
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
