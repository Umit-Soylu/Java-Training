package com.bilgeadam.java.tutorials.date_time;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.*;

class DatesTest {

    Dates testDate;
    
    @BeforeEach
    void setUp() {
        testDate = new Dates();
    }

    @AfterEach
    void tearDown() {
        testDate = null;
    }

    @Test
    void getCreatedDate() {
        // This methods acquires testDate generation Date and compare it with now.
        assertTrue(testDate.getCreatedDate().before(new Date()));
        assertFalse(testDate.getCreatedDate().after(new Date()));
    }

    @Test
    void testGetDate() throws ParseException {
        // Generate same formatter to parse String to Date
        SimpleDateFormat testFormatter = new SimpleDateFormat();
        testFormatter.applyPattern(Dates.getDateFormatString());

        String dateString = testDate.getCreatedDateString();

        // Parse string to Date and compare it with existing date object
        assertEquals(0, testFormatter.parse(dateString).compareTo(testDate.getCreatedDate()));

    }

    @Test
    void testConvertTimeZone() throws ParseException {
        // Generate same formatter to parse String to Date
        SimpleDateFormat testFormatter = new SimpleDateFormat();
        testFormatter.applyPattern(Dates.getDateFormatString());

        // Set time zone to GMT+10
        TimeZone testZone = TimeZone.getTimeZone("GMT+10");
        String convertedDateString = testDate.convertTimeZone(testZone);

        // Print both strings
        System.out.println("convertedDateString = " + convertedDateString);
        System.out.println("testDate original String = " + testDate.getCreatedDateString());

        assertEquals(0, testFormatter.parse(convertedDateString).compareTo(testDate.getCreatedDate()));
    }
}