import java.util.Date;
import java.util.Scanner;

public class TestDMV {
    public static void main(String[] args) {
        DMV dmv = new DMV("NY");

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
    	System.out.println("Enter vehicle license plate: ");
        String plate = scanner.next();
        scanner.nextLine();
    	System.out.println("Enter vehicle VIN: ");
        String vin = scanner.next();
        scanner.nextLine();
        System.out.println("Enter vehicle make: ");
        String make = scanner.nextLine();
        System.out.println("Enter vehicle model: ");
        String model = scanner.nextLine();
        System.out.println("Enter vehicle color: ");
        String color = scanner.nextLine();
        System.out.println("Enter vehicle number of doors: ");
        int numberOfDoors = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter owner unique ID: ");
        int uniqueID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter owner first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter owner last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter owner address: ");
        String address = scanner.nextLine();
        System.out.println("Enter owner city: ");
        String city = scanner.nextLine();
        System.out.println("Enter owner state: ");
        String ownerState = scanner.nextLine();
        System.out.println("Enter owner zip: ");
        String zip = scanner.nextLine();

        Owner owner = new Owner(uniqueID, firstName, lastName, address, city, ownerState, zip);
        Vehicle vehicle = new Vehicle(vin, new Date(), make, model, color, numberOfDoors, plate);
        Owner[] owners = {owner};

        try {
            dmv.registerVehicle(owners, vehicle);
            System.out.println("Vehicle registered successfully!");
        } catch (Exception e) {
            System.out.println("Error registering vehicle: " + e.getMessage());
        }
    }

    private static void registerCitation(DMV dmv, Scanner scanner) {
        System.out.println("Enter vehicle license plate: ");
        String plate = scanner.next();
        System.out.println("Enter offence code: ");
        int offenceCode = scanner.nextInt();
        System.out.println("Enter amount: ");
        double amount = scanner.nextDouble();
        System.out.println("Enter status: ");
        String status = scanner.next();

        Registration registration = dmv.searchRegistrationByPlate(plate);
        if (registration != null) {
            Citation citation = new Citation(1, new Date(), offenceCode, amount, status, registration);
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
            System.out.println(registration);
        } else {
            System.out.println("Vehicle not found.");
        }
    }
}