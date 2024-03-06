package labs;

public class Car {
    private String make;
    private String color;
    private String model;
    private String year;
    private String plate;
    private String owner;

    public Car(String make, String color, String model, String year, String plate) {
        this.make = make;
        this.color = color;
        this.model = model;
        this.year = year;
        this.plate = plate;
        this.owner = ""; // Initialize owner as an empty string
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

}
