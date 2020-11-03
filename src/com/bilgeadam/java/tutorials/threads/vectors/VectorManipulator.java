package com.bilgeadam.java.tutorials.threads.vectors;

import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class will add random 5 integers to  a vector and removes random 2 elements
 */
public class VectorManipulator extends Thread{

    // This is the group for my VectorManipulator class
    private static final ThreadGroup group = new ThreadGroup("VectorManipulationGroup");

    private final Vector<Integer> integers;

    // Numbers need for the behaviour of run method
    protected static final int addElementSize = 5, removeElementSize = 3;

    /**
     * Constructor for Vector Manipulator class
     * @param target Vector to be modified
     * @param name   Name of the thread
     */
    public VectorManipulator(Vector<Integer> target, String name) {
        // Construct thread using static group anf given name
        super(group, name);

        // Store the reference for vector.
        integers = target;
    }

    /**
     * This method will add {@link #addElementSize} elements and removes {@link #removeElementSize} later on
     */
    @Override
    public void run() {
        for (int i = 0; i < addElementSize; i++) {
            integers.add(ThreadLocalRandom.current().nextInt(10, 45));
        }
        System.out.println(Thread.currentThread().getName() + " after elements added.");
        //integers.forEach(System.out::println);

        for (int i = 0; i < removeElementSize && !integers.isEmpty(); i++) {
            integers.remove(i);
        }

        System.out.println(Thread.currentThread().getName() + " after elements removed.");
        //integers.forEach(System.out::println);
    }
}
