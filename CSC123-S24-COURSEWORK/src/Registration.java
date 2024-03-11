import java.util.Date;
public class Registration {

	private String uniqueID;
	private Date startDate;
	private Date endDate;
	private String plate;
	private Vehicle vehicle;
	private Owner[] owners;
	
	public Registration(String uniqueID, Date startDate, Date endDate, String plate, Vehicle vehicle, Owner[] owners) {
		super();
		this.uniqueID = uniqueID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.plate = plate;
		this.vehicle = vehicle;
		this.owners = owners;
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Owner[] getOwners() {
		return owners;
	}

	public void setOwners(Owner[] owners) {
		this.owners = owners;
	}
	
}
