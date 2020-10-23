package com.bilgeadam.java.tutorials.threads;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AdvancedThreadTest {
    private static final ThreadGroup group = new ThreadGroup("Test");
    private static final int size = 5;

    AdvancedThread[] testClasses = new AdvancedThread[size];

    @BeforeEach
    void setUp() {
        for (int i = 0; i < size; i++) {
            testClasses[i] = new AdvancedThread(group, "T-" + i);
        }
    }

    @AfterEach
    void tearDown() {
        testClasses = null;
    }

    @Test
    void run() {
        for (AdvancedThread tmp : testClasses) {
            tmp.start();
        }

        assertEquals(size, group.activeCount());
        System.out.println("Size of Thread Group '" + group.getName() + "' is " + group.activeCount());
    }

    @Test
    void accessRights(){
        // Create a new Thread group with a thread
        ThreadGroup group2 = new ThreadGroup(group, "children");
        AdvancedThread t2 = new AdvancedThread(group2, "child");

        // Check thread groups access rights
        assertTrue(Thread.currentThread().getThreadGroup().parentOf(group));
        assertTrue(group.parentOf(t2.getThreadGroup()));
    }
}