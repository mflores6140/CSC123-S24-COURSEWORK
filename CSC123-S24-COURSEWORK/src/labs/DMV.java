package labs;

import Car;

public class DMV {
    private String address;
    private String timeOpen;
    private String timeClosed;
    private int registeredCars;
    private int capacity;

    public DMV(String address, String timeOpen, String timeClosed, int capacity) {
        this.address = address;
        this.timeOpen = timeOpen;
        this.timeClosed = timeClosed;
        this.capacity = capacity;
        this.registeredCars = 0;
    }

    public void registerCar(Car car) {
        // Register the car here
        registeredCars++;
    }

    public String toString() {
        return "DMV{" +
                "address='" + address + '\'' +
                ", timeOpen='" + timeOpen + '\'' +
                ", timeClosed='" + timeClosed + '\'' +
                ", registeredCars=" + registeredCars +
                ", capacity=" + capacity +
                '}';
    }

    public boolean equals(DMV obj) {
        return address.equals(obj.address) &&
                timeOpen.equals(obj.timeOpen) &&
                timeClosed.equals(obj.timeClosed) &&
                registeredCars == obj.registeredCars &&
                capacity == obj.capacity;
    }
}
