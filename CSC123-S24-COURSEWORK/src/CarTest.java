
public class CarTest {
    public static void main(String[] args) {
        try {
            // Create a car 
            Car myCar = new Car("Toyota", "Corolla", "Red");

            // Test starting the car
            myCar.applyBrake();
            myCar.setTransmission("P");
            myCar.start();
            myCar.start(); // Attempting to start again and should throw CarAlreadyRunningException
        } catch (IncompleteCarConfigurationException | BrakesNotAppliedException | CarNotInParkedException | CarAlreadyRunningException e) {
            System.out.println(e.getMessage());
        }

        try {
            // Create a car without all required attributes
            Car incompleteCar = new Car("Mustang", null, "Red");
        } catch (IncompleteCarConfigurationException e) {
            System.out.println(e.getMessage());
        }

        try {
            // Create a car and trying to start without applying brakes
            Car carWithoutBrakes = new Car("Ford", "Fusion", "Black");
            carWithoutBrakes.setTransmission("P");
            carWithoutBrakes.start();
        } catch (BrakesNotAppliedException | CarNotInParkedException | CarAlreadyRunningException | IncompleteCarConfigurationException e) {
            System.out.println(e.getMessage());
        }

        try {
            // Create a car and trying to start without being in "P" transmission mode
            Car carNotInPark = new Car("Honda", "Civic", "White");
            carNotInPark.applyBrake();
            carNotInPark.setTransmission("D");
            carNotInPark.start();
        } catch (CarNotInParkedException | BrakesNotAppliedException | CarAlreadyRunningException | IncompleteCarConfigurationException e) {
            System.out.println(e.getMessage());
        }
    }
}
