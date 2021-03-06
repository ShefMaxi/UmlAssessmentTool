package classElements;


import packagedElements.PackagedElement;


public class ClassAssociationElement extends PackagedElement{
	protected double totalpoints=0;
	protected String firstMemberName;
	protected String firstMemberLowerValue;
	protected String firstMemberUpperValue;
	protected String firstMemberEndRole;
	protected String secondMemberName;
	protected String secondMemberLowerValue;
	protected String secondMemberUpperValue;
	protected String secondMemberEndRole;

	public ClassAssociationElement(String type, String firstMemberName, String firstMemberLowerValue,
			String firstMemberUpperValue, String firstMemberEndRole, String secondMemberName,
			String secondMemberLowerValue, String secondMemberUpperValue, String secondMemberEndRole) {
		super(type,null);
		System.out.println(this.getType());
		this.firstMemberName=firstMemberName;
		this.firstMemberLowerValue=firstMemberLowerValue;
		this.firstMemberUpperValue=firstMemberUpperValue;
		this.firstMemberEndRole=firstMemberEndRole;
		this.secondMemberName=secondMemberName;
		this.secondMemberLowerValue=secondMemberLowerValue;
		this.secondMemberUpperValue=secondMemberUpperValue;
		this.secondMemberEndRole=secondMemberEndRole;
		getTotalPoints();
	}
	public void getTotalPoints(){
		this.totalpoints=4;
		
	}
	public String getFirstMemberName() {
		return this.firstMemberName;
	}
	
	public String getFirstMemberLowerValue() {
		return this.firstMemberLowerValue;
	}
	
	public String getFirstMemberUpperValue() {
		return this.firstMemberUpperValue;
	}
	
	public String getFirstMemberEndRole() {
		return this.firstMemberEndRole;
	}
	
	public String getSecondMemberName() {
		return this.secondMemberName;
	}
	
	public String getSecondMemberLowerValue() {
		return this.secondMemberLowerValue;
	}
	
	public String getSecondMemberUpperValue() {
		return this.secondMemberUpperValue;
	}
	
	public String getSecondMemberEndRole() {
		return this.secondMemberEndRole;
	}
	
	public String toString() {
		return super.toString() + " firstMember : " + firstMemberName + " lowerValue : " + firstMemberLowerValue 
				+ " upperValue : " + firstMemberUpperValue + " endRole : " + firstMemberEndRole 
				+ " secondMember : " + secondMemberName + " lowerValue : " + secondMemberLowerValue 
				+ " upperValue : " + secondMemberUpperValue + " endRole : " + secondMemberEndRole;
	}
	public String getValues() {
		return "first member:=- "+firstMemberName+":second member- "+secondMemberName;
		
	}
	
	@Override
	public double compareTo(PackagedElement packagedElement) {
	double marks=0.0;
	int number=0;
	if (packagedElement instanceof ClassAssociationElement&&!(packagedElement instanceof AssociationClassElement)){
		ClassAssociationElement studentElement=(ClassAssociationElement) packagedElement;
		System.out.println("-----"+this.getType());
		//System.out.println(studentElement.getType());
			//the 2 linked classes must be correct
			if(this.getFirstMemberName().compareToIgnoreCase(studentElement.getFirstMemberName())==0&&this.getSecondMemberName().compareToIgnoreCase(studentElement.getSecondMemberName())==0){
			marks=marks+1/totalpoints;
			number++;
			//compare association type, (association, aggregation,composition)
			if(this.getType().equals("aggregation")||this.getType().equals("composition")){
				if(this.getType().compareToIgnoreCase(studentElement.getType())==0){
					number++;
				}
				}
				//compare multiplicity,1 point each for correct multiplicity
			if(this.getFirstMemberLowerValue()!=null&&this.getFirstMemberUpperValue()!=null){
			if(this.getFirstMemberUpperValue().compareToIgnoreCase(studentElement.getFirstMemberUpperValue())==0&&this.getFirstMemberLowerValue().compareToIgnoreCase(studentElement.getFirstMemberLowerValue())==0){
				marks=marks+1/totalpoints;
				number++;
			}
			}
			if(this.getSecondMemberLowerValue()!=null&&this.getSecondMemberUpperValue()!=null){
			if(this.getSecondMemberLowerValue().compareToIgnoreCase(studentElement.getSecondMemberLowerValue())==0&&this.getSecondMemberUpperValue().compareToIgnoreCase(studentElement.getSecondMemberUpperValue())==0){
				marks=marks+1/totalpoints;
				number++;
			}
			}
			//compare end roles
			if(this.getFirstMemberEndRole()!=null&&this.getSecondMemberEndRole()!=null){
			if(this.getFirstMemberEndRole().compareToIgnoreCase(studentElement.getFirstMemberEndRole())==0&&this.getSecondMemberEndRole().compareToIgnoreCase(studentElement.getSecondMemberEndRole())==0){
				marks=marks+1/totalpoints;
				number++;
			}
			}
			}
		}	
	//return marks;
	return number;
	}
}