package com.bilgeadam.java.tutorials.oop.inheritance;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PorscheTest {

    Porsche testPorsche;

    // The input parameters for car object.
    String chassisNo = "JAVA-TUTORIAL-0001-CAR", environment = "Air",  engineType= "Diesel", customer = "Umit Soylu";
    short nbOfPassengers = 1, nbOfDoors = 1;
    
    @BeforeEach
    void setUp() throws Exception {
        testPorsche = new Porsche(customer, chassisNo, environment, nbOfPassengers, nbOfDoors, engineType);
    }

    @AfterEach
    void tearDown() {
        testPorsche = null;
    }

    /**
     * Test methods inherited from Vehicle
     */
    @Test
    void testMultiLevelInheritedMethods() {
        assertEquals(chassisNo, testPorsche.getChassisNo());
        assertEquals(environment, testPorsche.getEnvironment());
    }

    /**
     * Test methods inherited from Car
     */
    @Test
    void testInheritedMethods() {
        assertEquals(nbOfDoors, testPorsche.getNbOfDoors());
        assertEquals(nbOfPassengers, testPorsche.getNbOfPassengers());
        assertEquals(engineType, testPorsche.getEngineType());
    }

    /**
     * Test method specific to Porsche class.
     */
    @Test
    void ownMethods() {
        assertEquals(customer, testPorsche.getOwner());
    }
}