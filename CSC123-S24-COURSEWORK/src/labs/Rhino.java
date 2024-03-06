package labs;
public class Rhino extends Animal{

	String hideType;
	
	public Rhino(String name, int age, int weight, String hideType) {
		super(name, age, weight);
		this.hideType = hideType;
	}
	
	public String getHideType(){
		return hideType;
	}
	public void setHideType(String hideType) {
		this.hideType = hideType;
	}
	@Override
	public String makeSound() {
		return("Mmwonk");
	}
		
}
