package labs;

public class BankAccount {

    public static final int open = 1; //open is true
    public static final int closed = 0; //closed is false

    private int state;
    private double balance;

    // Constructor
    public BankAccount() {
        this.state = open; // Initially set the account state to Open
        this.balance = 0.0; // Initialize balance to zero
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (state == open && amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited successfully.");
        } else {
            System.out.println("Unable to deposit. Account is closed or invalid amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (state == open && amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully.");
        } else {
            System.out.println("Unable to withdraw. Account is closed, insufficient funds, or invalid amount.");
        }
    }

    // Method to view account statement
    public void viewStatement() {
        if (state == open) {
            System.out.println("Account Statement:");
            // You can add more detailed statements if needed
            System.out.println("Balance: $" + balance);
        } else {
            System.out.println("Account is closed. Cannot view statement.");
        }
    }

    // Method to view balance
    public double getBalance() {
        if (state == open) {
            return balance;
        } else {
            System.out.println("Account is closed. Cannot view balance.");
            return 0.0; // Or throw an exception
        }
    }

    // Method to close the account
    public void closeAccount() {
        if (state == open) {
            state = closed;
            System.out.println("Account closed successfully.");
        } else {
            System.out.println("Account is already closed.");
        }
    }
}
