package com.bilgeadam.java.tutorials.enumeration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookStagesTest {
    String expectedOutput;

    /**
     * The string output of the ENUM value is Override and tested.
     */
    @Test
    void testToString() {
        expectedOutput = "Reviewing of BookStages";
        assertEquals(expectedOutput, BookStages.Reviewing.toString());

        System.out.println(BookStages.Reviewing);
    }

    /**
     * Here the ENUM class' method is tested.
     */
    @Test
    void testCounter() {
        assertEquals(4, BookStages.numberOfElements());
    }

    /**
     * Here a custom method belongs to each ENUM value is tested
     */
    @Test
    void customMethod() {
        assertEquals("Test", BookStages.Preparing.myCustomMethod());
    }
}