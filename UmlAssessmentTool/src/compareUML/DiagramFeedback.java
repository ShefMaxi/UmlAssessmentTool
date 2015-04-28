package compareUML;

import java.util.ArrayList;

public class DiagramFeedback {
	
	
	private double totalMark=0.0;
	private int diagramType=0;
	private ArrayList<String[]> feedbackInfo=new ArrayList<>();
	
	
	
	public DiagramFeedback(double totalMark,int diagramType,ArrayList<String[]> feedbackInfo){
		
		this.totalMark=totalMark;
		this.diagramType=diagramType;
		this.feedbackInfo=feedbackInfo;
		
	}
	
	
	
	public double getTotalMark() {
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
		sb.append("Mark: "+(int)totalMark+"\n\n"+"Feedback information:\n\n");
		for (String[] fs : feedbackInfo) {
			for (String s : fs) {
				sb.append(s+"\n");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
