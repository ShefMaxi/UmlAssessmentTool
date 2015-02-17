package compareUML;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import PackagedElements.PackagedElement;
import UseCaseElements.*;

//Comparison method for Usecase diagram, written by Shupeng
public class CompareH {
	double correctnumber = 0;
	double umlelenumber = 0;
	double assoelenumber = 0;

	public CompareH() {
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
		String[] StudentKeys = forkeys(StudentMap); // warning
		String[] LecturerKeys = forkeys(LecturerMap);
		// ----------------------------------------------------------------------------------------

		for (String key : LecturerKeys) {
			ArrayList<PackagedElement> lecturerElements = LecturerMap.get(key);
			ArrayList<PackagedElement> studentElements = StudentMap.get(key);
			for (PackagedElement packagedElement : lecturerElements) {
				// lecturer's packagedElement
				GeneralizableElement geneele = (GeneralizableElement) packagedElement;
				// pick student's packagedElement
				for (PackagedElement stdgeneEle : studentElements) {
					GeneralizableElement stdgeneele = (GeneralizableElement) stdgeneEle;
					if (geneele.isGeneralizable() == true
							&& stdgeneele.isGeneralizable() == true) {
						// pick student's GeneralizableElement
						if (geneele.getName().compareToIgnoreCase(
								(stdgeneele).getName()) == 0) {
							umlelenumber++;
						}
					}
					// pick student's AssociationElement
					else if (packagedElement instanceof AssociationElement) {
						AssociationElement assoele = (AssociationElement) packagedElement;
						for (PackagedElement stdassoele : studentElements) {
							if (assoele.getFirstMemberEnd()
									.compareToIgnoreCase(
											((AssociationElement) stdassoele)
													.getFirstMemberEnd()) == 0
									&& assoele
											.getSecondMemberEnd()
											.compareToIgnoreCase(
													((AssociationElement) stdassoele)
															.getSecondMemberEnd()) != 0) {
								assoelenumber = assoelenumber + 0.5;
							} else if (assoele.getFirstMemberEnd()
									.compareToIgnoreCase(
											((AssociationElement) stdassoele)
													.getFirstMemberEnd()) != 0
									&& assoele
											.getSecondMemberEnd()
											.compareToIgnoreCase(
													((AssociationElement) stdassoele)
															.getSecondMemberEnd()) == 0) {
								assoelenumber = assoelenumber + 0.5;
							} else if (assoele.getFirstMemberEnd()
									.compareToIgnoreCase(
											((AssociationElement) stdassoele)
													.getFirstMemberEnd()) == 0
									&& assoele
											.getSecondMemberEnd()
											.compareToIgnoreCase(
													((AssociationElement) stdassoele)
															.getSecondMemberEnd()) == 0) {
								assoelenumber++;
							}
						}
					}
				}
			}
		}
		correctnumber = assoelenumber + umlelenumber;
		System.out.println("correct number in total is " + correctnumber);
		System.out.println("correct umlelement number is " + umlelenumber);
		System.out.println("correct association number is " + assoelenumber);
	}

	// get keys from result of preprocessForUseCase
	public static String[] forkeys(HashMap<String, ArrayList<PackagedElement>> h) {
		Set<String> myKeys = h.keySet();
		String[] keys = new String[myKeys.size()];
		myKeys.toArray(keys);
		return keys;
	}

	public static double correctrate(double correctnumber, double totalnumber) {
		double correctrate = correctnumber / totalnumber;
		return correctrate;
	}
}