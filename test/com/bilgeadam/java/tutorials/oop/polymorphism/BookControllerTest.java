package com.bilgeadam.java.tutorials.oop.polymorphism;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookControllerTest {
    // Test Objects to be created.
    private Novel testNovel;
    private Tale testTale;

    // Test Controller Object.
    private BookController testBookController;

    // Set up parameters for this test class
    String name_1 = "Learning Novel", author = "YJS 4436", name_2 = "Learning Tales";

    @BeforeEach
    void setUp() {
        testNovel = new Novel(name_1, author);
        testTale = new Tale(name_2, author, "Reviewing");
        testBookController = new BookController();
    }

    @AfterEach
    void tearDown() {
        testTale = null;
        testNovel = null;
    }

    @Test
    void testNumberOfPages() {
        int nbOfPages = 1055;

        // Will call Book's setNbOfPages method because Tale do not override setNbOfPages method
        testBookController.setBookPages(testTale, nbOfPages);
        assertEquals(nbOfPages, testTale.getNbOfPages());

        // Will call Novel's override setNbOfPages method
        // setBookPages(testNovel, nbOfPages); // This will raise an exception.
        assertThrows(IllegalArgumentException.class, ()-> testBookController.setBookPages(testNovel, nbOfPages));
    }

    @Test
    void testBookState() {
        String state = "Preparing";

        // Tales cannot have 'Preparing' state
        assertThrows(IllegalArgumentException.class, ()-> testBookController.setBookState(testTale, state));

        // Novel can have 'Preparing' state
        testBookController.setBookState(testNovel, state);
        assertEquals(state, testNovel.getState());
    }
}