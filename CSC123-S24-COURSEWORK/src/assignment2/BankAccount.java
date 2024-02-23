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
	
	//method for checking if account is open
	public boolean isOpen() {
		return isOpen;
	}
	
	//method for closing account
	public void close() {
		isOpen = false;
	}
	
	//method for getting account owner's full name
	public String getOwnerFullName() {
		return ownerFirstName + " " + ownerLastName;
	}
}
