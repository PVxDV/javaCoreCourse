package InterfacesRemasted;

enum FlightStages implements Trackable {
    GROUNDED, LAUNCH, CRUISE, DATA_COLLECTION;

    @Override
    public void track() {
        if (this != GROUNDED) {
            System.out.println("Monitoring " + this);
        }
    }

    public FlightStages getNextStage() {
        FlightStages[] allStages = values();
        return allStages[(ordinal() + 1) % allStages.length];
    }
}

record DragonFly(String name, String type) implements FlightEnabled {

    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}

class Satellite implements OrbitEarth {

    FlightStages stage = FlightStages.GROUNDED;

    public void achieveOrbit() {
        transition("Orbit achieved!");
    }

    @Override
    public void takeOff() {
        transition("Taking Off");
    }

    @Override
    public void land() {
        transition("Landing");
    }

    @Override
    public void fly() {
        achieveOrbit();
        transition("Data Collection while Orbiting");
    }

    public void transition(String description) {
        System.out.println(description);
        stage = transition(stage);
        stage.track();
    }
}

interface OrbitEarth extends FlightEnabled { // Unlike a class, an interface can use the
    // extends expression with multiple interfaces
    // but interface CAN'T implement another interface
    void achieveOrbit();

    //static void log(String description) { // that's specify public, we can add this modifier, but it would just be redundant
    // all methods on an interface are public, unless otherwise specified

    //    var today = new java.util.Date(); // if we use fully qualified name, we don't have to use "import...."
    //    System.out.println(today + ": " + description);
    //}

    private static void log(String description) {

        var today = new java.util.Date();
        System.out.println(today + ": " + description);
    }

    private void logStage(FlightStages stage, String description) {
        description = stage + ": " + description;
        log(description);
    }

    @Override
    default FlightStages transition(FlightStages stage) {
        FlightStages nextStage = FlightEnabled.super.transition(stage);
        logStage(stage, "Beginning Transition to " + nextStage);
        return nextStage;
    }
}

interface FlightEnabled { //abstract modifier here is unnecessary cos it's declared, for all interfaces
    public static final double MILES_TO_KM = 1.60934; // "public static final double" equals just "double", it's unnecessary modifications
    double KM_TO_MILES = 0.621371;

    public abstract void takeOff(); //abstract modifier here is unnecessary cos it's declared, for all interfaces

    // in fact, any method declared without a bode, is really
    // implicitly declared both public and abstract
    abstract void land();

    void fly(); // This is PREFERRED(!) declaration, public and abstract are implied

    default FlightStages transition(FlightStages stage) { // default method. Classes that implemented this interface
        // are not required to override this method
        // this is default method
        // System.out.println("transition not implemented on " + getClass().getName()); // it's common practice
        // or we can throw an exception
        // return null;

        FlightStages nextStage = stage.getNextStage();
        System.out.println("Transitioning from " + stage + " to " + nextStage);
        return nextStage;
    }
}

interface Trackable {
    void track();
}

public abstract class Animal {
    public abstract void move();
}
