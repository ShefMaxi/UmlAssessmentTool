package compareUML;

import java.util.ArrayList;

public class StudentFeedback {
	
	private String studentName=null;
	private String studentId=null;
	private int totalMark=0;
	private int diagramType=0;
	private ArrayList<String[]> feedbackInfo=new ArrayList<>();
	
	
	
	public StudentFeedback(String studentName,String studentId,int totalMark,
			int diagramType,ArrayList<String[]> feedbackInfo){
		this.studentName=studentName;
		this.studentId=studentId;
		this.totalMark=totalMark;
		this.diagramType=diagramType;
		this.feedbackInfo=feedbackInfo;
	}
	
	public String getStudentName(){
		return this.studentName;
	}
	
	public String getStudentId() {
		return this.studentId;
	}
	
	public int getTotalMark() {
		return this.totalMark;
	}
	
	public int getDiagramType() {
		return this.diagramType;
	}
	
	public ArrayList<String[]> getFeedbackInfo() {
		return this.feedbackInfo;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("Id: "+this.studentId+"\n");
		sb.append("Name: "+this.studentName+"\n");
		switch (diagramType) {
		case 0:
			return "diagram not exist";
			
		case 1:
			sb.append("Diagram type: Use case diagram");
			break;
		case 2:
			sb.append("Diagram type: Class diagram");
			break;
		case 3: 
			sb.append("Diagram type: Activity diagram");
			break;
		case 4:
			sb.append("Diagram type: State Machine diagram");
			break;
		default:
			return "error";
		}
		sb.append("\n");
		sb.append("Mark: "+totalMark);
		for (String[] fs : feedbackInfo) {
			for (String s : fs) {
				sb.append(s+"\n");
			}
		}
		return sb.toString();
	}
}
