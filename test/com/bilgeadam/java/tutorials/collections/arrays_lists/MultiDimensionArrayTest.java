package com.bilgeadam.java.tutorials.collections.arrays_lists;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MultiDimensionArrayTest {
    private MultiDimensionArray testClass;
    private final int dimOne = 2;
    private final int dimTwo = 3;
    private final int dimThree = 4;

    @BeforeEach
    void setUp() {
        testClass = new MultiDimensionArray(dimOne, dimTwo, dimThree);
    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    @Test
    void printMatrix(){
        testClass.insertElement(0,2,3,'A');
        testClass.insertElement(1,0,3,'B');
        testClass.insertElement(1,1,1,'C');
        testClass.insertElement(0,2,2,'D');
        testClass.insertElement(1,1,0,'E');

        System.out.println("testClass.getCharArray() = " + testClass);
    }
}