package labs;
import java.util.ArrayList;
public class CarOwner {
	private ArrayList<Car> cars;
    private int age;
    private int height;
    private String firstName;
    private String lastName;

    public CarOwner(int age, int height, String firstName, String lastName) {
        this.age = age;
        this.height = height;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cars = new ArrayList<>();
    }

    public String toString() {
        return "CarOwner{" +
                "cars=" + cars +
                ", age=" + age +
                ", height=" + height +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public boolean equals(CarOwner obj) {
        return age == obj.age &&
                height == obj.height &&
                firstName.equals(obj.firstName) &&
                lastName.equals(obj.lastName);
    }
}
