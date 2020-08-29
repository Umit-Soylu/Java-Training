package com.bilgeadam.java.tutorials.exceptions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExceptionTest {

    Exception myExc;

    // This class will be called before each @Test
    @BeforeEach
    void setUp() {
        myExc = new Exception();
    }

    // This class will be called after each @Test
    @AfterEach
    void tearDown() {
        myExc = null;
    }


    @Test
    void division1() {
        assertEquals(Double.POSITIVE_INFINITY, myExc.division(2, 0));
    }

    @Test
    void division2() {
        assertEquals(Double.NEGATIVE_INFINITY, myExc.division(-2, 0));
    }

    @Test
    void division3() {
        assertEquals(Double.NaN, myExc.division(0, 0));
    }

    @Test
    void addition1() {
        assertEquals(5, myExc.addition(2, 3));
    }

    @Test
    void addition2() {
        assertEquals(Integer.MAX_VALUE, myExc.addition(Integer.MAX_VALUE, 3));
    }

    @Test
    void addition3() {
        assertEquals(Integer.MIN_VALUE, myExc.addition(Integer.MIN_VALUE + 2, -3));
    }

    @Test
    void finallyExample() {
        // This method will not return 1 because finally block executes always as last.
        assertEquals(0, myExc.finallyExample());
    }
}