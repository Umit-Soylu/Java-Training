package com.bilgeadam.java.examples.recursive;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecursiveImplementationsTest {
    RecursiveImplementations testClass;

    @BeforeEach
    void setUp() {
        testClass = new RecursiveImplementations();
    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    @Test
    void testMethods() {
        assertEquals(5, testClass.methodA());
    }

    @Test
    void testFactorial() {
        assertEquals(6, testClass.factorial(3));
    }
}