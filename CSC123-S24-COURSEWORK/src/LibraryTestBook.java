
public class LibraryTestBook {

	public static void main(String[] args) {
		
		Library library = new Library("Main Library", "Los Angeles California");
		
		Book book1 = new Book("Harry Potter and the Order of the Phoenix", "J.K. Rowling",766, "0439682584123");
		Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 180, "9781782808084");
		Book book3 = new Book("Moby Dick", "Herman Melville", 700, "9781234567897");
		
		System.out.println("Library: " + library);
		System.out.println("Book 1; " + book1);
		System.out.println("Book 2; " + book2);
		System.out.println("Book 3; " + book3);
	}

}
