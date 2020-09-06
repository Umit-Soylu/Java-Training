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
        assertEquals("New Java YJS4436", testString.appendStrings(testValue));
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
    void testLastIndex() {
        char c = 'a';

        assertEquals(7, testString.lastIndex(c));
    }
    @Test
    void testIndexOf() {
        char c = 'a';

        assertEquals(14, testString.indexOf(c));
    }
    @Test
    void testSplitString() {
        assertEquals("Java", testString.splitString());
    }

    @Test
    void testBuildingStrings() {
        assertEquals("Java YJS 4436 training with 0.85",
                testString.buildingStrings("YJS", 4436, "training", 0.85F));
    }

    @Test
    void testReverseNames(){
        String className = "Java", classId = "YJS 4436", studentOne = "Umit", studentTwo = "Egemen";

        // String array for students
        String[] students = new String[2];
        students[0] = studentOne;
        students[1] = studentTwo;

        assertEquals("Java YJS 4436 Egemen Umit", testString.reverseNames(className, classId, students));
    }
    
    @Test
    void testCapacity(){
        String initial = "Java YSJ 4436 class", appended = "Test Values Test Values Test Values";
        int trimValue = 19;

        assertEquals(initial, testString.capacity(initial, appended, trimValue));
    }
}