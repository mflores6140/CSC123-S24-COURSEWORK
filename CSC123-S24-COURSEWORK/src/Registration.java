import java.util.ArrayList;
import java.util.Date;
public class Registration {

	private long uniqueID;
	private Date startDate;
	private Date endDate;
	private String plate;
	private Vehicle vehicle;
	private ArrayList<Owner> owners;
	
	public Registration(long uniqueID, Date startDate, Date endDate, String plate, Vehicle vehicle, ArrayList<Owner> owners) {
		this.uniqueID = uniqueID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.plate = plate;
		this.vehicle = vehicle;
		this.owners = owners;
	}
	
	public boolean isActive() {
		Date currentDate = new Date(); // Current date
        return (currentDate.after(startDate) && currentDate.before(endDate));
    }

	public long getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(long uniqueID) {
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

	public ArrayList<Owner> getOwners() {
		return owners;
	}

	public void setOwners(ArrayList<Owner> owners) {
		this.owners = owners;
	}
	
}
