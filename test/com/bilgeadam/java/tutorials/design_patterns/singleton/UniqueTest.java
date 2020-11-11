package com.bilgeadam.java.tutorials.design_patterns.singleton;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UniqueTest {
    private Unique[] testClasses;

    private Thread[] testThreads;

    @BeforeEach
    void setUp() {
        testClasses = new Unique[10];
        testThreads = new Thread[10];
    }

    @AfterEach
    void tearDown() {
        testClasses = null;
        testThreads = null;
    }

    @Test
    void getName() {
        Unique testClass = Unique.getInstance();
        Unique testClass2 = Unique.getInstance();

        System.out.println(testClass.getName());
        System.out.println(testClass2.getName());
    }

    @Test
    void getNames() {
        for (int i = 0; i < 10; i++) {
            testClasses[i] = Unique.getInstance();
        }
        Arrays.stream(testClasses).forEach(e -> System.out.println(e.getName()));
    }

    @Test
    void multiThreads(){
        Arrays.stream(testThreads).parallel().forEach(e -> {
            e = new Thread(Unique::getInstance);
            e.start();
            System.out.println(Unique.getInstance().getName());
        });
    }
}