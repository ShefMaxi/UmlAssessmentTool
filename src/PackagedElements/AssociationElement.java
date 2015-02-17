package PackagedElements;

public class AssociationElement extends PackagedElement{
	protected String firstMemberEnd;	// the real id of first member
	protected String secondMemberEnd;
	public AssociationElement(String id, String firstMember, String secondMember) {
		// TODO Auto-generated constructor stub\
		super("Association", id);
		this.firstMemberEnd = firstMember;
		this.secondMemberEnd = secondMember;
	}

	
	public String getFirstMemberEnd() {
		return firstMemberEnd;
	}
	
	public String getSecondMemberEnd() {
		return secondMemberEnd;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " 1st M : " + firstMemberEnd
				+ " 2nd M : " + secondMemberEnd;
	}
}
