package com.bilgeadam.java.tutorials.oop.inheritance;

/**
 * This class uses vehicle properties and only implements methods specific to car type.
 * Car 'is a' Vehicle relation established.
 */
public class Car extends Vehicle {

    private short nbOfPassengers, nbOfDoors;

    private static final String plateRegex = "\\d+\\w+\\d+";

    // Diesel, Electric, Gasoline
    private String engineType;

    /**
     * A car object generated from vehicle
     * @param chassisNo      chassis of the car acquired from Vehicle class.
     * @param environment    environment of the car (sea, air, etc.) acquired from Vehicle class.
     * @param nbOfPassengers number of passengers for the car.
     * @param nbOfDoors      number of doors of the car.
     * @param engineType     type of engine (Diesel, Electric, Gasoline) of the car.
     */
    public Car(String chassisNo, String environment, short nbOfPassengers, short nbOfDoors, String engineType) {
        // First call extended class constructor.
        super(chassisNo, environment);

        this.setNbOfPassengers(nbOfPassengers);
        this.setNbOfDoors(nbOfDoors);
        this.engineType = engineType;
    }

    /**
     *
     * @return number of passengers for the car.
     */
    public short getNbOfPassengers() {
        return nbOfPassengers;
    }

    /**
     *
     * @param nbOfPassengers number of passengers for the car.
     */
    public void setNbOfPassengers(short nbOfPassengers) {
        if (nbOfPassengers >= 0)
            this.nbOfPassengers = nbOfPassengers;
        else
            throw new IllegalArgumentException("Number of passengers should be positive.");
    }

    /**
     *
     * @return number of doors of the car.
     */
    public short getNbOfDoors() {
        return nbOfDoors;
    }

    /**
     * nbOfDoors should be at least 1
     * @param nbOfDoors number of doors of the car.
     */
    public void setNbOfDoors(short nbOfDoors) {
        if (nbOfDoors >= 1)
            this.nbOfDoors = nbOfDoors;
        else
            throw new IllegalArgumentException("Number of doors should be at least 1.");
    }

    /**
     *
     * @return type of engine (Diesel, Electric, Gasoline) of the car.
     */
    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
}
