package compareUML;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import packagedElements.PackagedElement;
//usecase		 : 1
//class			 : 2
//activity		 : 3
//statemachine	 : 4

//Comparison method for Usecase diagram, written by Shupeng
public class AssessmentMark {
	protected double marks = 0.0;
	protected int totalPoints = 0;
	private Diagram studentDiagram = null;
	private Diagram lecturerDiagram = null;

	public AssessmentMark(Diagram studentDiagram,
			Diagram lecturerDiagram) {
		this.studentDiagram = studentDiagram;
		this.lecturerDiagram = lecturerDiagram;
	}

	private void assessUsecaseDiagram() {
		ElementsPreprocessor studentProcessor = new ElementsPreprocessor(
				studentDiagram.getElements());
		HashMap<String, ArrayList<PackagedElement>> studentMap = studentProcessor
				.preprocessForUseCase();
		ElementsPreprocessor lecturerProcessor = new ElementsPreprocessor(
				lecturerDiagram.getElements());
		HashMap<String, ArrayList<PackagedElement>> lecturerMap = lecturerProcessor
				.preprocessForUseCase();
		// ---------------------------------------------------------------------------------------
		String[] lecturerKeys = forkeys(lecturerMap);
		// ----------------------------------------------------------------------------------------

		for (String key : lecturerKeys) {
			ArrayList<PackagedElement> selectedLecturerElements = lecturerMap
					.get(key);
			ArrayList<PackagedElement> selectedStudentElements = studentMap
					.get(key);
			System.out.println(selectedLecturerElements.size());
			totalPoints += selectedLecturerElements.size();
			for (PackagedElement lecturerPackagedElement : selectedLecturerElements) {
				for (PackagedElement studentPackagedElement : selectedStudentElements) {
					marks += lecturerPackagedElement
							.compareTo(studentPackagedElement);
				}
			}
		}
	}

	// get keys from result of preprocessForUseCase
	public static String[] forkeys(HashMap<String, ArrayList<PackagedElement>> h) {
		Set<String> myKeys = h.keySet();
		String[] keys = new String[myKeys.size()];
		myKeys.toArray(keys);
		return keys;
	}

	public double getFinalMarks() {

		
		switch (studentDiagram.getDiagramType()) {
		case 1:
			assessUsecaseDiagram();
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		default:
			break;
		}
		System.out.println("total point is: " + totalPoints);
		System.out.println("correct comparison amount is: " + marks);
		return 100 * marks / totalPoints;
	}
}