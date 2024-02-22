package labs;
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
	
	public Book(String author, String isbn, int pages, String publishingCompany, int amazonRank) {
		AuthorName = author;
		ISBN = isbn;
		NumberOfPages = pages;
		PublishingCompany = publishingCompany;
		AmazonRank = amazonRank;
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
	
	public String getISBN() {
		return ISBN;
	}
	
	public void setAmazonRank(int rankA) {
		AmazonRank = rankA;
	}
	
	public void setAuthor() {
		AuthorName = "Jimmy John";
	}
	
	public void setNumberOfPages() {
		NumberOfPages = 100;
	}
	
	public void setISBN() {
		ISBN = "ABC";
	}
	
	public void setPublishingCompany() {
		
	}
	
	public String toString() {
		return "Author: " + AuthorName + " ISBN: " + " Number of pages: " + NumberOfPages + " Amazon Rank: " + AmazonRank;
	}
	
	public boolean equals(Book b) {
		return getAuthor().equals(b.getAuthor()) && AmazonRank==b.getAmazonRank() && NumberOfPages==b.getNumberOfPages();
	}
	
	public Book creatCopy() {
		Book b = new Book(AuthorName, ISBN, NumberOfPages, PublishingCompany, AmazonRank);
		b.setAmazonRank(AmazonRank);
		return b;
	}

	
	
}
