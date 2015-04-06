package ClassElements;

import PackagedElements.PackagedElement;


public class ClassAssociationElement extends PackagedElement{
	protected String type;
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
		this.firstMemberName=firstMemberName;
		this.firstMemberLowerValue=firstMemberLowerValue;
		this.firstMemberUpperValue=firstMemberUpperValue;
		this.firstMemberEndRole=firstMemberEndRole;
		this.secondMemberName=secondMemberName;
		this.secondMemberLowerValue=secondMemberLowerValue;
		this.secondMemberUpperValue=secondMemberUpperValue;
		this.secondMemberEndRole=secondMemberEndRole;
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
	
	@Override
	public double compareTo(PackagedElement packagedElement) {
	double marks=0.0;
	
	return marks;
	}
}