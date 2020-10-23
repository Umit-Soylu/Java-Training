package com.bilgeadam.java.tutorials.threads.vectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SharedVectorTest {
    private SharedVector testClass;
    private final int maxElementCount = 3;

    @BeforeEach
    void setUp() {
        testClass = new SharedVector();
    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    @Test
    void SingleThread() throws InterruptedException {
        Thread thread = new Thread(new VectorAdder(testClass, maxElementCount));

        thread.start();

        thread.join();

        testClass.printVector();
    }

    @Test
    void ExecutorService() throws InterruptedException {
        ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        int nbOfAdders = 8;

        for (int i = 0; i < nbOfAdders; i++)
            poolExecutor.execute(new VectorAdder(testClass, maxElementCount));

        poolExecutor.shutdown();
        poolExecutor.awaitTermination(15, TimeUnit.SECONDS);

        // testClass.printVector();

        assertEquals(nbOfAdders * maxElementCount, testClass.getVectorSize());
    }
}