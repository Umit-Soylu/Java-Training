package com.bilgeadam.java.tutorials.threads;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleRunnableTest {
    private SimpleRunnable testMethod;

    @BeforeEach
    void setUp() {
        testMethod = new SimpleRunnable();
    }

    @AfterEach
    void tearDown() {
        testMethod = null;
    }

    @Test
    void run() {
        testMethod.run();

        System.out.println(testMethod.getBirth());
    }

    @Test
    void multiThread() throws InterruptedException {
        System.out.println("Here is " + Thread.currentThread().getName());

        // Create a new thread to run test method
        Thread t1 = new Thread(testMethod);
        t1.start();

        t1.join();

        Thread t2 = new Thread(testMethod);
        t2.start();
        t2.join();

        // Print the birthday from here
        testMethod.run();
    }
}