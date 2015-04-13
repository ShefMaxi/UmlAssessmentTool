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
		System.out.println("----------- START ASSESSMENT -----------");
		this.studentDiagram = studentDiagram;
		this.lecturerDiagram = lecturerDiagram;
		
	}

	private void assessUsecaseDiagram() {
		ElementsPreprocessor studentProcessor = new ElementsPreprocessor(
				studentDiagram);
		HashMap<String, ArrayList<PackagedElement>> studentMap = studentProcessor
				.preprocessForUseCase();
		ElementsPreprocessor lecturerProcessor = new ElementsPreprocessor(
				lecturerDiagram);
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

	private void assessClassDiagram() {
		ElementsPreprocessor studentProcessor = new ElementsPreprocessor(
				studentDiagram);
		HashMap<String, ArrayList<PackagedElement>> studentMap = studentProcessor
				.preprocessForClass();
		ElementsPreprocessor lecturerProcessor = new ElementsPreprocessor(
				lecturerDiagram);
		HashMap<String, ArrayList<PackagedElement>> lecturerMap = lecturerProcessor
				.preprocessForClass();
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
	
	private void assessActivityDiagram() {
		ElementsPreprocessor studentProcessor = new ElementsPreprocessor(
				studentDiagram);
		HashMap<String, ArrayList<PackagedElement>> studentMap = studentProcessor
				.preprocessForActivity();
		ElementsPreprocessor lecturerProcessor = new ElementsPreprocessor(
				lecturerDiagram);
		HashMap<String, ArrayList<PackagedElement>> lecturerMap = lecturerProcessor
				.preprocessForActivity();
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
					marks += lecturerPackagedElement.compareTo(studentPackagedElement);
				}
			}
		}
	}
	
	private void assessStateMachineDiagram() {
		int studentPoints = 0;
		ElementsPreprocessor studentProcessor = new ElementsPreprocessor(
				studentDiagram);
		HashMap<String, ArrayList<PackagedElement>> studentMap = studentProcessor
				.preprocessForStateMachine();
		ElementsPreprocessor lecturerProcessor = new ElementsPreprocessor(
				lecturerDiagram);
		HashMap<String, ArrayList<PackagedElement>> lecturerMap = lecturerProcessor
				.preprocessForStateMachine();
				
		// --------------------------------------------------------------------------------------
		String[] lecturerKeys = forkeys(lecturerMap);
		// --------------------------------------------------------------------------------------

		for (String key : lecturerKeys) {
			ArrayList<PackagedElement> selectedLecturerElements = lecturerMap
					.get(key);
			ArrayList<PackagedElement> selectedStudentElements = studentMap
					.get(key);
			if (key.compareToIgnoreCase("transition") == 0) {
				totalPoints += selectedLecturerElements.size();
				studentPoints += selectedStudentElements.size();
			} else {
				totalPoints += 1.5 * selectedLecturerElements.size();
				studentPoints += 1.5 * selectedStudentElements.size();
			}
			
			for (PackagedElement lecturerPackagedElement : selectedLecturerElements) {
				for (PackagedElement studentPackagedElement : selectedStudentElements) {
					marks += lecturerPackagedElement
							.compareTo(studentPackagedElement);
				}
			}
		}
		if (studentPoints > 2 * totalPoints) {
			int temp = studentPoints / totalPoints;
			temp--;
			marks = marks * totalPoints / (studentPoints -temp * 0.8 * totalPoints);
		} else if (studentPoints > totalPoints) {
			marks = marks * totalPoints / studentPoints;
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
			assessClassDiagram();
			break;
		case 3:
			assessActivityDiagram();
			break;
		case 4:
			assessStateMachineDiagram();
			break;
		default:
			break;
		}
		System.out.println("total point is: " + totalPoints);
		System.out.println("correct comparison amount is: " + marks);
		return 100 * marks / totalPoints;
	}
}