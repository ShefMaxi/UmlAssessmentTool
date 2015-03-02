package compareUML;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import PackagedElements.PackagedElement;
import UseCaseElements.*;

//Comparison method for Usecase diagram, written by Shupeng
public class AssessmentMark {
	protected double finalMark=0.0;
	protected double marks=0.0;
	public AssessmentMark(ArrayList<PackagedElement> StudentFile) {
		ElementsPreprocessor studentProcessor = new ElementsPreprocessor(
				StudentFile);
		HashMap<String, ArrayList<PackagedElement>> StudentMap = studentProcessor
				.preprocessForUseCase();

		// ---------------------------------------------------------------------------------------		
		String[] LecturerKeys = forkeys(StudentMap);
		// ----------------------------------------------------------------------------------------

		for (String key : LecturerKeys) {
			ArrayList<PackagedElement> studentElements = StudentMap.get(key);
			for (PackagedElement packagedElement : studentElements) {							
				marks=packagedElement.compareTo(packagedElement);	
				finalMark=finalMark+marks;
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
	public double getFinalMarks(){
		return finalMark;
	}
}