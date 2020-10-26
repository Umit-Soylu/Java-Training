package com.bilgeadam.java.tutorials.examples.budget_calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class SharedAccountTest {
    private final int depositorCount = 3;
    private final int withdrawerCount = 4;

    SharedAccount testClass;

    Thread[] depositors = new Thread[depositorCount];
    Thread[] withdrawers = new Thread[withdrawerCount];

    @BeforeEach
    void setUp() {
        testClass = new SharedAccount();
    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    @Test
    void deposit() {
        testClass.deposit(100);
        System.out.println(testClass.getBalance());
    }


    @Test
    void withdraw() {
        testClass.withdraw(100);
        System.out.println(testClass.getBalance());

        testClass.deposit(400);
        testClass.withdraw(50);
        System.out.println(testClass.getBalance());
    }

    @Test
    void multiDepositors() throws InterruptedException {
        Thread t3 = new Thread(() -> testClass.withdraw(15));
        t3.start();

        Thread t1 = new Thread(() -> testClass.deposit(34));
        t1.start();

        Thread t2 = new Thread(() -> testClass.deposit(45));
        t2.start();


        t3.join();
        t1.join();
        t2.join();
        System.out.println(testClass.getBalance());

    }
}