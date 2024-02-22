package assignment2;

public class ChangeMaker {

	public static void main(String[] args) {
		
		CoinCounter coinCounter = new CoinCounter(5, 6, 7, 8);
        System.out.println("Dollar Amount: $" + String.format("%.2f", coinCounter.getDollarAmount()));
        System.out.println("Cents Amount: " + coinCounter.getCentsAmount() + " cents");
        
	}
	
	public static class CoinCounter{
		
		private int pennies;
		private int nickels;
		private int dimes; 
		private int quarters;
	
	public CoinCounter(int pennies, int nickels, int dimes, int quarters) {
		
	
		this.pennies = pennies;
		this.nickels = nickels;
		this.dimes = dimes;
		this.quarters = quarters;
	}
	
	public double getDollarAmount() {
		
		double totalDollars = 0.0;
		totalDollars += pennies * 0.01;
		totalDollars += nickels * 0.05;
		totalDollars += dimes * 0.10;
		totalDollars += quarters * 0.25;
		return totalDollars;
	}
	
	public int getCentsAmount() {
		
		int totalCents = 0;
		totalCents += pennies;
		totalCents += nickels * 5;
		totalCents += dimes * 10;
		totalCents += quarters * 25;
		return totalCents;
		
	}
	
	}

}
