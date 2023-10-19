//Work on this class third

/**
 * Stores information about an individual passenger
 */
public class Passenger {
    
    String name;

    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Adds a specific passenger to a given car, checking if there are seats available
     * @param c
     */
    public void boardCar(Car c) {
        try {
            c.addPassenger(this);
            System.out.println(this.name + " boarded the car.");
        } catch (RuntimeException e) {
            System.out.println("No seats available in the car.");
        }
    }

    /**
     * Removes a specific passenger to a given car, checking if the car contains the passenger
     * @param c
     */
    public void getOffCar(Car c) {
        try{
            c.removePassenger(this);
            System.out.println(this.name + " got off the car.");
        } catch (RuntimeException e) {
            System.out.println(this.name + "is not in the car.");
        }
    }

    public static void main(String[] args) {
        Car oneCar = new Car(10);
        Passenger Mia = new Passenger("Mia");
        Passenger Kortney = new Passenger("Kortney");
        Passenger Kate = new Passenger("Kate");

        Mia.boardCar(oneCar);
        Kortney.boardCar(oneCar);
        Kate.boardCar(oneCar);

        oneCar.printManifest();

        Mia.getOffCar(oneCar);
        Kortney.getOffCar(oneCar);
        Kate.getOffCar(oneCar);

        oneCar.printManifest();
    }
}
