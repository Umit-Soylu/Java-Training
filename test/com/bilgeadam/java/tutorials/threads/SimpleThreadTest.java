package com.bilgeadam.java.tutorials.threads;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleThreadTest {
    private SimpleThread testMethod;

    @BeforeEach
    void setUp() {
        testMethod = new SimpleThread();
    }

    @AfterEach
    void tearDown() {
        testMethod = null;
    }

    @Test
    void run() {
        testMethod.run();
    }
}