package compareUML;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import PackagedElements.PackagedElement;
import UseCaseElements.*;

//Comparison method for Usecase diagram, written by Shupeng
public class CompareH {
	double correctnumber = 0;
	double geneelenumber = 0;
	double assoelenumber = 0;
    double ucnumber =0;
	double ucnamenumber =0;
    double ucgenenumber =0;
    double inaddnumber =0;
    double exaddnumber =0;
    double expnumber =0;
    
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
		String[] LecturerKeys = forkeys(LecturerMap);
		// ----------------------------------------------------------------------------------------

		for (String key : LecturerKeys) {
			ArrayList<PackagedElement> lecturerElements = LecturerMap.get(key);
			ArrayList<PackagedElement> studentElements = StudentMap.get(key);
			for (PackagedElement packagedElement : lecturerElements) {				
				if(packagedElement instanceof GeneralizableElement&&!(packagedElement instanceof UseCaseElement)){
				// lecturer's packagedElement
				GeneralizableElement geneele = (GeneralizableElement) packagedElement;
				// pick student's packagedElement
				for (PackagedElement stdgeneEle : studentElements) {					
					GeneralizableElement stdgeneele = (GeneralizableElement) stdgeneEle;																
						if(geneele.getType().compareToIgnoreCase(stdgeneele.getType())==0){
						// pick student's GeneralizableElement	and compare name													
							if (geneele.getName().compareToIgnoreCase(
								(stdgeneele).getName()) == 0) {
							geneelenumber++;
						}
					}
					
				}
				}
										
				// pick student's AssociationElement					
					else if (packagedElement instanceof AssociationElement) {
						AssociationElement assoele = (AssociationElement) packagedElement;
						for (PackagedElement stdassoEle : studentElements) {						
							AssociationElement stdassoele=(AssociationElement) stdassoEle;
							/*if(assoele.getFirstMemberType()
									.compareToIgnoreCase(
											stdassoele.getFirstMemberType())==0&&
													assoele.getSecondMemberType()
															.compareToIgnoreCase(
																	 stdassoele
																			.getSecondMemberType())==0){
							*/									
							//compare firstmembername and secondmembername
								if (assoele.getFirstMemberEnd()
									.compareToIgnoreCase(
											 stdassoele
													.getFirstMemberEnd()) == 0
									&& assoele
											.getSecondMemberEnd()
											.compareToIgnoreCase(
													 stdassoele
															.getSecondMemberEnd()) != 0) {
								assoelenumber = assoelenumber + 0.5;
							} else if (assoele.getFirstMemberEnd()
									.compareToIgnoreCase(
											 stdassoele
													.getFirstMemberEnd()) != 0
									&& assoele
											.getSecondMemberEnd()
											.compareToIgnoreCase(
													 stdassoele
															.getSecondMemberEnd()) == 0) {
								assoelenumber = assoelenumber + 0.5;
							} else if (assoele.getFirstMemberEnd()
									.compareToIgnoreCase(
											 stdassoele
													.getFirstMemberEnd()) == 0
									&& assoele
											.getSecondMemberEnd()
											.compareToIgnoreCase(
													 stdassoele
															.getSecondMemberEnd()) == 0) {
								assoelenumber++;
							}
						//}
						}
						System.out.println(assoele
								.getSecondMemberEnd());
					}
							
					// pick student's usecaseelement
					 if(packagedElement instanceof UseCaseElement){
						UseCaseElement ucele=(UseCaseElement) packagedElement;
						for (PackagedElement stducEle : studentElements){							
							UseCaseElement stducele=(UseCaseElement) stducEle;
						// compare usecase name							
							if(ucele.getType().compareToIgnoreCase(stducele.getType())==0){								
							if(ucele.getName().compareToIgnoreCase(stducele.getName())==0){
								ucnamenumber++;
							}
							}							
						//compare generalization
					   // if(ucele.isGeneralizable()==true&&stducele.isGeneralizable()==true){					    	
					   // }
					//compare inludeAddition
							if(ucele.hasIncludeAdditionLink()==true&&stducele.hasIncludeAdditionLink()==true){
							if(ucele.getIncludeAddition().compareToIgnoreCase(stducele.getIncludeAddition())==0){
								inaddnumber++;
							}
							}
				//compare excludeAddition
							if(ucele.hasExcludeAdditionLink()==true&&stducele.hasExcludeAdditionLink()==true){
								if(ucele.getExcludeAddition().compareToIgnoreCase(stducele.getExcludeAddition())==0){
									exaddnumber++;
								}
								}
				//compare extensionPoint
							if(ucele.hasExtensionAdditionLink()==true&&stducele.hasExtensionAdditionLink()==true){
								if(ucele.getExtensionPoint().compareToIgnoreCase(stducele.getExtensionPoint())==0){
									expnumber++;
								}
								}								
						}						
						}
					}
				}
		ucnumber= ucnamenumber+inaddnumber+exaddnumber+expnumber;	
		correctnumber = assoelenumber + geneelenumber+ucnumber;
		System.out.println("correct number in total is " + correctnumber);
		System.out.println("correct genelization number is " + geneelenumber);
		System.out.println("correct association number is " + assoelenumber);
		System.out.println("correct usecase number is " + ucnumber);
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