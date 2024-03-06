import java.util.Date;

class DMV {
    private String state;
    private Registration[] registrations;
    private Citation[] citations;
    private int registrationsCount;
    private int citationsCount;

    public DMV(String state) {
        this.state = state;
        this.registrations = new Registration[100];
        this.citations = new Citation[100];
        this.registrationsCount = 0;
        this.citationsCount = 0;
    }

    public void registerVehicle(Owner[] owners, Vehicle vehicle) {
        registrations[registrationsCount++] = new Registration(registrationsCount + "", vehicle, owners);
    }

    public void registerCitation(Citation citation) {
        citations[citationsCount++] = citation;
    }

    public void listRegistrations() {
        for (int i = 0; i < registrationsCount; i++) {
            System.out.println(registrations[i]);
        }
    }

    public void listCitations() {
        for (int i = 0; i < citationsCount; i++) {
            System.out.println(citations[i]);
        }
    }

    public Registration searchRegistrationByPlate(String plate) {
        for (int i = 0; i < registrationsCount; i++) {
            if (registrations[i].getPlate().equals(plate)) {
                return registrations[i];
            }
        }
        return null;
    }

    public Registration searchRegistrationById(String id) {
        for (int i = 0; i < registrationsCount; i++) {
            if (registrations[i].getId().equals(id)) {
                return registrations[i];
            }
        }
        return null;
    }

    public Registration searchRegistrationByOwner(Owner owner) {
        for (int i = 0; i < registrationsCount; i++) {
            Owner[] owners = registrations[i].getOwners();
            for (Owner o : owners) {
                if (o.equals(owner)) {
                    return registrations[i];
                }
            }
        }
        return null;
    }

    public Citation searchCitationByRegistration(Registration registration) {
        for (int i = 0; i < citationsCount; i++) {
            if (citations[i].getRegistration().equals(registration)) {
                return citations[i];
            }
        }
        return null;
    }

    public Citation searchCitationByOwner(Owner owner) {
        for (int i = 0; i < citationsCount; i++) {
            Registration registration = searchRegistrationByOwner(owner);
            if (registration != null && citations[i].getRegistration().equals(registration)) {
                return citations[i];
            }
        }
        return null;
    }

    public Citation searchCitationById(int id) {
        for (int i = 0; i < citationsCount; i++) {
            if (citations[i].getId() == id) {
                return citations[i];
            }
        }
        return null;
    }
}