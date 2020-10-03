package com.bilgeadam.java.examples.life_calculator.simulation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimulationTest {

    Simulation testClass;
    int length = 10, width = 10, nbOfEntities = 1;
    float foodRatio = 0.5f;

    @BeforeEach
    void setUp() {
        testClass = new Simulation(length, width, nbOfEntities, foodRatio);
    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    @Test
    void display() {
        testClass.display();
    }
}