import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DMV {
    private ArrayList<Registration> registrations;
    private ArrayList<Citation> citations;
    private int lastCitationId = 0;

    public DMV(String state) {
        this.registrations = new ArrayList<>();
        this.citations = new ArrayList<>();
    }

    public void registerVehicle(ArrayList<Owner> owners, Vehicle vehicle) throws Exception {
        // Check if the vehicle is already registered
        if (isVehicleRegistered(vehicle)) {
            throw new Exception("Vehicle is already registered.");
        }

        // Check if there are pending citations for the vehicle
        if (hasPendingCitations(vehicle)) {
            throw new Exception("Vehicle has pending citations. Cannot register.");
        }

        // Calculate expiration date (6 months from the registration date)
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, 6); // Adding 6 months until expiration
        Date expirationDate = calendar.getTime();

        // Create a new registration with the calculated expiration date
        registrations.add(new Registration(generateUniqueId(), new Date(), expirationDate, vehicle.getPlate(), vehicle, owners));
    }

    // Helper method to check if the vehicle is already registered
    private boolean isVehicleRegistered(Vehicle vehicle) {
        for (Registration registration : registrations) {
            if (registration.getVehicle().getPlate().equals(vehicle.getPlate())) {
                return true;
            }
        }
        return false;
    }

    // Helper method to check if the vehicle has pending citations
    private boolean hasPendingCitations(Vehicle vehicle) {
        for (Citation citation : citations) {
            if (citation.getRegistration().getVehicle().getPlate().equals(vehicle.getPlate())) {
                return true;
            }
        }
        return false;
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

            ArrayList<Owner> owners = registration.getOwners();
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
    	if (citations.isEmpty()) {
            System.out.println("No citations found.");
            return;
        }
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
            ArrayList<Owner> owners = registration.getOwners();
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
        return System.currentTimeMillis();
    }

    public int getCitationsCount() {
        return citations.size();
    }
    
    public ArrayList<Citation> getCitations() {
        return citations;
    }
}