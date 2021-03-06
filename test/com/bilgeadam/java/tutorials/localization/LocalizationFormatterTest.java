package com.bilgeadam.java.tutorials.localization;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void formatCurrency() {
        Locale l = new Locale.Builder().setLanguage("ar").setRegion("AU").build();

        System.out.println(testClass.formatCurrency(l));
    }

    @Test
    void formatDate() {
        Locale l = new Locale.Builder().setLanguage("ar").setRegion("TR").build();

        System.out.println(testClass.formatDate(l));
    }

    @Test
    void generateTurkishMessages() {
        Locale l = new Locale("tr", "US");

        assertEquals("Hoşgeldiniz",  testClass.generateMessage("welcome", l));
        assertEquals("Görüşmek üzere",  testClass.generateMessage("goodbye", l));
    }

    @Test
    void generateEnglishMessages() {
        Locale l = new Locale("en", "TR");

        assertEquals("Welcome",  testClass.generateMessage("welcome", l));
        assertEquals("See you later",  testClass.generateMessage("goodbye", l));
    }

    @Test
    void generateDefaultMessages() {
        Locale l = new Locale("tr");
        assertEquals("Hoşgeldiniz",  testClass.generateMessage("welcome", l));
        assertEquals("Görüşmek üzere",  testClass.generateMessage("goodbye", l));

        l = new Locale("en");
        assertEquals("Welcome",  testClass.generateMessage("welcome", l));
        assertEquals("See you later",  testClass.generateMessage("goodbye", l));

        l = new Locale("ar");
        assertEquals("Hoşgeldiniz",  testClass.generateMessage("welcome", l));
        assertEquals("Görüşmek üzere",  testClass.generateMessage("goodbye", l));

    }

}