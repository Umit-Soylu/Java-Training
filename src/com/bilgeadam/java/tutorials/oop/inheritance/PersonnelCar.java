package com.bilgeadam.java.tutorials.oop.inheritance;

/**
 * Personnel Cars belongs to a person.
 */
public class PersonnelCar extends Car{

    private String owner;

    /**
     * A Personnel Car object generated from Car
     *
     * @param owner          name of the owner of the Personnel Car.
     * @param chassisNo      chassis of the car acquired from Vehicle class.
     * @param environment    environment of the car (sea, air, etc.) acquired from Vehicle class.
     * @param nbOfPassengers number of passengers for the car.
     * @param nbOfDoors      number of doors of the car.
     * @param engineType     type of engine (Diesel, Electric, Gasoline) of the car.
     */
    public PersonnelCar(String owner, String chassisNo, String environment, short nbOfPassengers, short nbOfDoors, String engineType) {
        super(chassisNo, environment, nbOfPassengers, nbOfDoors, engineType);

        setOwner(owner);
    }


    /**
     * Checks the owner
     * @param owner name of the owner
     */
    private void setOwner(String owner) {
        // TODO: Verify the owner is valid.

        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }
}
