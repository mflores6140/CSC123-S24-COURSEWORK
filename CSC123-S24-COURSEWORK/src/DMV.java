import java.util.ArrayList;
import java.util.Date;

public class DMV {
    private ArrayList<Registration> registrations;
    private ArrayList<Citation> citations;
    private int lastCitationId = 0;

    public DMV(String state) {
        this.registrations = new ArrayList<>();
        this.citations = new ArrayList<>();
    }

    public void registerVehicle(Owner[] owners, Vehicle vehicle) throws Exception {
        // Check if there are pending citations for the vehicle
        for (Citation citation : citations) {
            if (citation.getRegistration().getVehicle().equals(vehicle)) {
                throw new Exception("Vehicle has pending citations. Cannot register.");
            }
        }

        // Check if the vehicle already has an active registration
        for (Registration registration : registrations) {
            if (registration.getVehicle().equals(vehicle) && registration.isActive()) {
                throw new Exception("Vehicle already has an active registration.");
            }
        }

        // Create a new registration
        registrations.add(new Registration(generateUniqueId(), new Date(), null, vehicle.getPlate(), vehicle, owners));
    }

    public void registerCitation(Citation citation) {
        // Find the registration for the given citation
        Registration registration = citation.getRegistration();
        if (registration != null) {
            // Generate a unique citation ID and set it
            int citationId = ++lastCitationId;
            citation.setId(citationId);

            // Add the citation to the list
            citations.add(citation);
            System.out.println("Citation registered successfully!");
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    public void listRegistrations() {
        System.out.println("All Registrations:");
        for (Registration registration : registrations) {
            System.out.println("Registration ID: " + registration.getUniqueID());
            System.out.println("Start Date: " + registration.getStartDate());
            System.out.println("End Date: " + registration.getEndDate());
            System.out.println("Plate: " + registration.getPlate());

            Vehicle vehicle = registration.getVehicle();
            System.out.println("Vehicle Make: " + vehicle.getMake());
            System.out.println("Vehicle Model: " + vehicle.getModel());
            System.out.println("Vehicle Color: " + vehicle.getColor());
            System.out.println("Vehicle VIN: " + vehicle.getVin());
            System.out.println("Number of Doors: " + vehicle.getNumberOfDoors());

            Owner[] owners = registration.getOwners();
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
        System.out.println("All Citations:");
        for (Citation citation : citations) {
            System.out.println("Citation ID: " + citation.getId());
            System.out.println("Date: " + citation.getDate());
            System.out.println("Offence Code: " + citation.getOffenceCode());
            System.out.println("Amount: " + citation.getAmount());
            System.out.println("Status: " + citation.getStatus());
            System.out.println("------------------------");
        }
    }

    public Registration searchRegistrationByPlate(String plate) {
        for (Registration registration : registrations) {
            if (registration.getVehicle().getPlate().equals(plate)) {
                return registration;
            }
        }
        return null;
    }

    public Registration searchRegistrationById(long id) {
        for (Registration registration : registrations) {
            if (registration.getUniqueID() == id) {
                return registration;
            }
        }
        return null;
    }

    public Registration searchRegistrationByOwner(Owner owner) {
        for (Registration registration : registrations) {
            Owner[] owners = registration.getOwners();
            for (Owner o : owners) {
                if (o.getUniqueID() == owner.getUniqueID()) { // Compare unique IDs
                    return registration;
                }
            }
        }
        return null;
    }

    public Citation searchCitationByRegistration(Registration registration) {
        for (Citation citation : citations) {
            if (citation.getRegistration().equals(registration)) {
                return citation;
            }
        }
        return null;
    }

    public Citation searchCitationByOwner(Owner owner) {
        for (Citation citation : citations) {
            Registration registration = searchRegistrationByOwner(owner);
            if (registration != null && citation.getRegistration().equals(registration)) {
                return citation;
            }
        }
        return null;
    }

    public Citation searchCitationById(int id) {
        for (Citation citation : citations) {
            if (citation.getId() == id) {
                return citation;
            }
        }
        return null;
    }

    private long generateUniqueId() {
        return Long.valueOf(System.currentTimeMillis());
    }
    
    public int getCitationsCount() {
        return getCitationsCount();
    }
    
    public ArrayList<Citation> getCitations() {
        return citations;
    }
}