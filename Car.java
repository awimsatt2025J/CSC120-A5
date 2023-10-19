//Work on this class second
import java.util.ArrayList;

/**
 * Use as a container for Passenger objects
 */
public class Car {
    
    private ArrayList<Passenger> passengers;
    int maxCapacity;

    public Car(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.passengers  = new ArrayList<Passenger>(maxCapacity); //manually limits ArrayList size to the car's max capacity
    }

    /**
     * Gets the maximum capacity of a Car object
     * @return maxCapacity
     */
    public int getCapacity() {
        return this.maxCapacity;
    }

    /**
     * Gets the remaining seats of a Car object
     * @return number of remaining seats in a car
     */
    public int seatsRemaining() {
        return this.maxCapacity - passengers.size();
    }

    /**
     * Adds a passenger to a car, first checking if there are seats available
     * @param p
     */
    public void addPassenger(Passenger p) {
        if(passengers.size() < this.maxCapacity) {
            passengers.add(p);
        } else {
            throw new RuntimeException("No seats available in the car.");
        }
    }

    /**
     * Removes a passenger from a car, first checking if the car contains the passenger
     * @param p
     */
    public void removePassenger(Passenger p) {
        if(!this.passengers.contains(p)) {
            throw new RuntimeException(p.name + "is not in the car.");
        }
        this.passengers.remove(p);
    }

    /**
     * Prints out a list of all the passengers aboard a car
     */
    public void printManifest() {
        if(passengers.isEmpty()) {
            System.out.println("This car is EMPTY.");
        } else {
            System.out.println("Passengers aboard are: ");
            for(Passenger p : passengers) {
                System.out.println("- " + p.name);
            }
        }
    }


    public static void main(String[] args) {
        Car myCar = new Car(10);
        myCar.getCapacity();
        Passenger Annie = new Passenger("Annie");
        myCar.addPassenger(Annie);
        System.out.println(myCar.seatsRemaining());

        Passenger Nikki = new Passenger("Nikki");
        myCar.addPassenger(Nikki);
        Passenger Kerry = new Passenger("Kerry");
        myCar.addPassenger(Kerry);

        System.out.println(myCar.seatsRemaining());
    }

    public char[] get(int i) {
        return null;
    }
}