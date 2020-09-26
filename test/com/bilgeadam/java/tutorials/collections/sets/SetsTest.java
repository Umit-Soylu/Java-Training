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

    private void printInfo(){
        for (String s : testClass.getHashSet()) {
            System.out.println("Hash Set = " + s);
        }

        for (String s : testClass.getTreeSet()) {
            System.out.println("Tree Set = " + s);
        }

        testClass.printInfo();
    }

    @Test
    void convertArray() {
        String[] elements = new String[]{"Aaaa", "Baaa", "Abaa", "Aaaa"};

        for (String s : elements) {
            testClass.addElements(s);
        }

        Object[] testArray;
        testArray = testClass.convertArray();
        testArray.clone();
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
}