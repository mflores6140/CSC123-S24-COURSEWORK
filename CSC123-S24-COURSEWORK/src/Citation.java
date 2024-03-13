import java.util.Date;
public class Citation {

    private int id;
    private Date date;
    private int offenceCode;
    private double amount;
    private String status;
    private Registration registration;
    private Date dueDate;
    public static final String PENDING = "Pending";
    public static final String PAID = "Paid";
    public static final String DISMISSED = "Dismissed";
    public static final String OVERDUE = "Overdue";

    public Citation(int id, Date date, Date dueDate, int offenceCode, double amount, String status, Registration registration) {
        this.id = id;
        this.date = date;
        this.offenceCode = offenceCode;
        this.amount = amount;
        this.status = status;
        this.registration = registration;
        this.dueDate= calculateDueDate(date); //due date calculated one month from date given    
    }
    private Date calculateDueDate(Date dateIssued) {
        long oneMonthInMillis = 30 * 24 * 60 * 60 * 1000L; // One month in milliseconds
        return new Date(dateIssued.getTime() + oneMonthInMillis);
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getOffenceCode() {
		return offenceCode;
	}

	public void setOffenceCode(int offenceCode) {
		this.offenceCode = offenceCode;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
