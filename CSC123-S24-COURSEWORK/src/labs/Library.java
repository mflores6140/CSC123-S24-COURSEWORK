package labs;

public class Library {
	
	String name;
	String address;
	
	public Library(String name, String address) {
		
		this.name=name;
		this.address=address;
	}
	
	public String toString() {
		return  name + " , in " + address;
	}
	
	public boolean equals(Library l) {
		return name.equals(l.name)&& address.equals(l.address); 
	}
}
