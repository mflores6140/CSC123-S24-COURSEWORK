import java.util.*;
import java.io.*;
import java.text.ParseException;

public class App {
	private static Library library;
	
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException{
    	String membersFilePath = "C:\\Users\\angel\\csc123-s24-mywork\\LibraryData\\Members.csv.txt";
        String loansFilePath = "C:\\Users\\angel\\csc123-s24-mywork\\LibraryData\\Loans.csv.txt";
        String materialsFilePath = "C:\\Users\\angel\\csc123-s24-mywork\\LibraryData\\Materials.csv.txt";
               
        library = new Library();
        library.loadMembers(membersFilePath);
        library.loadMaterials(materialsFilePath);
        library.loadLoans(loansFilePath);
        
        
    	while (true) {
            displayMenu();
            int choice = InputValidator.getInt("Please enter your choice: ");

            switch (choice) {
                case 1:
                    newMembership();
                    break;
                case 2:
                    addMaterial();
                    break;
                case 3:
                    issueItem();
                    break;
                case 4:
                    returnItem();
                    break;
                case 5:
                    reportInventory();
                    break;
                case 6:
                    reportLoans();
                    break;
                case 7:
                    lookupMembership();
                    break;
                case 8:
                	library.saveMembers(membersFilePath);
                	library.saveLoans(loansFilePath);
                	library.saveMaterials(materialsFilePath);
                    System.out.println("Exiting the program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("1 – New Membership");
        System.out.println("2 – Add Material");
        System.out.println("3 – Issue Item");
        System.out.println("4 – Return Item");
        System.out.println("5 – Report Inventory");
        System.out.println("6 – Report Loans");
        System.out.println("7 – Lookup Membership");
        System.out.println("8 – Exit");
    }

    private static void newMembership() {
        System.out.println("Creating new membership...");
        String memberId = InputValidator.getString("Enter member ID: ");
        String firstName = InputValidator.getString("Enter first name: ");
        String lastName = InputValidator.getString("Enter last name: ");
        boolean isChild = InputValidator.getBoolean("Is the member a child? (true/false): ");
        AdultMember guardian = null;
        if (isChild) {
            String guardianId = InputValidator.getString("Enter guardian's member ID: ");
            // Find the guardian from the existing members
            for (Member member : library.getMembers()) {
                if (member instanceof AdultMember && member.getMemberId().equals(guardianId)) {
                    guardian = (AdultMember) member;
                    break;
                }
            }
            if (guardian == null) {
                System.out.println("Guardian not found.");
                return;
            }
        }
        Member member = library.registerMember(memberId, firstName, lastName, isChild, guardian);
        System.out.println("New membership created for: " + member.getFullName());
    }

    private static void addMaterial() {
        System.out.println("Adding new material...");
        String type = InputValidator.getString("Enter material type (Book, Magazine, DVD): ");
        String title = InputValidator.getString("Enter title: ");
        double replacementValue = InputValidator.getDouble("Enter replacement value: ");
        String location = InputValidator.getString("Enter location: ");
        boolean suitableForChildren = InputValidator.getBoolean("Is the material suitable for children? (true/false): ");
        int quantity = InputValidator.getInt("Enter quantity: ");
        Material material = new Material(type, title, replacementValue, location, suitableForChildren);
        library.addMaterial(material, quantity);
        System.out.println("Material added successfully.");
    }

    private static void issueItem() {
        System.out.println("Issuing item...");
        String memberId = InputValidator.getString("Enter member ID: ");
        Member borrower = findMemberById(memberId);
        if (borrower == null) {
            System.out.println("Member not found.");
            return;
        }
        String itemReference = InputValidator.getString("Enter item reference: ");
        Item item = findItemByReference(itemReference);
        if (item == null) {
            System.out.println("Item does not exist.");
            return;
        }
        if (!item.isAvailable()) {
            System.out.println("Item is on loan.");
            return;
        }
        // Issue the item
        item.setOnLoan(true);
        item.setBorrower(borrower);
        Date dueDate = calculateDueDate();
        Loan loan = new Loan(generateLoanId(), item, borrower, dueDate);
        library.addLoan(loan);
        System.out.println("Item issued successfully.");
    }

    private static void returnItem() {
        System.out.println("Returning item...");
        String itemReference = InputValidator.getString("Enter item reference: ");
        Item item = findItemByReference(itemReference);
        if (item == null || item.isAvailable()) {
            System.out.println("Item is not on loan or does not exist.");
            return;
        }
        // Return the item
        item.setOnLoan(false);
        item.setBorrower(null);
        library.removeLoanByItemReference(itemReference);
        System.out.println("Item returned successfully.");
    }
    
    private static Member findMemberById(String memberId) {
        for (Member member : library.getMembers()) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }
    
	
	  private static Item findItemByReference(String reference) { 
		  for (List<Item> itemList : library.getCatalog().values()) { 
			  for (Item item : itemList) { if (item.getReference().equals(reference)) { 
				  return item; } } } return null; }
	 
    
    private static Date calculateDueDate() {
        // Calculate due date
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 2);
        return calendar.getTime();
    }

    private static String generateLoanId() {
        // Generate a unique loan ID using UUID
        return UUID.randomUUID().toString();
    }

    public static void reportInventory() {
        System.out.println("Reporting inventory...");
        System.out.println("Item Reference | Item Type | Available | Location");
        System.out.println("--------------------------------------------------");
        
        for (Map.Entry<String, List<Item>> entry : library.getCatalog().entrySet()) {
            List<Item> items = entry.getValue();
            for (Item item : items) {
            	Material material = item.getMaterial();
                String availableStatus = item.isAvailable() ? "Yes" : "No";
                System.out.printf("%-14s | %-9s | %-9s | %s\n", item.getReference(), material.getType(), availableStatus, item.getLocation());
            }
        }
    }

    public static void reportLoans() {
        System.out.println("Reporting loans...");
        System.out.println("Loan ID | Item Reference | Borrower | Due Date");
        System.out.println("-------------------------------------------------");
        for (Loan loan : library.getLoans()) {
            System.out.printf("%-8s | %-14s | %-8s | %s\n", loan.getLoanId(), loan.getItem().getReference(), loan.getBorrower().getFullName(), loan.getDueDate());
        }
    }

    private static void lookupMembership() {
        System.out.println("Looking up membership...");
        String memberId = InputValidator.getString("Enter member ID: ");
        Member member = findMemberById(memberId);
        if (member != null) {
            System.out.println("Member found:");
            System.out.println("Member ID: " + member.getMemberId());
            System.out.println("Name: " + member.getFullName());
            if (member instanceof ChildMember) {
                AdultMember guardian = ((ChildMember) member).getGuardian();
                System.out.println("Guardian: " + guardian.getFullName());
            }
        } else {
            System.out.println("Member not found.");
        }
    }
}