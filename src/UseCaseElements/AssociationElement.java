package UseCaseElements;

import PackagedElements.PackagedElement;

public class AssociationElement extends PackagedElement{
	protected String firstMemberEnd;	// the real id of first member
	protected String secondMemberEnd;
	protected String firstMemberType;
	protected String firstMemberName;
	protected String secondMemberType;
	protected String secondMemberName;
	

	public AssociationElement(String id, String firstMember, String secondMember) {
		// TODO Auto-generated constructor stub\
		super("Association", id);
		this.firstMemberEnd = firstMember;
		this.secondMemberEnd = secondMember;
	}
	
	public void setTypeAndName(String name1, String type1, String name2, String type2) {
		this.firstMemberName = name1;
		this.firstMemberType = type1;
		this.secondMemberName = name2;
		this.secondMemberType = type2;
	}
	
	// --- get methods
	
	public String getFirstMemberEnd() {
		return firstMemberEnd;
	}
	
	public String getSecondMemberEnd() {
		return secondMemberEnd;
	}
	
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
		return super.toString() + " 1st M : " + firstMemberEnd
				+ " 2nd M : " + secondMemberEnd;
	}
	
	public double compareTo(PackagedElement packagedElement){
		return .0;
	}
}
