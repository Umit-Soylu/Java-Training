package com.bilgeadam.java.tutorials.collections.queues;

import java.util.*;

public class Queues {
    private final Queue<String> stringQueue;
    private final Queue<String> stringDeque;
    private final Stack<String> stringStack;

    public Queues() {
        stringQueue = new PriorityQueue<>();
        stringDeque = new ArrayDeque<>();
        stringStack = new Stack<>();
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
     * Add elements but not throws exception if capacity is not enough
     * @param element new element to be added
     */
    public void pushElement(String element) {
        stringQueue.offer(element);
        stringDeque.offer(element);
        stringStack.push(element); // stringStack.addElement(element);
    }


    public void printElements(){
        System.out.println("stringQueue");
        // Iterate via iterator
        for (Iterator<String> it = stringQueue.iterator(); it.hasNext(); ) {
            String s = it.next();
            System.out.println("element = " + s);
        }

        System.out.println("stringDeque");
        // Iterate via for each
        for (String s : stringDeque) {
            System.out.println("element = " + s);
        }

        System.out.println("stringStack");
        // Iterate via for loop
        for (int i = 0; i < stringStack.size(); i++) {
            System.out.println("element = " + stringStack.elementAt(i));
        }
    }

    public void removeElements(){
        System.out.println("stringQueue");
        while(!stringQueue.isEmpty())
            System.out.println("stringQueue = " + stringQueue.remove());

        System.out.println("stringDeque");
        while(!stringDeque.isEmpty())
            System.out.println("stringDeque = " + stringDeque.remove());

        System.out.println("stringStack");
        while(!stringStack.isEmpty())
            System.out.println("stringStack = " + stringStack.pop());
    }
}
