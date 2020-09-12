package com.bilgeadam.java.tutorials.date_time;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

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
        System.out.println("testCalendars.getCalendar() = " + testCalendars.getCalendar().get(Calendar.YEAR));
        System.out.println("testCalendars.getCalendar() = " + testCalendars.getCalendar().get(Calendar.MONTH));
        System.out.println("testCalendars.getCalendar() = " + testCalendars.getCalendar().get(Calendar.DAY_OF_MONTH));
        System.out.println("testCalendars.getCalendar() = " + testCalendars.getCalendar().isLenient());
    }

    @Test
    void testLeapYear() {
        assertEquals(true, testCalendars.isLeapYear());
    }

    @Test
    void getCalendarString() {
        System.out.println("testCalendars.getCalendarString() = " + testCalendars.getCalendarString());
    }
}