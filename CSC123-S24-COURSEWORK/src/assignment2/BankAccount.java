package assignment2;

public class BankAccount {

	private String ownerFirstName;
	private String ownerLastName;
	private double balance;
	private boolean isOpen;
	
	//constructor
	private BankAccount(String ownerFirstName, String ownerLastName, double initialDepositAmount) {
		this.ownerFirstName = ownerFirstName;
		this.ownerLastName = ownerLastName;
		this.balance = initialDepositAmount;
		this.isOpen = true;
	}
	
	
}
