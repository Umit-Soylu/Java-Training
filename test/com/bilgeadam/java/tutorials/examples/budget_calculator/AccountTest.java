package com.bilgeadam.java.tutorials.examples.budget_calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountTest {
    Account testClass;
    
    @BeforeEach
    void setUp() {
        testClass = new Account();
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

        assertTrue(t.isAlive());
    }

    @Test
    void customers() throws InterruptedException {
        Thread child = new Thread(()->testClass.withdraw(5000), "Child"),
                parent = new Thread(()-> testClass.deposit(7500), "Parent");

        child.start();
        parent.start();

        child.join();
        parent.join();
    }
}