package com.bilgeadam.java.examples.life_calculator.statistics;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class DataStoreTest {
    DataStore testClass;

    @BeforeEach
    void setUp() {
        testClass = new DataStore();
    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    @Test
    void addChildren() {
        testClass.addChildren(3, 3);
        System.out.println(testClass.toString());
    }

    @Test
    void diedCreatures() {
        testClass.diedCreatures(3, 5);
        System.out.println(testClass);
    }

    @Test
    void printStatistics() throws IOException {
        //testClass.addChildren(1, 2);
        System.out.println(testClass);

        testClass.printStatistics();
    }
}