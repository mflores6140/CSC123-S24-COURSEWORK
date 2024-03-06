
public class Lion extends Animal{

	String furColor;
	
	public Lion(String name, int age, int weight, String furColor) {
		super(name, age, weight);
		this.furColor = furColor;
	}
	
	public String getFurColor() {
		return furColor;
	}
	public void setFurColor(String furColor) {
		this.furColor = furColor;
	}
	@Override
	public String makeSound() {
		return("Roar");
	}
}
