package com.bilgeadam.java.tutorials.collections.arrays_lists;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

class ArraysAndListsTest {
    private ArraysAndLists testClass;
    private final int arraySize = 10;

    @BeforeEach
    void setUp() {
        testClass = new ArraysAndLists(arraySize);
    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    @Test
    void measureAddElement() {
        Date startTime, endTime;
        long counter = 10_000_000;

        // Test for arrays
        startTime = new Date();
        for (int i = 0; i < counter; i++) {
            testClass.addArrayElement(i % Integer.MAX_VALUE, i % arraySize);
        }
        endTime = new Date();
        System.out.println("Array time cost = " + (endTime.getTime() - startTime.getTime()) + " milliseconds.");

        // Test for linkedList
        startTime = new Date();
        for (int i = 0; i < counter; i++) {
            testClass.addLinkedListElement(i % Integer.MAX_VALUE);
        }
        endTime = new Date();
        System.out.println("LinkedList time cost = " + (endTime.getTime() - startTime.getTime()) + " milliseconds.");

        // Test for ArrayList
        startTime = new Date();
        for (int i = 0; i < counter; i++) {
            testClass.addArrayListElement(i % Integer.MAX_VALUE);
        }
        endTime = new Date();
        System.out.println("ArrayList time cost = " + (endTime.getTime() - startTime.getTime()) + " milliseconds.");
    }

    @Test
    void dummyTest(){
        for (int i = 0; i < 5; i++) {
            testClass.addArrayListElement(i);
        }

        testClass.removeArrayList(3);

        for (Integer i : testClass.getArrayList()) {
            System.out.println("i = " + i);
        }
    }

    @Test
    void testRemoveElements(){
        Date startTime, endTime;

        int counter = 100_000;

        Integer[] listElements = new Integer[counter],
                searchElements = new Integer[counter];

        // Create random element list
        for (int i = 0; i < counter; i++)
            listElements[i] = (int) (Math.random() * Integer.MAX_VALUE);

        // Add all element of the random list both ArrayList & LinkedList
        for (int i = 0; i < counter; i++) {
            testClass.addArrayListElement(listElements[i]);
            testClass.addLinkedListElement(listElements[i]);
        }

        // Create random search element list to be removed
        for (int i = 0; i < counter; i++)
            searchElements[i] = (int) (Math.random() * Integer.MAX_VALUE);

        // Test for ArrayList
        startTime = new Date();
        for (int i = 0; i < counter; i++) {
            testClass.removeArrayList(searchElements[i]);
        }
        endTime = new Date();
        System.out.println("ArrayList time cost = " + (endTime.getTime() - startTime.getTime()) + " milliseconds.");

        // Test for LinkedList
        startTime = new Date();
        for (int i = 0; i < counter; i++) {
            testClass.removeLinkList(searchElements[i]);
        }
        endTime = new Date();
        System.out.println("LinkedList time cost = " + (endTime.getTime() - startTime.getTime()) + " milliseconds.");
    }


    @Test
    void testRemoveIndex(){
        Date startTime, endTime;

        int counter = 100_000;

        Integer[] listElements = new Integer[counter];

        // Create random element list
        for (int i = 0; i < counter; i++)
            listElements[i] = (int) (Math.random() * Integer.MAX_VALUE);

        for (int i = 0; i < counter; i++) {
            testClass.addArrayListElement(listElements[i]);
            testClass.addLinkedListElement(listElements[i]);
        }


        // Test for ArrayList
        startTime = new Date();
        for (int i = counter/2; i >= 0; i--) {
            testClass.removeArrayListIndex(i);
        }
        endTime = new Date();
        System.out.println("ArrayList time cost = " + (endTime.getTime() - startTime.getTime()) + " milliseconds.");

        // Test for LinkedList
        startTime = new Date();
        for (int i = counter/2; i >= 0; i--) {
            testClass.removeLinkListIndex(i);
        }
        endTime = new Date();
        System.out.println("LinkedList time cost = " + (endTime.getTime() - startTime.getTime()) + " milliseconds.");
    }
}