package com.bilgeadam.java.tutorials.date_time;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Date;

class DatesTest {

    Dates testDate;
    
    @BeforeEach
    void setUp() throws ParseException {
        testDate = new Dates();
    }

    @AfterEach
    void tearDown() {
        testDate = null;
    }

    @Test
    void getCreatedDate() {
        Date d = this.testDate.getCreatedDate();
        boolean isAfter = d.after(new Date());

        System.out.println("isAfter = " + isAfter);
        System.out.println("testDate.getCreatedDate() = " + testDate.getCreatedDateString());
    }

    @Test
    void testGetDate() {
        System.out.println("testDate.getCreatedDate() = " + testDate.getCreatedDate());
    }
}