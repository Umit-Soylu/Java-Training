package com.bilgeadam.java.tutorials.enumeration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookStagesTest {
    String expectedOutput;

    @Test
    void testToString() {
        expectedOutput = "Reviewing of BookStages";
        assertEquals(expectedOutput, BookStages.Reviewing.toString());

        System.out.println(BookStages.Reviewing);
    }

    @Test
    void testCounter() {
        assertEquals(4, BookStages.numberOfElements());
    }

    @Test
    void customMethod() {
        assertEquals("Test", BookStages.Preparing.myCustomMethod());
    }
}