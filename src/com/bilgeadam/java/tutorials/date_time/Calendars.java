package com.bilgeadam.java.tutorials.date_time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Calendars {
    private static final String calendarFormatString = "yyyy/MMMMMM/dd hh:mm:ss:SSSS";
    private final SimpleDateFormat simpleDateFormat;
    private final GregorianCalendar calendar;

    public Calendars() {
        // Create format for calendar
        simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(calendarFormatString);


        this.calendar  = new GregorianCalendar();
    }

    public Calendar getCalendar() {

        return this.calendar;
        /*
        return calendar.getDisplayName((Calendar.MONTH, Calendar.DAY_OF_MONTH, Calendar.YEAR),
                Calendar.LONG,
                Locale.ENGLISH);*/
    }

    public boolean isLeapYear(){
        return calendar.isLeapYear(calendar.get(Calendar.YEAR));
    }

    public String getCalendarString() {

        return this.simpleDateFormat.format(this.calendar.getTime());
    }
}
