package com.bilgeadam.java.tutorials.oop.inheritance;


/**
 *  This class uses Car properties and only implements methods specific to Commercial Car type.
 *  Commercial Car 'is a' Car.
 *  Car 'is a' Vehicle.
 */
public class CommercialCar extends Car {

    // Each commercial car should have a related company.
    private String company;

    /**
     * A Commercial Car object generated from Car
     *
     * @param company        name of the company
     * @param chassisNo      chassis of the car acquired from Vehicle class.
     * @param environment    environment of the car (sea, air, etc.) acquired from Vehicle class.
     * @param nbOfPassengers number of passengers for the car.
     * @param nbOfDoors      number of doors of the car.
     * @param engineType     type of engine (Diesel, Electric, Gasoline) of the car.
     */
    public CommercialCar(String company, String chassisNo, String environment, short nbOfPassengers, short nbOfDoors, String engineType) {
        super(chassisNo, environment, nbOfPassengers, nbOfDoors, engineType);

        setCompany(company);
    }

    /**
     * This method verifies the company
     * @param company Name of the company
     */
    private void setCompany(String company) {
        // TODO: Check the company is valid.
        this.company = company;
    }

    public String getCompany() {
        return company;
    }
}
