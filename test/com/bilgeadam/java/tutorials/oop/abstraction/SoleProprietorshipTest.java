package com.bilgeadam.java.tutorials.oop.abstraction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SoleProprietorshipTest {
    // The company class to be tested
    SoleProprietorship testCompany;

    // The variables to be used in tests.
    String name = "Java Company", owner = "YJS 4436";
    int companySize = 10;

    @BeforeEach
    void setUp() {
        testCompany = new SoleProprietorship(owner, name, companySize);
    }

    @AfterEach
    void tearDown() {
        testCompany = null;
    }

    /**
     * Checks the override isCompanyActive method is working as intended.
     */
    @Test
    void isCompanyActive() {
        // Verify constructor set default company state.
        assertEquals(true, testCompany.isCompanyActive());

        // Verify deactivate method is working
        testCompany.deactivateCompany();
        assertEquals(false, testCompany.isCompanyActive());

        // Verify activate method is working
        testCompany.activateCompany();
        assertEquals(true, testCompany.isCompanyActive());

    }

    /**
     * Check the company size using recruitEmployee and fireEmployee methods
     */
    @Test
    void testCompanySize() {
        String employee = "Umit Soylu";

        // Recruit 1 more person to the company
        testCompany.recruitEmployee(employee);
        assertEquals((float) 2 / companySize, testCompany.occupancyRate());

        // Fire an employee from the company
        testCompany.fireEmployee(employee);
        assertEquals((float) 1 / companySize, testCompany.occupancyRate());
    }
}