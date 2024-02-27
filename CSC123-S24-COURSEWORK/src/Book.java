
public class Book {
	
	String title;
	String author;
	int numberOfPages;
	String isbn;

	public Book(String title, String author, int numberOfPages, String isbn) {
		
		this.title=title;
		this.author=author;
		this.numberOfPages=numberOfPages;
		this.isbn=isbn;
	}
	
	public String toString() {
		
		return "Book named " + title + " , by " + author + " , number of pages: " + numberOfPages + " , isbn: " + isbn;
	}
	
	public boolean equals(Book b) {
		return numberOfPages == b.numberOfPages && isbn.equals(b.isbn) && title.equals(b.title) && author.equals(b.author);
	}
}
