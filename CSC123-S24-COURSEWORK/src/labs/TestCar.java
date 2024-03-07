package labs;

import Car;

public class TestCar {

	public static void main(String[] args) {
        // Create instances of Engine and Tires
        Engine engine = new Engine("Gasoline", "Toyota", "V6", "2021", "250hp");
        Tires tires = new Tires("10mm", "Rubber", "All-Season", "18-inch", "All-Weather");

        // Create an instance of Car using the above objects
        Car car = new Car("Toyota", "Red", "Camry", "2020", "ABC123");
        car.setOwner("John Doe"); // Set owner

        // Create an instance of CarOwner and associate it with the car
        CarOwner owner = new CarOwner(30, 180, "John", "Doe");
        car.setOwner(owner.toString());

        // Create an instance of DMV and register the car
        DMV dmv = new DMV("123 Main St", "6:00 AM", "6:00 PM", 100);
        dmv.registerCar(car);

        // Display Information
        System.out.println("Car Information:");
        System.out.println(car.toString());

        System.out.println("\nOwner Information:");
        System.out.println(owner.toString());

        System.out.println("\nEngine Information:");
        System.out.println(engine.toString());

        System.out.println("\nTires Information:");
        System.out.println(tires.toString());

        System.out.println("\nDMV Information:");
        System.out.println(dmv.toString());
    }

}
