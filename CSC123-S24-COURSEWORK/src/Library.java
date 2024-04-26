import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Library {
	
	private List<Member> members;
	private Map<String, List<Item>> catalog;
	public List<Loan> loans;
	
	public Library() {
		this.members = new ArrayList<>();
		this.catalog = new HashMap<>();
		this.loans = new ArrayList<>();
	}
	
	public Member registerMember(String memberId, String firstName, String lastName, boolean isChild, AdultMember guardian) {
	    Member member;
	    if (isChild) {
	        if (guardian == null) {
	            throw new IllegalArgumentException("Child members require an associated guardian.");
	        }
	        member = new ChildMember(memberId, firstName, lastName, guardian);
	    } else {
	        member = new AdultMember(memberId, firstName, lastName, "0");
	    }
	    members.add(member);
	    return member;
	}

	public void addMaterial(Material material, int quantity) {
		for (int i = 0; i < quantity; i++) {
            Item item = new Item(material);
            List<Item> items = catalog.getOrDefault(material.getType(), new ArrayList<>());
            items.add(item);
            catalog.put(material.getType(), items);
        }
    }
	
	public List<Member> getMembers() {
	    return members;
	}
	
	public Map<String, List<Item>> getCatalog() {
	    return this.catalog;
	}
	
	public void loadLibraryData(String directoryPath) throws ParseException {
	    String membersFilePath = directoryPath + File.separator + "Members.csv.txt";
	    String loansFilePath = directoryPath + File.separator + "Loans.csv.txt"; 
	    String materialsFilePath = directoryPath + File.separator + "Materials.csv.txt";

	    loadMembers(membersFilePath);
	    loadMaterials(materialsFilePath);
	    loadLoans(loansFilePath);
	}

    public void loadMembers(String directoryPath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(directoryPath))) {
            String line;
            boolean isFirstLine = true; // Flag first line
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip first line as header
                }
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String memberId = parts[0].trim();
                    String firstName = parts[1].trim();
                    String lastName = parts[2].trim();
                    boolean isChild = Boolean.parseBoolean(parts[3].trim());
                    AdultMember guardian = null;
                    if (isChild) {
                        String guardianId = parts[4].trim(); 
                        // Find the guardian from list of members
                        for (Member member : members) {
                            if (member instanceof AdultMember && member.getMemberId().equals(guardianId)) {
                                guardian = (AdultMember) member;
                                break;
                            }
                        }
                        if (guardian == null) {
                            System.out.println("Guardian not found for member ID: " + memberId);
                            continue; // Skip this member
                        }
                    }
                    // Register the member
                    registerMember(memberId, firstName, lastName, isChild, guardian);
                } else {
                    System.out.println("Invalid member data: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Members file not found - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: Input/output error while loading Members data - " + e.getMessage());
        }
    }

    public void loadLoans(String directoryPath) throws ParseException {
        try (BufferedReader reader = new BufferedReader(new FileReader(directoryPath))) {
            String line;
            boolean isFirstLine = true; // Flag first line
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip first line as header
                }
                String[] parts = line.split(",");

                if (parts.length == 4) {
                    String loanId = parts[0].trim();
                    String itemReference = parts[1].trim();
                    String borrowerId = parts[2].trim();
                    String dateString = parts[3].trim();

                    Date dueDate;
                    try {
                        dueDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
                    } catch (ParseException e) {
                        System.out.println("Error parsing date for loan: " + loanId);
                        continue;
                    }
                    Item item = findItemByReference(itemReference);
                    
                    if (item == null) {
                        System.out.println("Item not found for loan: " + loanId);
                        continue;
                    }
                    Member borrower = findMemberById(borrowerId);
                    if (borrower == null) {
                        System.out.println("Borrower not found for loan: " + loanId);
                        continue;
                    }
                    // Create a new Loan object with the provided loan ID
                    Loan loan = new Loan(loanId, item, borrower, dueDate);
                    addLoan(loan);
                } else {
                    System.out.println("Invalid loan data: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Loans file not found - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: Input/output error while loading Loans data - " + e.getMessage());
        }
    }

    public void loadMaterials(String directoryPath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(directoryPath))) {
            String line;
            boolean isFirstLine = true; // Flag first line as header
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    // Skip first line as headers
                    isFirstLine = false;
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    // Parse material data
                    String reference = parts[0].trim();
                    String type = parts[1].trim();
                    String title = parts[2].trim();
                    double replacementValue = Double.parseDouble(parts[3].trim());
                    String location = parts[4].trim();
                    boolean suitableForChildren = Boolean.parseBoolean(parts[5].trim());

                    // Create a new material with the provided data
                    Material material = new Material(title, type, replacementValue, location, suitableForChildren);
                    
                    // Create a new item with the material and set its reference
                    Item item = new Item(material);
                    item.setReference(reference);

                    // Add item to the catalog
                    List<Item> items = catalog.getOrDefault(type, new ArrayList<>()); // Use type as the key
                    items.add(item);
                    catalog.put(type, items); // Use type as the key

                } else {
                    System.out.println("Invalid material data: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Materials file not found - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: Input/output error while loading Materials data - " + e.getMessage());
        }
    }

    public void saveLibraryData(String directoryPath) throws FileNotFoundException{
        saveMembers(directoryPath);
        saveLoans(directoryPath);
        saveMaterials(directoryPath);
    }

    public void saveMembers(String directoryPath) {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(new File(directoryPath), false))) {
            writer.println("memberId,firstName,lastName,isChild,guardianId");
            for (Member member : members) {
                if (member instanceof AdultMember) {
                    writer.println(member.getMemberId() + "," + member.getFirstName() + "," + member.getLastName() + ",false,0");
                } else if (member instanceof ChildMember) {
                    ChildMember childMember = (ChildMember) member;
                    String guardianId = (childMember.getGuardian() != null) ? childMember.getGuardian().getMemberId() : "0";
                    writer.println(member.getMemberId() + "," + member.getFirstName() + "," + member.getLastName() + ",true," + guardianId);
                }
            }
            System.out.println("Members data saved successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Failed to save Members data - " + e.getMessage());
        }
    }

    public void saveLoans(String directoryPath)throws FileNotFoundException {
        String filePath = directoryPath;
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(new File(filePath), false))) {
            writer.println("loanId,itemId,memberId,dueDate");
        	for (Loan loan : loans) {
                writer.println(loan.getLoanId() + "," + loan.getItem().getReference() + "," + loan.getBorrower().getMemberId() + "," + (loan.getDueDate().getYear() + 1900 + "-" + (loan.getDueDate().getMonth() + 1) ) + "-" + loan.getDueDate().getDate());
            }
            System.out.println("Loans data saved successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Failed to save Loans data - " + e.getMessage());
        }
    }

    public void saveMaterials(String directoryPath)throws FileNotFoundException {
        String filePath = directoryPath;
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(new File(filePath), false))) {
            writer.println("reference,type,title,replacementValue,location,suitableForChildren");
            for (Map.Entry<String, List<Item>> entry : catalog.entrySet()) {
                for (Item item : entry.getValue()) {
                    Material material = item.getMaterial();
                    writer.println(item.getReference() + "," + material.getType() + "," + material.getTitle() + "," + material.getReplacementValue() + "," + material.getLocation() + "," + material.isSuitableForChildren());
                }
            }
            System.out.println("Materials data saved successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Failed to save Materials data - " + e.getMessage());
        }
    }
    
    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    public void removeLoanByItemReference(String itemReference) {
        loans.removeIf(loan -> loan.getItem().getReference().equals(itemReference));
    }
    
    public List<Loan> getLoans() {
        return loans;
    }
    
    private Item findItemByReference(String reference) {
    	Collection<List<Item>> collectionsValues = catalog.values();
        for (List<Item> itemList : collectionsValues) {
            for (Item item : itemList) {
                if (item.getReference().equals(reference)) {
                    return item;
                }
            }
        }
        return null; 
    }

    private Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }
}