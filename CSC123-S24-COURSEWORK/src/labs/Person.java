package labs;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {

	String FirstName;
	String LastName;
	String DateOfBirth;
	
	public Person(String firstName, String lastName, String dateOfBirth) {
		this.FirstName = firstName;
		this.LastName = lastName;
		this.DateOfBirth = dateOfBirth;
	}
	
	public String getFullName() {
		
		return (FirstName + " " + LastName);
	}
	
	public int getAge() {
		LocalDate dateOfBirth = LocalDate.parse(DateOfBirth, DateTimeFormatter.ofPattern("dd,MM,yyyy"));
		return Period.between(dateOfBirth, LocalDate.now()).getYears();
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	
	public static void main(String[] args) {
		Person person = new Person("John","Doe","01,10,1999");
		System.out.println(person.toString());
	}

	@Override
	public String toString() {
		return  FirstName + " " + LastName + ", born " + DateOfBirth
				+ ". " + getFullName() + " their age is " + getAge() + ".";
	}
}
