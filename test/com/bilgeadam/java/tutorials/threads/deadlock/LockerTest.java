package com.bilgeadam.java.tutorials.threads.deadlock;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LockerTest {
    private Lock one, two;
    private Locker first, second;
    private Thread t1, t2;

    @BeforeEach
    void setUp() {
        one = new Lock("1");
        two = new Lock("2");

        first = new Locker(one, two);
        second = new Locker(one, two);
    }

    @AfterEach
    void tearDown() {
        one = null;
        two = null;
        first = null;
        second = null;

    }

    @Test
    void DeadLockScenario() throws InterruptedException {
        t1 = new Thread(first.LockObject(one));
        t2 = new Thread(second.LockObject(two));

        t1.start();
        t2.start();

        // Set maximum limit otherwise it waits forever
        t1.join(1000);
        t2.join(1000);

        assertTrue(t1.isAlive());
        assertTrue(t2.isAlive());
    }

    @Test
    void NonDeadLockScenario() throws InterruptedException {
        t1 = new Thread(first.LockObject(one));
        t2 = new Thread(second.LockObject(one));

        t1.start();
        t2.start();

        // Set maximum limit otherwise it waits forever
        t1.join(1000);
        t2.join(1000);

        assertFalse(t1.isAlive());
        assertFalse(t2.isAlive());
    }
}