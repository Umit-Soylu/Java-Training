package com.bilgeadam.java.tutorials.date_time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Calendars {
    private static final String calendarFormatString = "yyyy/MMMM/dd hh:mm:ss:SSSS";
    private final SimpleDateFormat simpleDateFormat;
    private final GregorianCalendar calendar;

    public Calendars() {
        // Create format for calendar
        simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(calendarFormatString);

        // Initialize calendar with current time
        this.calendar  = new GregorianCalendar();
    }

    /**
     * This fucntion uses getDispalyName method with Locale
     * @param locale requested
     * @return String of the Month
     */
    public String getCalendarMonth(Locale locale) {
        return calendar.getDisplayName(Calendar.MONTH,
                Calendar.LONG,
                locale);
    }

    /**
     * This method only returns integer representation of the year
     * @return Current Year
     */
    public int getCalendarYear() {
        return calendar.get(Calendar.YEAR);

    }

    /**
     *
     * @return True if leap year, false otherwise
     */
    public boolean isLeapYear(){
        return calendar.isLeapYear(calendar.get(Calendar.YEAR));
    }

    /**
     * Calendar also includes Date object which can be retrieved and parsed as needed.
     * @return Formatted Date object
     */
    public String getCalendarString() {
        return this.simpleDateFormat.format(this.calendar.getTime());
    }
}
