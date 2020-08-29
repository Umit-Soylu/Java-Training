package com.bilgeadam.java.tutorials.oop.inheritance;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonnelCarTest {

    // Declare Commercial Car.
    PersonnelCar testCar;

    // The input parameters for car object.
    String chassisNo = "JAVA-TUTORIAL-0001-CommercialCar", environment = "Air",  engineType= "Diesel", owner = "Umit Soylu";
    short nbOfPassengers = 1, nbOfDoors = 1;

    @BeforeEach
    void setUp() {
        testCar = new PersonnelCar(owner, chassisNo, environment, nbOfPassengers, nbOfDoors, engineType);
    }

    @AfterEach
    void tearDown() {
        testCar = null;
    }

    /**
     * Test multi level inherited methods from Personnel Car object.
     * These methods resides in vehicle object.
     */
    @Test
    void testMultiLevelInheritedMethods() {
        assertEquals(chassisNo, testCar.getChassisNo());
        assertEquals(environment, testCar.getEnvironment());
    }

    /**
     * Test inherited methods using Personnel Car object.
     * These methods resides in car object.
     */
    @Test
    void testInheritedMethods() {
        assertEquals(nbOfDoors, testCar.getNbOfDoors());
        assertEquals(nbOfPassengers, testCar.getNbOfPassengers());
        assertEquals(engineType, testCar.getEngineType());
    }

    /**
     * Test Personnel Car specific methods
     * These methods resides in Personnel Car object.
     */
    @Test
    void testPersonnelCarMethods() {
        assertEquals(owner, testCar.getOwner());
    }
}