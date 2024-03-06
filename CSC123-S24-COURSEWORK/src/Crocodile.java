
public class Crocodile extends Animal {

	String scalesType;
	
	public Crocodile(String name, int age, int weight, String scalesType) {
		super(name, age, weight);
		this.scalesType = scalesType;
	}
	
	public String getScalesType(){
		return scalesType;
	}
	public void setScalesType(String scalesType) {
		this.scalesType = scalesType;
	}
	@Override
	public String makeSound() {
		return("Hiss");
	}
		
}
