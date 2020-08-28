package com.bilgeadam.java.tutorials.oop.inheritance;



public class Vehicle {

    // Number of Tires
    private int numberOfTires;

    // Chassis of the vehicle
    private final String chassisNo;

    // Id of vehicle: plate, tail no, etc.
    protected String id;

    // Ex: Land, Sea, Air, Space
    private String environment;

    /**
     * A constructor with no argument.
     */
    public Vehicle() {
        this.chassisNo = "Demo";
    }

    /**
     * A parametrized constructor.
     * @param chassisNo chassis of vehicle
     * @param environment environment of vehicle (sea, air, etc.)
     */
    public Vehicle(String chassisNo, String environment) {
        this.chassisNo = chassisNo;
        this.environment = environment;
    }

    /**
     * @return number of tires of the vehicle
     */
    public int getNumberOfTires() {
        return numberOfTires;
    }

    /**
     * Sets the number of tires
     * @param numberOfTires the tire count of the vehicle
     */
    public void setNumberOfTires(int numberOfTires) {
        this.numberOfTires = numberOfTires;
    }

    /**
     * Id of vehicle: plate, tail no, etc.
     * @return the id of the vehicle based on type.
     */
    public String getId() {
        return id;
    }

    /**
     * Id of vehicle: plate, tail no, etc.
     * @param id the id of the vehicle based on type.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Ex: Land, Sea, Air, Space
     * @return the environment type
     */
    public String getEnvironment() {
        return environment;
    }

    /**
     * Ex: Land, Sea, Air, Space
     * @param environment sets the environment of vehicle
     */
    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    /**
     *
     * @return chassis no of vehicle
     */
    public String getChassisNo() {
        return chassisNo;
    }
}
