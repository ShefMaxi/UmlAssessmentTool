package compareUML;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import PackagedElements.PackagedElement;
import UseCaseElements.*;

//Comparison method for Usecase diagram, written by Shupeng
public class CompareH {
	public static String[] forkeys(HashMap<String, ArrayList<PackagedElement>> h) {
		Set<String> myKeys = h.keySet();
		String[] keys = new String[myKeys.size()];
		myKeys.toArray(keys);
		return keys;
	}

	public CompareH() {
		int correctnumber = 0;
		int umlelenumber = 0;
		int assoelenumber = 0;
		LecturerExample l = new LecturerExample();
		StudentExample s = new StudentExample();
		ElementsPreprocessor lectureProcessor = new ElementsPreprocessor(
				l.umlElements);
		HashMap<String, ArrayList<PackagedElement>> LecturerMap = lectureProcessor
				.preprocessForUseCase();
		ElementsPreprocessor studentProcessor = new ElementsPreprocessor(
				s.umlElements);
		HashMap<String, ArrayList<PackagedElement>> StudentMap = studentProcessor
				.preprocessForUseCase();

		// ---------------------------------------------------------------------------------------
		String[] StudentKeys = forkeys(StudentMap);		// warning
		String[] LecturerKeys = forkeys(LecturerMap);

		for (String key : LecturerKeys) {
			ArrayList<PackagedElement> lecturerElements = LecturerMap.get(key);
			ArrayList<PackagedElement> studentElements = StudentMap.get(key);
			for (PackagedElement packagedElement : lecturerElements) {
				if (packagedElement instanceof UMLElement) {           // UMLElement
					UMLElement umlele = (UMLElement) packagedElement; // lecturer's packagedElement
					// pick student's packagedElement
					for (PackagedElement stdumlEle : studentElements) { 
						if (umlele.getName().compareToIgnoreCase( // pick student's UMLElement
								((UMLElement) stdumlEle).getName()) == 0) {
							umlelenumber = umlelenumber + 10;
						}
					}
				} 
				// pick student's AssociationElement
				else if (packagedElement instanceof AssociationElement) { 
					AssociationElement assoele = (AssociationElement) packagedElement;
					for (PackagedElement stdassoele : studentElements) {
						if (assoele.getFirstMemberEnd().compareToIgnoreCase(
								((AssociationElement) stdassoele)
										.getFirstMemberEnd()) == 0
								&& assoele
										.getSecondMemberEnd()
										.compareToIgnoreCase(
												((AssociationElement) stdassoele)
														.getSecondMemberEnd()) != 0) {
							assoelenumber = assoelenumber + 5;
						} else if (assoele.getFirstMemberEnd()
								.compareToIgnoreCase(
										((AssociationElement) stdassoele)
												.getFirstMemberEnd()) != 0
								&& assoele
										.getSecondMemberEnd()
										.compareToIgnoreCase(
												((AssociationElement) stdassoele)
														.getSecondMemberEnd()) == 0) {
							assoelenumber = assoelenumber + 5;
						} else if (assoele.getFirstMemberEnd()
								.compareToIgnoreCase(
										((AssociationElement) stdassoele)
												.getFirstMemberEnd()) == 0
								&& assoele
										.getSecondMemberEnd()
										.compareToIgnoreCase(
												((AssociationElement) stdassoele)
														.getSecondMemberEnd()) == 0) {
							assoelenumber = assoelenumber + 10;
						}
					}
				}
				correctnumber = assoelenumber + umlelenumber;
			}
		}
		System.out.println("correct number in total is " + correctnumber);
		System.out.println("correct umlelement number is " + umlelenumber);
		System.out.println("correct association number is " + assoelenumber);
	}
}
