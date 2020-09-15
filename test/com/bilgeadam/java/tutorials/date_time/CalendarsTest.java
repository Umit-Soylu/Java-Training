package com.bilgeadam.java.tutorials.date_time;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalendarsTest {
    private Calendars testCalendars;
    
    @BeforeEach
    void setUp() {
        testCalendars = new Calendars();
    }

    @AfterEach
    void tearDown() {
        testCalendars = null;
    }

    @Test
    void getCalendar() {
        // Locale object can be set with language and country separately.
        Locale locale = new Locale("tr", "TR");

        // Get the current month for given locale
        String testMonth = new GregorianCalendar().getDisplayName(Calendar.MONTH, Calendar.LONG, locale);

        assertEquals(testMonth, testCalendars.getCalendarMonth(locale));
    }

    @Test
    void testLeapYear() {
        // Get current year
        int year = testCalendars.getCalendarYear();

        // If year can be divided by 4, it is a leap year
        assertEquals(year % 4 == 0, testCalendars.isLeapYear());
    }
}