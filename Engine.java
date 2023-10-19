//Work on this class first

/**
 * Represents the locomotive engine, storing information about its fuel type, level, etc.
 */
public class Engine {

    private FuelType f;
    double maxFuelLevel;
    double currentFuelLevel;

    public Engine(FuelType f, double maxFuelLevel) {
        this.maxFuelLevel = maxFuelLevel;
        this.currentFuelLevel = maxFuelLevel;
        this.f = f;
    }

    /**
     * Resets the Engine's current fuel level to the maximum
     */
    public void refuel() {
        this.currentFuelLevel = maxFuelLevel;
    }

    /**
     * Decreases the current fuel level and prints remaining fuel level, provided the fuel level is above 0
     */
    public void go() {
        if(this.currentFuelLevel > 0) {
            this.currentFuelLevel -= 1;
            System.out.println("Remaining fuel level = " + this.currentFuelLevel);
        }
        else { //throws a RuntimeException if the fuel level is not above 0
            throw new RuntimeException("Fuel level is 0. Please refuel.");
        }
    }


    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0);
        try {
            while (true) {
                myEngine.go();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); //Out of fuel
        }
    }
}