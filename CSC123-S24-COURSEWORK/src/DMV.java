import java.util.Date;

class DMV {
    private Registration[] registrations;
    private Citation[] citations;
    private int registrationsCount;
    private int citationsCount;

    public DMV(String state) {
        this.registrations = new Registration[100];
        this.citations = new Citation[100];
        this.registrationsCount = 0;
        this.citationsCount = 0;
    }

    public void registerVehicle(Owner[] owners, Vehicle vehicle) throws Exception {
        // Check if there are pending citations for the vehicle
        for (int i = 0; i < citationsCount; i++) {
            if (citations[i].getRegistration().getVehicle().equals(vehicle)) {
                throw new Exception("Vehicle has pending citations. Cannot register.");
            }
        }
        
        // Check if the vehicle already has an active registration
        for (int i = 0; i < registrationsCount; i++) {
            if (registrations[i].getVehicle().equals(vehicle) && registrations[i].isActive()) {
                throw new Exception("Vehicle already has an active registration.");
            }
        }

        // Create a new registration
        registrations[registrationsCount++] = new Registration(generateUniqueId(), new Date(), null, vehicle.getPlate(), vehicle, owners);
    }

    public void registerCitation(Citation citation) {
        citations[citationsCount++] = citation;
    }

    public void listRegistrations() {
        System.out.println("All Registrations:");
        for (int i = 0; i < registrationsCount; i++) {
            System.out.println("Registration ID: " + registrations[i].getUniqueID());
            System.out.println("Start Date: " + registrations[i].getStartDate());
            System.out.println("End Date: " + registrations[i].getEndDate());
            System.out.println("Plate: " + registrations[i].getPlate());

            Vehicle vehicle = registrations[i].getVehicle();
            System.out.println("Vehicle Make: " + vehicle.getMake());
            System.out.println("Vehicle Model: " + vehicle.getModel());
            System.out.println("Vehicle Color: " + vehicle.getColor());
            System.out.println("Vehicle VIN: " + vehicle.getVin());
            System.out.println("Number of Doors: " + vehicle.getNumberOfDoors());

            Owner[] owners = registrations[i].getOwners();
            System.out.println("Owners:");
            for (Owner owner : owners) {
                System.out.println("Owner ID: " + owner.getUniqueID());
                System.out.println("Owner Name: " + owner.getFirstName() + " " + owner.getLastName());
                System.out.println("Owner Address: " + owner.getAddress());
                System.out.println("Owner City: " + owner.getCity());
                System.out.println("Owner State: " + owner.getState());
                System.out.println("Owner Zip: " + owner.getZip());
            }
            System.out.println("------------------------");
        }
    }

    public void listCitations() {
        for (int i = 0; i < citationsCount; i++) {
            System.out.println(citations[i]);
        }
    }

    public Registration searchRegistrationByPlate(String plate) {
        for (int i = 0; i < registrationsCount; i++) {
            if (registrations[i].getVehicle().getPlate().equals(plate)) {
                return registrations[i];
            }
        }
        return null;
    }

    public Registration searchRegistrationById(long id) {
        for (int i = 0; i < registrationsCount; i++) {
            if (registrations[i].getUniqueID() == id) {
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

    private long generateUniqueId() {
        return Long.valueOf(System.currentTimeMillis());
    }
}