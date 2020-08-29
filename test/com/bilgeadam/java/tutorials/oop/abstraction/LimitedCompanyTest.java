package com.bilgeadam.java.tutorials.oop.abstraction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LimitedCompanyTest {
    // The company class to be tested
    LimitedCompany testCompany;

    // The variables to be used in tests.
    String name = "Java Company", owner = "YJS 4436";
    int companySize = 10;

    @BeforeEach
    void setUp() {
        testCompany = new LimitedCompany(owner, name, companySize);
    }

    @AfterEach
    void tearDown() {
        testCompany = null;
    }

    /**
     * Test the default method is working - this method is not override in any place
     */
    @Test
    void testDefaultMethod() {
        assertEquals(true, testCompany.isCompanyActive());
    }
}