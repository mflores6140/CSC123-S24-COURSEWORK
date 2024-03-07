

public class Car {
    private String make;
    private String color;
    private String model;
    private String year;
    private String plate;
    private String owner;
    private boolean isRunning;
    private boolean isBrakApplied;
    private String transmission;

    public Car(String make, String color, String model) throws IncompleteCarConfigurationException {
    	if (make == null || model == null || color == null) {
            throw new IncompleteCarConfigurationException("Make, model, and color must be provided");
        }
    	this.make = make;
        this.color = color;
        this.model = model;
        this.year = year;
        this.plate = plate;
        this.owner = ""; 
        
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", plate='" + plate + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }

    public boolean equals(Car c) {
    	return make.equals(c.make) &&
        color.equals(c.color) &&
        model.equals(c.model) &&
        year.equals(c.year) &&
        plate.equals(c.plate) &&
        owner.equals(c.owner);
    }
    public void start() throws CarAlreadyRunningException, CarNotInParkedException, BrakesNotAppliedException {
        if (isRunning) {
            throw new CarAlreadyRunningException("Car is already running.");
        }

        if (!transmission.equals("P")) {
            throw new CarNotInParkedException("Car is not in 'P' transmission mode.");
        }

        if (!isBrakApplied) {
            throw new BrakesNotAppliedException("Brakes are not applied.");
        }

        // If none of the above exceptions are thrown, start the car
        isRunning = true;
        System.out.println("Car started.");
    }

    public void stop() {
        if (isRunning) {
            isRunning = false;
            System.out.println("Car stopped.");
        } else {
            System.out.println("Car is not running.");
        }
    }

    public void applyBrake() {
        isBrakApplied = true;
        System.out.println("Brakes applied.");
    }

    public void releaseBrake() {
        isBrakApplied = false;
        System.out.println("Brakes released.");
    }

    public boolean isBrakeApplied() {
        return isBrakApplied;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
}

