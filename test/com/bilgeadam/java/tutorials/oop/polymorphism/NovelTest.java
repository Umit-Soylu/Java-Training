package com.bilgeadam.java.tutorials.oop.polymorphism;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NovelTest {

    private Novel testNovel;


    // Set up parameters for this test class
    String name = "Learning Java", author = "YJS 4436";

    @BeforeEach
    void setUp() {
        testNovel = new Novel(name, author);
    }

    @AfterEach
    void tearDown() {
        testNovel = null;
    }


    /**
     * Verify that number of pages set according to min page novel criteria
     */
    @Test
    void testMinPages() {
        int page = 100;

        testNovel.setNbOfPages(page);
        assertEquals(page, testNovel.getNbOfPages());
    }

    /**
     * Verify that number of pages set according to max page novel criteria
     */
    @Test
    void TestMaxPages() {
        int page = 1000;

        testNovel.setNbOfPages(page);
        assertEquals(page, testNovel.getNbOfPages());
    }

    /**
     * Verify that number of pages cannot be less than 100
     */
    @Test
    void TestLessThanMinPages() {
        int page = 99;

        assertThrows(IllegalArgumentException.class, ()-> testNovel.setNbOfPages(page));
    }

    /**
     * Verify that number of pages cannot be less than 100
     */
    @Test
    void testLessThanMaxPages() {
        int page = 1001;

        assertThrows(IllegalArgumentException.class, ()-> testNovel.setNbOfPages(page));
    }

    /**
     * Verify that first and second novel types can be set.
     */
    @Test
    void testMethodOverloading() {
        String type = "Macera", secondType = "Bilimkurgu";

        // Test initial type
        testNovel.setType(type);
        assertEquals(type, testNovel.getType());

        // Test second type
        testNovel.setType(secondType, true);
        assertEquals(secondType, testNovel.getSecondType());
    }

    /**
     * Verify that second book type cannot be set before first type is set.
     */
    @Test
    void testMethodOverloadingErrors() {
        String secondType = "Bilimkurgu";

        // testNovel.setType(secondType, true); This will throw an exception.
        assertThrows(IllegalArgumentException.class, ()-> testNovel.setType(secondType, true));
    }

}