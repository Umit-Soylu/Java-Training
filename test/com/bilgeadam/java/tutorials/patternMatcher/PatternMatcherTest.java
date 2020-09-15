package com.bilgeadam.java.tutorials.patternMatcher;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PatternMatcherTest {
    PatternMatcher testPatternMatcher;

    @BeforeEach
    void setUp() {
        testPatternMatcher = new PatternMatcher();
    }

    @AfterEach
    void tearDown() {
        testPatternMatcher = null;
    }

    @Test
    void testKeyValueDivider() {
        String input = "   Student  :   Umit    ";
        testPatternMatcher.keyValueDivider(input);

        assertEquals("Student", testPatternMatcher.getKey());
        assertEquals("Umit", testPatternMatcher.getValue());
    }

    @Test
    void testKeyValueRegex() {
        String input = "   Student  :   Umit   asd ";
        testPatternMatcher.keyValueRegex(input);

        assertEquals("Student", testPatternMatcher.getResults().get(0));
        assertEquals("Umit", testPatternMatcher.getResults().get(1));
        assertEquals("asd", testPatternMatcher.getResults().get(2));
    }

    @Test
    void testIsValidString() {
        String inputOne = "Car_00005", inputTwo = "Car_0005";

        assertEquals(true, testPatternMatcher.isValidString(inputOne));
        assertEquals("CAR", testPatternMatcher.getKey());
        assertEquals(5, testPatternMatcher.getKeyValue());
    }
}