import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class TestDMV {
    public static void main(String[] args) {
        DMV dmv = new DMV("CA");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Register Vehicle");
            System.out.println("2. Register Citation");
            System.out.println("3. List all Registrations");
            System.out.println("4. List all Citations");
            System.out.println("5. List all Registrations for a vehicle");
            System.out.println("6. List all Registrations for a person");
            System.out.println("7. List all Citations for a vehicle");
            System.out.println("8. List all Citations for a person");
            System.out.println("9. Exit");

            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerVehicle(dmv, scanner);
                    break;
                case 2:
                    registerCitation(dmv, scanner);
                    break;
                case 3:
                    dmv.listRegistrations();
                    break;
                case 4:
                    dmv.listCitations();
                    break;
                case 5:
                    listRegistrationsForVehicle(dmv, scanner);
                    break;
                case 6: 
                    listRegistrationsForPerson(dmv, scanner);
                    break;
                case 7: 
                    listCitationsForVehicle(dmv, scanner);
                    break;
                case 8: 
                    listCitationsForPerson(dmv, scanner);
                    break;
                case 9:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void registerVehicle(DMV dmv, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Enter vehicle license plate: ");
        String plate = scanner.nextLine();
        if (!plate.matches("[A-Za-z0-9]+")) {
            System.out.println("Invalid plate format. Plate should contain only alphanumeric characters.");
            return;
        }
        System.out.println("Enter vehicle VIN: ");
        String vin = scanner.nextLine();
        //Vin can only use digits 0-9 and Uppercase letters A-H, J-N, P, R-Z, 17 characters long, cannot use I, O, or Q to avoid confusion
        if (!vin.matches("[A-HJ-NPR-Z0-9]{17}")) {
            System.out.println("Invalid VIN format.");
            return;
        }
        System.out.println("Enter vehicle make: ");
        String make = scanner.nextLine();
        System.out.println("Enter vehicle model: ");
        String model = scanner.nextLine();
        System.out.println("Enter vehicle color: ");
        String color = scanner.nextLine();
        System.out.println("Enter vehicle number of doors: ");
        int numberOfDoors;
        if (scanner.hasNextInt()) {
            numberOfDoors = scanner.nextInt();
        } else {
            System.out.println("Invalid input for number of doors.");
            return;
        }
        scanner.nextLine();
        System.out.println("Enter the number of owners: ");
        int numOwners = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Owner> owners = new ArrayList<>();
        for (int i = 0; i < numOwners; i++) {
            System.out.println("Enter owner unique ID for owner " + (i + 1) + ": ");
            int uniqueID = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            System.out.println("Enter owner first name for owner " + (i + 1) + ": ");
            String firstName = scanner.nextLine();
            System.out.println("Enter owner last name for owner " + (i + 1) + ": ");
            String lastName = scanner.nextLine();
            System.out.println("Enter owner address for owner " + (i + 1) + ": ");
            String address = scanner.nextLine();
            System.out.println("Enter owner city for owner " + (i + 1) + ": ");
            String city = scanner.nextLine();
            System.out.println("Enter owner state for owner " + (i + 1) + ": ");
            String ownerState = scanner.nextLine();
            System.out.println("Enter owner zip for owner " + (i + 1) + ": ");
            String zip = scanner.nextLine();

            owners.add(new Owner(uniqueID, firstName, lastName, address, city, ownerState, zip));
        }

        Vehicle vehicle = new Vehicle(vin, new Date(), make, model, color, numberOfDoors, plate);

        try {
            dmv.registerVehicle(owners, vehicle);
            System.out.println("Vehicle registered successfully!");
        } catch (Exception e) {
            System.out.println("Error registering vehicle: " + e.getMessage());
        }
    }

    private static void registerCitation(DMV dmv, Scanner scanner) {
    	scanner.nextLine();
    	System.out.println("Enter vehicle license plate: ");
        String plate = scanner.next();
        System.out.println("Enter offence code: ");
        int offenceCode;
        if (scanner.hasNextInt()) {
            offenceCode = scanner.nextInt();
        } else {
            System.out.println("Invalid input for offence code.");
            return;
        }
        System.out.println("Enter amount: ");
        double amount;
        if (scanner.hasNextDouble()) {
            amount = scanner.nextDouble();
        } else {
            System.out.println("Invalid input for amount.");
            return;
        }
        scanner.nextLine();
        System.out.println("Enter status: ");
        String status = scanner.nextLine();

        Registration registration = dmv.searchRegistrationByPlate(plate);
        if (registration != null) {
        	Date citationDate = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(citationDate);
            calendar.add(Calendar.DAY_OF_MONTH, 30); // Adding 30 days
            Date dueDate = calendar.getTime();
            Citation citation = new Citation(1, citationDate, dueDate, offenceCode, amount, status, registration);
            dmv.registerCitation(citation);
            System.out.println("Citation registered successfully!");
        } else {
            System.out.println("Vehicle not found. Cannot register citation.");
        }
    }

    private static void listRegistrationsForVehicle(DMV dmv, Scanner scanner) {
        System.out.println("Enter vehicle license plate: ");
        String plate = scanner.next();
        Registration registration = dmv.searchRegistrationByPlate(plate);
        if (registration != null) {
            System.out.println("Registrations for the vehicle:");
            // Print out the registration details
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
        } else {
            System.out.println("Vehicle not found.");
        }
    }
    private static void listRegistrationsForPerson(DMV dmv, Scanner scanner) {
        System.out.println("Enter owner unique ID: ");
        int uniqueID = scanner.nextInt();
        Owner owner = new Owner(uniqueID, "", "", "", "", "", ""); // Only set uniqueID
        Registration registration = dmv.searchRegistrationByOwner(owner);
        if (registration != null) {
            System.out.println("Registrations for the person:");
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
            for (Owner o : owners) {
                System.out.println("Owner ID: " + o.getUniqueID());
                System.out.println("Owner Name: " + o.getFirstName() + " " + o.getLastName());
                System.out.println("Owner Address: " + o.getAddress());
                System.out.println("Owner City: " + o.getCity());
                System.out.println("Owner State: " + o.getState());
                System.out.println("Owner Zip: " + o.getZip());
            }
        } else {
            System.out.println("Registrations not found for the person.");
        }
    }

    private static void listCitationsForVehicle(DMV dmv, Scanner scanner) {
        System.out.println("Enter vehicle license plate: ");
        String plate = scanner.next();
        Registration registration = dmv.searchRegistrationByPlate(plate);
        if (registration != null) {
            System.out.println("Citations for the vehicle:");
            boolean found = false;
            for (Citation citation : dmv.getCitations()) {
                if (citation != null && citation.getRegistration().equals(registration)) {
                    System.out.println("Citation ID: " + citation.getId());
                    System.out.println("Date: " + citation.getDate());
                    System.out.println("Offence Code: " + citation.getOffenceCode());
                    System.out.println("Amount: " + citation.getAmount());
                    System.out.println("Status: " + citation.getStatus());
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No citations found for the vehicle.");
            }
        } else {
            System.out.println("Vehicle not found.");
       }
    }

    private static void listCitationsForPerson(DMV dmv, Scanner scanner) {
        System.out.println("Enter owner unique ID: ");
        int uniqueID = scanner.nextInt();
        System.out.println("Citations for the person:");
        boolean found = false;
        for (Citation citation : dmv.getCitations()) {
            Registration registration = citation.getRegistration();
            if (registration != null) {
                ArrayList<Owner> owners = registration.getOwners();
                for (Owner owner : owners) {
                    if (owner.getUniqueID() == uniqueID) {
                        System.out.println("Citation ID: " + citation.getId());
                        System.out.println("Date: " + citation.getDate());
                        System.out.println("Offence Code: " + citation.getOffenceCode());
                        System.out.println("Amount: " + citation.getAmount());
                        System.out.println("Status: " + citation.getStatus());
                        found = true;
                        break; 
                    }
                }
            }
        }
        if (!found) {
            System.out.println("No citations found for the person.");
        }
    }
}