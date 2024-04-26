
public class ChildMember extends Member {
    private AdultMember guardian;

    public ChildMember(String memberId, String firstName, String lastName, AdultMember guardian) {
        super(memberId, firstName, lastName, lastName);
        this.guardian = guardian;
    }

    public AdultMember getGuardian() {
        return guardian;
    }

    public void setGuardian(AdultMember guardian) {
        this.guardian = guardian;
    }
}
