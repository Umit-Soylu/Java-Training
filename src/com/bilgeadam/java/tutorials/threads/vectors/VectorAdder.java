package com.bilgeadam.java.tutorials.threads.vectors;

import java.util.concurrent.ThreadLocalRandom;

public class VectorAdder implements Runnable{
    private final SharedVector vector;
    private final int elementCount;
    /**
     * Constructor
     * @param vector Vector class to interact
     */
    public VectorAdder(SharedVector vector, int count) {
        this.vector = vector;
        this.elementCount = Math.max(count, 0);
    }

    @Override
    public void run() {
        int addedElementCount = 0, tmpElement;
        while (addedElementCount < elementCount) {
            tmpElement = ThreadLocalRandom.current().nextInt(100, 5_000_000);

            System.out.println(Thread.currentThread().getName() + " is adding: " + tmpElement);

            vector.addToVector(tmpElement);
            addedElementCount++;

            // Sleep pseudorandom time if not interrupted
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(250, 1000));
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt(); // Interrupt yourself and resume working
            }
        }
    }
}
