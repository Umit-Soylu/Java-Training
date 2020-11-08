package com.bilgeadam.java.tutorials.threads.barrier;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkTest {
    private Work testClass;

    @BeforeEach
    void setUp() {
        int workerCount = 7;
        int limit = 8;
        testClass = new Work(workerCount, limit);
    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    @Test
    void startWork() {
        testClass.startWork();
    }
}