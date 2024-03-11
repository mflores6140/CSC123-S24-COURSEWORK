import java.util.Date;
public class Vehicle {
	private String vin;
    private Date dateOfMfg;
    private String make;
    private String model;
    private String color;
    private int numberOfDoors;
    private String plate;

    public Vehicle(String vin, Date dateOfMfg, String make, String model, String color, int numberOfDoors, String plate) {
        this.vin = vin;
        this.dateOfMfg = dateOfMfg;
        this.make = make;
        this.model = model;
        this.color = color;
        this.numberOfDoors = numberOfDoors;
        this.setPlate(plate);
    }

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public Date getDateOfMfg() {
		return dateOfMfg;
	}

	public void setDateOfMfg(Date dateOfMfg) {
		this.dateOfMfg = dateOfMfg;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNumberOfDoors() {
		return numberOfDoors;
	}

	public void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

}
