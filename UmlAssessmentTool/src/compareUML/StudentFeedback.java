package compareUML;

import java.util.List;

public class StudentFeedback {
	
	private String studentName=null;
	private String studentId=null;
	private List<SingleDiagramFeedback> feedbacks;
	
	public StudentFeedback(String studentName,String studentId,List<SingleDiagramFeedback> studentFeedbacks){
		this.studentName=studentName;
		this.studentId=studentId;
		this.feedbacks=studentFeedbacks;
	}
	
	public String getStudentName(){
		return this.studentName;
	}
	
	public String getStudentId() {
		return this.studentId;
	}
	
	public List<SingleDiagramFeedback> getFeedbacks() {
		return this.feedbacks;
	}
	
	public String getAbstractStudentInfo() {
		StringBuffer sb = new StringBuffer();
		sb.append("StudentId:"+studentId+" Name:"+studentName+"\n");
		for (SingleDiagramFeedback df : feedbacks) {
			switch (df.getDiagramType()) {
			case 1:
				sb.append("Use case diagram---mark:"+df.getTotalMark());
				break;
			case 2:
				sb.append("Class diagram---mark:"+df.getTotalMark());
				break;
			case 3:
				sb.append("Activity diagram---mark:"+df.getTotalMark());
				break;
			case 4:
				sb.append("State Machine diagram---mark:"+df.getTotalMark());
				break;
			default:
				return "missing information";
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("Id: "+this.studentId+"\n");
		sb.append("Name: "+this.studentName+"\n");
		for (SingleDiagramFeedback sdf : feedbacks) {
			sb.append("\n");
			sb.append(sdf.toString());
		}
		return sb.toString();
	}
	
}
