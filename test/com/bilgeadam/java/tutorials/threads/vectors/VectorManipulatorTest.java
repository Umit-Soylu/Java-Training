package com.bilgeadam.java.tutorials.threads.vectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

class VectorManipulatorTest {
    private static int count = 15_000;

    Vector<Integer> target;

    VectorManipulator[] threads = new VectorManipulator[count];

    @BeforeEach
    void setUp() {
        target = new Vector<>();

        for (int i = 0; i < count; i++) {
            threads[i] = new VectorManipulator(target, "VT-" + i);
        }
    }

    @AfterEach
    void tearDown() {
        target = null;
        threads = null;
    }

    @Test
    void run() {
        Arrays.stream(threads).parallel().forEach(VectorManipulator::start);

        target.forEach(System.out::println);

        assertEquals(count * (VectorManipulator.addElementSize - VectorManipulator.removeElementSize), target.size());
    }

    @Test
    void threadPoolExecutor() throws InterruptedException {
        // This will allow me tme to run fixed size of threads per given time.
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

        // Stream the threads array and feed each run method to thread pool.
        Arrays.stream(threads).parallel().forEach(e -> threadPoolExecutor.execute(() -> e.run()));

        // Pool needs to be shutdown manually
        threadPoolExecutor.shutdown();
        threadPoolExecutor.awaitTermination(15, TimeUnit.SECONDS);

        assertEquals(count * (VectorManipulator.addElementSize - VectorManipulator.removeElementSize), target.size());
    }
}