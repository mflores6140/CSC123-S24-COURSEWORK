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
	
	//method to deposit
	public boolean deposit(double amount) {
		if(amount > 0 && isOpen) {
			balance += amount;
			return true;
		}
		return false;
	}
	
	//method to withdraw
	public boolean withdraw(double amount) {
		if(amount > 0 && isOpen && balance >= amount) {
			balance =- amount;
			return true;
		}
		return false;
	}
}
