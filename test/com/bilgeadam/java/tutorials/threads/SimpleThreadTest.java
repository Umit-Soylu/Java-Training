package com.bilgeadam.java.tutorials.threads;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleThreadTest {
    // Number of threads to create
    private final static int count = 10;

    // Create array of threads to keep their references
    SimpleThread[] t = new SimpleThread[count];

    @BeforeEach
    void setUp() {
        // Create multiple threads
        for (int i = 0; i < count; i++) {
            t[i] = new SimpleThread();
        }
    }

    @AfterEach
    void tearDown() {
        t = null;
    }

    @Test
    void run() {
        // Start each thread
        for (SimpleThread simpleThread : t) {
            simpleThread.start();
        }

        // Print current test method's thread
        System.out.println("This is " + Thread.currentThread().getName());
    }

    @Test
    void testInterruption(){
        // Start each thread
        for (SimpleThread simpleThread : t) {
            simpleThread.start();
        }

        // Intentionally Interrupt thread
        t[1].interrupt();
    }

    @Test
    void testThreadPriorityAndCount(){
        // Start each thread with priority
        for (int i = 0; i < count; i++) {
            t[i].start();
            t[i].setPriority(i+1); // Higher the priority better.
        }

        // Print the priorities of threads
        for (SimpleThread tmp : t) {
            System.out.println("Name: " + tmp.getName() + " Priority: " + tmp.getPriority());
        }

        // Print number of threads that are active
        System.out.println("Active:" + Thread.activeCount());
    }
}