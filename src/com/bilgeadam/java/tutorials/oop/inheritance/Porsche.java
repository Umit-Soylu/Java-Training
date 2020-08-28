package com.bilgeadam.java.tutorials.oop.inheritance;

// This class extends car object which extends Vehicle object
public class Porsche extends Car{

    String owner;

    /**
     * A Porsche object generated from car.
     * A porsche car owner should have a background check and verified before owning the car.
     * @param customerName   the name of the customer
     * @param chassisNo      chassis of the car acquired from Vehicle class.
     * @param environment    environment of the car (sea, air, etc.) acquired from Vehicle class.
     * @param nbOfPassengers number of passengers for the car.
     * @param nbOfDoors      number of doors of the car.
     * @param engineType     type of engine (Diesel, Electric, Gasoline) of the car.
     */
    public Porsche(String customerName, String chassisNo, String environment, short nbOfPassengers, short nbOfDoors, String engineType) throws Exception {
        // Super classes constructor should be invoked as first argument
        super(chassisNo, environment, nbOfPassengers, nbOfDoors, engineType);

        // Check whether or not given customer can own a porsche
        if (checkCustomer(customerName))
            this.owner = customerName;
        else
            throw new Exception("Customer cannot own this car");
    }

    /**
     * This is a demo purpose only class.
     * @param customerName Only 'Umit Soylu' is accepted
     * @return result for accepting / rejecting Porsche owning request.
     */
    private boolean checkCustomer(String customerName) {
        return customerName.equalsIgnoreCase("Umit Soylu");
    }

    public String getOwner() {
        return owner;
    }
}
