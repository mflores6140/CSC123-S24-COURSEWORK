
public class Member {
    private String memberId;
    private String firstName;
    private String lastName;
    private String guardianId;

    public Member(String memberId, String firstName, String lastName, String guardianId) {
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.guardianId = guardianId;
    }

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFullName() {
        return firstName + " " + lastName;
    }
	
	public String getGuardianId() {
        return guardianId;
    }

    public void setGuardianId(String guardianId) {
        this.guardianId = guardianId;
    }
    
	public String memberInfo() {
		return (memberId + "," + firstName + "," + lastName + "," + guardianId);
	}
}