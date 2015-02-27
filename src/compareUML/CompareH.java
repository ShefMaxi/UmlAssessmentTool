package compareUML;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import PackagedElements.PackagedElement;
import UseCaseElements.*;

//Comparison method for Usecase diagram, written by Shupeng
public class CompareH {
	protected double finalmarks=0.0;
	protected double marks=0.0;
	public CompareH(ArrayList<PackagedElement> StudentFile) {
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
				finalmarks=finalmarks+marks;
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
		return finalmarks;
	}
}