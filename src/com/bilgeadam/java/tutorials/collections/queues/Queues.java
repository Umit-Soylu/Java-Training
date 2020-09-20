package com.bilgeadam.java.tutorials.collections.queues;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Stack;

public class Queues {
    private final PriorityQueue<String> stringQueue;
    private final ArrayDeque<String> stringDeque;
    private final Stack<String> stringStack;

    /**
     * Create 3 different buckets
     * <p>PriorityQueue</p>
     * <p>ArrayDeque</p>
     * <p>Stack</p>
     */
    public Queues() {
        stringQueue = new PriorityQueue<>(); // Creates with initial capacity of 11, elements are ordered
        stringDeque = new ArrayDeque<>();    // Creates with initial capacity of 16, elements are stored in FIFO
        stringStack = new Stack<>();         // Creates with initial capacity of 0, elements are stored in FILO
    }

    /**
     * Add elements or throws exception if capacity is not enough
     * @param element new element to be added
     */
    public void addElement(String element) {
        stringQueue.add(element);
        stringDeque.add(element);
        stringStack.add(element);
    }


    /**
     * Add elements but <b>not</b> throws exception if capacity is not enough
     * @param element new element to be added
     */
    public void pushElement(String element) {
        stringQueue.offer(element);
        stringDeque.offer(element);
        stringStack.push(element); // stringStack.addElement(element);
    }


    /**
     * This method uses iterator to iterate thorough all of its elements.
     * Iterator does not guarantees that elements are traversed in proper manner.
     */
    public void printElements(){
        System.out.println("Queue iteration");
        // Iterate via iterator
        for (Iterator<String> it = stringQueue.iterator(); it.hasNext(); ) {
            String s = it.next();
            System.out.println("Element = " + s);
        }

        System.out.println("Deque iteration");
        // Iterate via for each
        for (String s : stringDeque) {
            System.out.println("Element = " + s);
        }

        System.out.println("Stack iteration");
        // Iterate via for loop
        for (int i = 0; i < stringStack.size(); i++) {
            System.out.println("Element = " + stringStack.elementAt(i));
        }
    }

    /**
     * This method removes elements and prints them
     * Removing elements from a bucket is achieved according to bucket type.
     */
    public void removeElements(){
        System.out.println("Queue Elements");
        while(!stringQueue.isEmpty())
            System.out.println("Element = " + stringQueue.remove());

        System.out.println("Deque Elements");
        while(!stringDeque.isEmpty())
            System.out.println("Element = " + stringDeque.remove());

        System.out.println("Stack Elements");
        while(!stringStack.isEmpty())
            System.out.println("Element = " + stringStack.pop());
    }
}
