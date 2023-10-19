//Work on this class fourth
import java.util.ArrayList;

/**
 * Ties all the other classes together
 */
public class Train {

    private final Engine engine;
    private ArrayList<Car> cars;

    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity) {
        this.engine = new Engine(fuelType, fuelCapacity);
        this.cars = new ArrayList<Car>(nCars);
        for(int i = 0; i < nCars; i++) {
            cars.add(new Car(passengerCapacity));
        } 
    }

    /**
     * Gets an Engine object
     * @return an Engine object
     */
    public Engine getEngine(){
        return this.engine;
    }

    /**
     * Gets the car at position i in the train
     * @param i - the location of the car in the train
     * @return a Car object
     */
    public Car getCar(int i) { //returns the i-th car
        if(i>= 0 && i < cars.size()) {
            return cars.get(i);
        } else {
            throw new IllegalArgumentException("Invalid car index.");
        }
    }

    /**
     * Gets the maximum total capacity across all cars (the whole train)
     * @return maxCapacity - the maximum total capacity across all Cars
     */
    public int getMaxCapacity() { //return the max total capacity across all Cars
        int maxCapacity = 0;
        for(Car car : cars) {
            maxCapacity += car.getCapacity();
        }
        return maxCapacity;
    }

    /**
     * Gets the number of remaining seats open across all cars (the whole train)
     * @return remainingSeats - the number of remaining seats open across all Cars
     */
    public int seatsRemaining() { //return the num remaining open seats across all Cars
        int remainingSeats = 0;
        for(Car car : cars) {
            remainingSeats += car.seatsRemaining();
        }
        return remainingSeats;
    }

    /**
     * Prints a roster of all passengers on board the train
     */
    public void printManifest() { //prints a roster of all Passengers onboard
        System.out.println("Train Manifest: ");
        for(int i = 0; i < cars.size(); i++) {
            System.out.println("Car " + (i + 1) + ":");
            cars.get(i).printManifest();
        }
    }

    public static void main(String[] args) {
        Train train = new Train(FuelType.ELECTRIC, 100.0, 3, 10);

        Passenger Bob = new Passenger("Bob");
        Passenger Becky = new Passenger("Becky");
        Passenger Debra = new Passenger("Debra");

        //Passengers board onto the train
        Bob.boardCar(train.getCar(0));
        Becky.boardCar(train.getCar(1));
        Debra.boardCar(train.getCar(2));

        //Print train manifest
        train.printManifest();

        //Print remaining seats
        System.out.println("Remaining seats: " + train.seatsRemaining());
    }
}
