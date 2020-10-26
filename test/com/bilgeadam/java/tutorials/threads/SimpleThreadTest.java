package com.bilgeadam.java.tutorials.threads;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
    void mainRun(){
        SimpleThread t = new SimpleThread();
        t.run();
        //t.interrupt();
    }

    @Test
    void run()  {
        // Start each thread
        for (SimpleThread simpleThread : t) {
            simpleThread.start();
        }

        // Print current test method's thread
        System.out.println("This is " + Thread.currentThread().getName());

        // Join each Thread to Main thread using Stream parallel API
        Arrays.stream(t).parallel().forEach(e -> {
            try {
                e.join();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });
    }

    @Test
    void testInterruption(){
        // Start each thread
        for (SimpleThread simpleThread : t) {
            simpleThread.start();
        }

        // Intentionally Interrupt thread
        t[1].interrupt();

        // Print current test method's thread
        System.out.println("This is " + Thread.currentThread().getName());

    }

    @Test
    void testThreadPriorityAndCount(){
        // Start each thread with priority
        for (int i = 0; i < count; i++) {
            t[i].setPriority(i+1); // Higher the priority better.
            t[i].start();

        }

        // Print the priorities of threads
        for (SimpleThread tmp : t) {
            System.out.println("Name: " + tmp.getName() + " Priority: " + tmp.getPriority());
        }

        // Print number of threads that are active
        System.out.println("Active:" + Thread.activeCount());
    }
}