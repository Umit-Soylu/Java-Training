package com.bilgeadam.java.examples.life_calculator.simulation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimulationTest {

    Simulation testClass;
    int length = 4, width = 4, nbOfEntities = 10;
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
    void testDisplay() {
        testClass.display();
    }

    @Test
    void testEndTurn() throws InterruptedException {
        int turnLimit = 50;
        while (turnLimit > 0){
            System.out.println("---- Current Turn:" + testClass.getTurn() + " ----");

            testClass.display();
            testClass.endTurn();
            Thread.sleep(10);

            turnLimit--;
        }

        System.out.println(testClass.getStatistics());
    }
    
    @Test
    public void test(){
        testClass.display();

        System.out.println(testClass.getStatistics());
    }

}