import java.util.Random;

public class Item {
	private static final String REFERENCE = "ITEM";
    private static int nextId = 2;

    private String reference;
    private Material material;
    private boolean onLoan;
    private Member borrower;

    public Item(Material material) {
        this.reference = generateReference();
        this.material = material;
        this.onLoan = false;
        this.borrower = null;
    }

    private String generateReference() {
        String randomLetters = generateRandomLetters(3);
        int id = nextId++;
        return REFERENCE + randomLetters + id;
    }

    private String generateRandomLetters(int length) {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(letters.charAt(random.nextInt(letters.length())));
        }
        return sb.toString();
    }

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public boolean isOnLoan() {
		return onLoan;
	}

	public void setOnLoan(boolean onLoan) {
		this.onLoan = onLoan;
	}

	public Member getBorrower() {
		return borrower;
	}

	public void setBorrower(Member borrower) {
		this.borrower = borrower;
	}
	
	public boolean isAvailable() {
		return !this.onLoan;
	}
	
	public String getLocation() {
		return this.material.getLocation();
	}
}
