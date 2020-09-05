package com.bilgeadam.java.tutorials.enumeration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookTest {
    Book testBook;

    // Test variable
    String name = "Learning JAVA",  author = "YJS 4436", stateOne = "Preparing", stateTwo = "Error";
    BookStages testStage = BookStages.Published;

    @BeforeEach
    void setUp() {
        testBook = new Book(name, author);
    }

    @AfterEach
    void tearDown() {
        testBook = null;
    }

    @Test
    void testBookStates() {
        testBook.setState(stateOne);
        assertEquals(stateOne, testBook.getState());
    }

    @Test
    void testBookStateEnum() {
        testBook.setState(testStage);
        assertEquals(testStage.toString(), testBook.getState());
    }

    @Test
    void testBookStateError() {
        assertThrows(IllegalArgumentException.class, ()-> testBook.setState(stateTwo));
    }

}