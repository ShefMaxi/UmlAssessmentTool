package UseCaseElements;

import PackagedElements.PackagedElement;

public class AssociationElement extends PackagedElement{
// the real id of first member
	protected String firstMemberType;
	protected String firstMemberName;
	protected String secondMemberType;
	protected String secondMemberName;
	

	public AssociationElement(String id, String firstMemberName, String secondMemberName, String firstMemberType, String secondMemberType) {
		// TODO Auto-generated constructor stub\
		super("Association", id);
		this.firstMemberName = firstMemberName;
		this.secondMemberName = secondMemberName;
		this.firstMemberType = firstMemberType;
		this.secondMemberType = secondMemberType;
	}
	
	public void setTypeAndName(String name1, String type1, String name2, String type2) {
		this.firstMemberName = name1;
		this.firstMemberType = type1;
		this.secondMemberName = name2;
		this.secondMemberType = type2;
	}
	
	// --- get methods
	
	
	
	public String getFirstMemberName() {
		return firstMemberName;
	}
	
	public String getFirstMemberType() {
		return firstMemberType;
	}
	
	public String getSecondMemberName() {
		return secondMemberName;
	}
	
	public String getSecondMemberType() {
		return secondMemberType;
	}
	
	
	@Override
	public String toString() {
		return super.toString() + " 1st M : " + firstMemberName
				+ " 2nd M : " + secondMemberName;
	}
	
	public double compareTo(PackagedElement packagedElement){
		double marks = 0.0;
		if (packagedElement instanceof AssociationElement) {
<<<<<<< HEAD
			AssociationElement studentElement=(AssociationElement) packagedElement;			
=======
			AssociationElement studentElement=(AssociationElement) packagedElement;
>>>>>>> origin/master
			if (this.getFirstMemberName()
					.compareToIgnoreCase(
							studentElement
									.getFirstMemberName()) == 0
					&& this
							.getSecondMemberName()
							.compareToIgnoreCase(
									studentElement
<<<<<<< HEAD
											.getSecondMemberName()) == 0) {
				return marks=marks+1;
			}				
			else if (this.getFirstMemberType().equalsIgnoreCase("Actor")){
				if(this.getFirstMemberName().compareToIgnoreCase(studentElement.getFirstMemberName())==0){
				return	marks = marks + 0.5;
				}				
			} else if (this.getSecondMemberType().equalsIgnoreCase("Actor")){
				if(this.getSecondMemberName().compareToIgnoreCase(studentElement.getSecondMemberName())==0){
					return	marks = marks + 0.5;
					}				
			}					
=======
											.getSecondMemberName()) != 0) {
				marks = marks + 0.5;
				
			} else if (this.getFirstMemberName()
					.compareToIgnoreCase(
							studentElement
									.getFirstMemberName()) != 0
					&& this
							.getSecondMemberName()
							.compareToIgnoreCase(
									studentElement
											.getSecondMemberName()) == 0) {
				marks = marks + 0.5;
			} else if (this.getFirstMemberName()
					.compareToIgnoreCase(
							studentElement
									.getFirstMemberName()) == 0
					&& this
							.getSecondMemberName()
							.compareToIgnoreCase(
									studentElement
											.getSecondMemberName()) == 0) {
				marks++;
>>>>>>> origin/master
			}
		return marks;
		}			
}
