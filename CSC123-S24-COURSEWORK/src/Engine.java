
public class Engine {
    private String fuelType;
    private String make;
    private String model;
    private String year;
    private String horsePower;

    public Engine(String fuelType, String make, String model, String year, String horsePower) {
        this.fuelType = fuelType;
        this.make = make;
        this.model = model;
        this.year = year;
        this.horsePower = horsePower;
    }

    public String toString() {
        return "Engine{" +
                "fuelType='" + fuelType + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", horsePower='" + horsePower + '\'' +
                '}';
    }

    public boolean equals(Engine obj) {
        return fuelType.equals(obj.fuelType) &&
                make.equals(obj.make) &&
                model.equals(obj.model) &&
                year.equals(obj.year) &&
                horsePower.equals(obj.horsePower);
    }
}
