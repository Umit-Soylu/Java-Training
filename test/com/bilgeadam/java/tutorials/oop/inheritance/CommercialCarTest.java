package com.bilgeadam.java.tutorials.oop.inheritance;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommercialCarTest {

    // Declare Commercial Car.
    CommercialCar testCar;

    // The input parameters for car object.
    String chassisNo = "JAVA-TUTORIAL-0001-CommercialCar", environment = "Air",  engineType= "Diesel", company = "BilgeAdam";
    short nbOfPassengers = 1, nbOfDoors = 1;


    @BeforeEach
    void setUp() {
        testCar = new CommercialCar(company, chassisNo, environment, nbOfPassengers, nbOfDoors, engineType);
    }

    @AfterEach
    void tearDown() {
        testCar = null;
    }

    /**
     * Test multi level inherited methods from Commercial Car object.
     * These methods resides in vehicle object.
     */
    @Test
    void testMultiLevelInheritedMethods() {
        assertEquals(chassisNo, testCar.getChassisNo());
        assertEquals(environment, testCar.getEnvironment());
    }

    /**
     * Test inherited methods using Commercial Car object.
     * These methods resides in car object.
     */
    @Test
    void testInheritedMethods() {
        assertEquals(nbOfDoors, testCar.getNbOfDoors());
        assertEquals(nbOfPassengers, testCar.getNbOfPassengers());
        assertEquals(engineType, testCar.getEngineType());
    }

    /**
     * Test Commercial Car specific methods
     * These methods resides in Commercial Car object.
     */
    @Test
    void testCommercialCarMethods() {
        assertEquals(company, testCar.getCompany());
    }
}