package com.bilgeadam.java.tutorials.collections.sets;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SetsTest {
    Sets testClass;

    @BeforeEach
    void setUp() {
        testClass = new Sets();
    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    @Test
    void addElements() {
        String[] elements = new String[]{"Aaaa", "Baaa", "Abaa", "Aaaa"};

        for (String s : elements) {
            testClass.addElements(s);
        }

        printInfo();
    }

    @Test
    void removeElements() {
        String[] elements = new String[]{"Aaaa", "Baaa", "Abaa", "Aaaa"};

        for (String s : elements) {
            testClass.addElements(s);
        }

        testClass.removeElements("123");

        printInfo();
    }

    @Test
    void convertArray() {
        String[] elements = new String[]{"Aaaa", "Baaa", "Abaa", "Aaaa"};

        for (String s : elements) {
            testClass.addElements(s);
        }

        Object[] testArray = testClass.convertArray();
        testArray.clone(); // An array class only has length & clone 
        System.out.println("Array class with length = " + testArray.length);
    }

    @Test
    void findIntersection() {
        String[] elements = new String[]{"Zzzaaa", "Aaaa", "Baaa", "Abaa"};
        String[] collections = new String[]{"DDDD", "Baaa", "Zzzaaa", "FFf"};

        for (String s : elements) {
            testClass.addElements(s);
        }

        testClass.findIntersection(Arrays.asList(collections));

        printInfo();
    }

    /**
     * Following method prints all values of both lists.
     */
    private void printInfo(){
        System.out.println("Hash Set Elements");
        for (String s : testClass.getHashSet()) {
            System.out.println(s);
        }

        System.out.println("Tree Set Elements");
        for (String s : testClass.getTreeSet()) {
            System.out.println(s);
        }

        testClass.printInfo();
    }
}