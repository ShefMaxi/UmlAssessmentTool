package compareUML;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import PackagedElements.PackagedElement;
import UseCaseElements.*;

//Comparison method for Usecase diagram, written by Shupeng
public class AssessmentMark {
	protected double marks = 0.0;
	protected int totalPoints = 0;
	public AssessmentMark(ArrayList<PackagedElement> studentElements,
			ArrayList<PackagedElement> lecturerElements) {

		ElementsPreprocessor studentProcessor = new ElementsPreprocessor(
				studentElements);
		HashMap<String, ArrayList<PackagedElement>> studentMap = studentProcessor
				.preprocessForUseCase();
		ElementsPreprocessor lecturerProcessor = new ElementsPreprocessor(
				lecturerElements);
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
			if (totalPoints == 6) {
				for (PackagedElement lecturerPackagedElement : selectedLecturerElements) {
					for (PackagedElement studentPackagedElement : selectedStudentElements) {
						marks += lecturerPackagedElement
								.compareTo(studentPackagedElement);
					}
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
		System.out.println(totalPoints);
		System.out.println(marks);
		return 100*marks/totalPoints;
	}
}