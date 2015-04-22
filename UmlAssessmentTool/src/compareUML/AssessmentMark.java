package compareUML;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import activityElements.ActivityNodes;
import activityElements.EdgeElements;
import activityElements.GroupElements;
import packagedElements.PackagedElement;
//usecase		 : 1
//class			 : 2
//activity		 : 3
//statemachine	 : 4

//Comparison method for Usecase diagram, written by Shupeng
public class AssessmentMark {
	protected double marks = 0.0;
	protected double totalPoints = 0;
	private Diagram studentDiagram = null;
	private Diagram lecturerDiagram = null;
	private ArrayList<String[]> feedback = new ArrayList<>();
	private double highestMark;

	public AssessmentMark(Diagram studentDiagram,
			Diagram lecturerDiagram) {
		System.out.println("----------- START ASSESSMENT -----------");
		this.studentDiagram = studentDiagram;
		this.lecturerDiagram = lecturerDiagram;
		
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
			for(PackagedElement lecturerPackagedElement : selectedLecturerElements){
				totalPoints=totalPoints+lecturerPackagedElement.compareTo(lecturerPackagedElement);
			}
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
			for(PackagedElement lecturerPackagedElement : selectedLecturerElements){
				totalPoints=totalPoints+lecturerPackagedElement.compareTo(lecturerPackagedElement);
			}
			for (PackagedElement lecturerPackagedElement : selectedLecturerElements) {				
				for (PackagedElement studentPackagedElement : selectedStudentElements) {
					marks += lecturerPackagedElement
							.compareTo(studentPackagedElement);
				}
			}
		}
	}
	
	private void assessActivityDiagram() {
		ElementsPreprocessor studentProcessor = new ElementsPreprocessor(studentDiagram);
		ElementsPreprocessor lecturerProcessor = new ElementsPreprocessor(lecturerDiagram);
		HashMap<String, ArrayList<PackagedElement>> studentMap = studentProcessor.preprocessForActivity();
		HashMap<String, ArrayList<PackagedElement>> lecturerMap = lecturerProcessor.preprocessForActivity();
		// ---------------------------------------------------------------------------------------
		String[] lecturerKeys = forkeys(lecturerMap);
		// ----------------------------------------------------------------------------------------

		for (String key : lecturerKeys) {
			ArrayList<PackagedElement> selectedLecturerElements = lecturerMap.get(key);
			ArrayList<PackagedElement> selectedStudentElements = studentMap
					.get(key);
			System.out.println(selectedLecturerElements.size());
			totalPoints += selectedLecturerElements.size();
			
			// statistics map
			HashMap<String, Integer> statsMap = new HashMap<>();
			for (PackagedElement studentPackagementElement : selectedStudentElements) {
				if (studentPackagementElement instanceof ActivityNodes) {
					String usedWord = ((ActivityNodes) studentPackagementElement).getName();
					if (statsMap.containsKey(usedWord)) {
						statsMap.put(usedWord, statsMap.get(usedWord) + 1);
					} else {
						statsMap.put(usedWord, Integer(0));
					}
				}
			}
			
			
			for (PackagedElement lecturerPackagedElement : selectedLecturerElements) {
				highestMark=0;
				String feedBackInfo = null;
				double mark = 0;
				boolean flag = true;
				for (PackagedElement studentPackagedElement : selectedStudentElements) {
					
					if (lecturerPackagedElement.getType().equals(studentPackagedElement.getType())) {
						mark= lecturerPackagedElement.compareTo(studentPackagedElement);
						//System.out.println(lecturerPackagedElement.getType());
						//System.out.println(mark);
						if (flag) {
							highestMark=mark;
							flag=false;
						}
						if (mark>highestMark) {
							highestMark=mark;
						}
					}
				}
				marks+=highestMark;
				if (highestMark==0) {
					feedBackInfo="Element is missing or incorrect.";
				} 
				else if (highestMark==1){
					feedBackInfo = "Element is correct.";
				}
				else {
					feedBackInfo = "Element is partly correct.";
				}

				String elementName = null;
				if (lecturerPackagedElement instanceof ActivityNodes) {
					elementName = ((ActivityNodes) lecturerPackagedElement).getName();	
				}
				else if (lecturerPackagedElement instanceof EdgeElements) {
					elementName = ((EdgeElements) lecturerPackagedElement).getName();
				}
				else if (lecturerPackagedElement instanceof GroupElements) {
					elementName = ((GroupElements) lecturerPackagedElement).getName();
				}
				else {
					System.out.println("error");
				}
				String[] f = new String[]{lecturerPackagedElement.getType(),elementName,feedBackInfo};
				feedback.add(f);
				System.out.println(lecturerPackagedElement.getType()+"("+elementName+"):"+highestMark+": "+feedBackInfo);
			}
		}
	}
	
	private Integer Integer(int i) {
		// TODO Auto-generated method stub
		return null;
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
			double temp = studentPoints / totalPoints;
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

	public ArrayList<String[]> getFeedBack(){
		return this.feedback;
	}
	
	
	public double getFinalMarks() {

		System.out.println("total point is: " + totalPoints);
		System.out.println("correct comparison amount is: " + marks);
		return 100 * marks / totalPoints;
	}
	
	
}