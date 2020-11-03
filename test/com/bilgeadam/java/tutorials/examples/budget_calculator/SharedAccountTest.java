package com.bilgeadam.java.tutorials.examples.budget_calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SharedAccountTest {
    SharedAccount testClass;
    
    @BeforeEach
    void setUp() {
        testClass = new SharedAccount();
    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    @Test
    void getBalance() {
        System.out.println("testClass.getBalance() = " + testClass.getBalance());
    }

    @Test
    void deposit(){
        int value = 5;
        testClass.deposit(value);

        assertEquals(value + "TRY" , testClass.getBalance());
    }

    @Test
    void withdraw() throws InterruptedException {
        int value = 2;
        Thread t = new Thread(()-> testClass.withdraw(value));

        t.start();
        t.join(5);

        // See that main thread dies even if other threads are still active.
        assertTrue(t.isAlive());
    }

    @Test
    void customers() throws InterruptedException {
        Thread child = new Thread(()->testClass.withdraw(5000), "Child"),
                parent1 = new Thread(()-> testClass.deposit(2500), "Mother"),
                parent2 = new Thread(()-> testClass.deposit(3500), "Father");

        child.start();
        parent1.start();
        parent2.start();

        // Verify that child waits till there is enough money
        child.join();
        parent1.join();
        parent2.join();
    }
}