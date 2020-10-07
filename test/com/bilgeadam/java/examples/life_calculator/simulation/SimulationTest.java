package com.bilgeadam.java.examples.life_calculator.simulation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimulationTest {

    Simulation testClass;
    int length = 10, width = 10, nbOfEntities = 10;
    float foodRatio = 0.7f;

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

    @Test
    void testEndTurn() throws InterruptedException {
        int turnLimit = 5;
        while (turnLimit > 0){
            System.out.println("---- Current Turn:" + testClass.getTurn() + " ----");

            testClass.display();
            testClass.endTurn();
            Thread.sleep(1000);

            turnLimit--;
        }

    }
}