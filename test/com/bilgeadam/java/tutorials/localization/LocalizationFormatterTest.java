package com.bilgeadam.java.tutorials.localization;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

class LocalizationFormatterTest {

    LocalizationFormatter testClass;

    @BeforeEach
    void setUp() {
        testClass = new LocalizationFormatter();
    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    @Test
    void formatDate() {
        Locale l = new Locale.Builder().setLanguage("tr").setRegion("AR").build();

        System.out.println(testClass.formatDate(l));
    }

    @Test
    void formatCurrency() {
        Locale l = new Locale.Builder().setLanguage("us").setRegion("AR").build();

        System.out.println(testClass.formatCurrency(l));
    }
}