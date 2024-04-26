import java.util.Date;

public class Loan {
    private String loanId;
    private Item item;
    private Member borrower;
    private Date dueDate;

    public Loan(String loanId, Item item, Member borrower, Date dueDate) {
        this.loanId = loanId;
        this.item = item;
        this.borrower = borrower;
        this.dueDate = dueDate;
    }

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Member getBorrower() {
		return borrower;
	}

	public void setBorrower(Member borrower) {
		this.borrower = borrower;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
}
