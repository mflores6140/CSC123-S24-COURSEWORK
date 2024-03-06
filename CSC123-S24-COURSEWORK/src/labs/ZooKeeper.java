package labs;
public class ZooKeeper {

	public static void main(String[] args) {
		
		Animal genericAnimal = new Animal("Generic Animal", 5, 120);
        Lion lion = new Lion("Simba", 4, 100, "LightBrown");
        
        System.out.println("Generic Animal Details:");
        System.out.println("Name: " + genericAnimal.getName());
        System.out.println("Age: " + genericAnimal.getAge());
        System.out.println("Weight: " + genericAnimal.getWeight());
        genericAnimal.makeSound();

        System.out.println();

        System.out.println("Lion Details:");
        System.out.println("Name: " + lion.getName());
        System.out.println("Age: " + lion.getAge());
        System.out.println("Weight: " + lion.getWeight());
        System.out.println("Fur Color: " + lion.getFurColor());
        lion.makeSound();
        
        Crocodile crocodile = new Crocodile("KillerCroc", 10, 300, "Jagged");
        
        System.out.println();

        System.out.println("Crocodile Details:");
        System.out.println("Name: " + crocodile.getName());
        System.out.println("Age: " + crocodile.getAge());
        System.out.println("Weight: " + crocodile.getWeight());
        System.out.println("Fur Color: " + crocodile.getScalesType());
        crocodile.makeSound();
        
        Rhino rhino = new Rhino("", 6, 350, "white");
        
        System.out.println();

        System.out.println("Rhino Details:");
        System.out.println("Name: " + rhino.getName());
        System.out.println("Age: " + rhino.getAge());
        System.out.println("Weight: " + rhino.getWeight());
        System.out.println("Fur Color: " + rhino.getHideType());
        rhino.makeSound();
        
        Animal newAnimal = new Rhino ("Betty", 9, 280, "black"); 
        	System.out.println("Rhino " + rhino.makeSound());
        
        Animal newAnimal2 = new Crocodile ("Betty", 9, 280, "black"); 
        System.out.println("Crocodile " + crocodile.makeSound());
	}

}
