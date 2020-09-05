package com.bilgeadam.java.tutorials.strings;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringsTest {
    Strings testString;

    @BeforeEach
    void setUp() {
        testString = new Strings();
    }

    @AfterEach
    void tearDown() {
        testString = null;
    }

    @Test
    void testStrings() {
        // 'Java' string is already in JVM, so it will be assigned to 'oldString' parameter.
        String oldString = "Java", otherOldString = "Java";
        assertSame(oldString, otherOldString);

        // This will guaranteed to create a new String in the memory
        String newString = "Java";
        assertNotSame(oldString, newString);

        // This only compares memory locations of parameters
        assertEquals(false, oldString == newString);

        // This compares the values of Strings itself
        assertEquals(true, oldString.equals(newString));
    }

    @Test
    void testAppendStrings() {
        String testValue = "YJS4436";
        assertEquals("New Java " + testValue, testString.appendStrings(testValue));
    }

    @Test
    void testReplaceChars() {
        char oldVal = 'a', newVal = 'A';
        assertEquals("New JAvA", testString.replaceChars(oldVal, newVal));
    }

    @Test
    void testReplaceFirstRegex() {
        String oldVal = "a", newVal = "A";

        assertEquals("New JAva", testString.replaceFirstRegex(oldVal, newVal));
    }

    @Test
    void testSubstring() {
        int startIndex = 11;
        assertEquals("YJS 4436", testString.substring(startIndex));
    }

    @Test
    void testBuildingStrings() {
    }

    @Test
    void testSplitString() {
        assertEquals("Java", testString.splitString());
    }
}