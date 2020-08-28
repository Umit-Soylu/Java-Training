package com.bilgeadam.java.tutorials.oop.inheritance;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {
    // The car object.
    Car testCar;

    @BeforeEach
    void setUp() {
        testCar = new Car(chassisNo, environment, nbOfPassengers, nbOfDoors, engineType);
    }

    @AfterEach
    void tearDown() {
        testCar = null;
    }

    // The input parameters for car object.
    String chassisNo = "JAVA-TUTORIAL-0001-CAR", environment = "Air",  engineType= "Diesel";
    short nbOfPassengers = 1, nbOfDoors = 1;

    /**
     * Test inherited methods from car object.
     * These methods resides in vehicle object.
     */
    @Test
    void testInheritedMethods() {
        assertEquals(chassisNo, testCar.getChassisNo());
        assertEquals(environment, testCar.getEnvironment());
    }

    /**
     * Test car specific methods using car object.
     * These methods resides in car object.
     */
    @Test
    void testCarSpecificMethods() {
        assertEquals(nbOfDoors, testCar.getNbOfDoors());
        assertEquals(nbOfPassengers, testCar.getNbOfPassengers());
        assertEquals(engineType, testCar.getEngineType());
    }
}