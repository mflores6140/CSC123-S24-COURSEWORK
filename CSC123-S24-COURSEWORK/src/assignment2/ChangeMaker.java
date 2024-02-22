package assignment2;

public class ChangeMaker {

	public static void main(String[] args) {
		
		CoinCounter coinCounter = new CoinCounter(5, 6, 7, 8);
		
		System.out.println("Dollar Amount: $" + String.format("%.2f", coinCounter.getDollarAmount()));
        System.out.println("Cents Amount: " + coinCounter.getCentsAmount() + " cents");

	}

}
