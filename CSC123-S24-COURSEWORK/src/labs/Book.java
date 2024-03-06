
	public class Book{
		
	String PublishingCompany = "Pearson";
	String ISBN;
	int NumberOfPages = 0;
	String AuthorName;
	int AmazonRank = 0;
	
	
	//Constructor
	
	public Book(String author, String isbn) {
		AuthorName = author;
		ISBN = isbn;
	}
	
	public Book(String author, String isbn, int pages) {
		AuthorName = author;
		ISBN = isbn;
		NumberOfPages = pages;
	}
	
	public String getAuthor() {
		return AuthorName;
	}

	public int getAmazonRank() {
		return AmazonRank;
	}
	
	public int getNumberOfPages() {
		return NumberOfPages;
	}
	
	public void setAmazonRank(int rankA) {
		AmazonRank = rankA;
	}
	
	public String toString() {
		return "Author: " + AuthorName + " ISBN: " + " Number of pages: " + NumberOfPages + " Amazon Rank: " + AmazonRank;
	}
	
	public boolean equals(Book b) {
		return getAuthor().equals(b.getAuthor()) && AmazonRank==b.getAmazonRank() && NumberOfPages==b.getNumberOfPages();
	}
	
	public Book creatCopy() {
		Book b = new Book(AuthorName, ISBN, NumberOfPages);
		b.setAmazonRank(AmazonRank);
		return b;
	}

	
	
}
