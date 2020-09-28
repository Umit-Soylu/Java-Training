package com.bilgeadam.java.tutorials.date_time;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Dates {


    // This format needs to be parsed by DateFormat class
    private static final String dateFormatString = "HH:mm:ss:SSS z dd/MM/yyyy";

    private final Date createdDate;

    private final SimpleDateFormat dateFormat;


    /**
     * Initializes the class and assigns initialization time.
     *
     */
    public Dates() {
        // Create a format for Date object
        this.dateFormat = new SimpleDateFormat();
        this.dateFormat.applyPattern(dateFormatString);

        // Acquire current time and store it
        this.createdDate = new Date();
    }

    /**
     *
     * @return Creation date based on predefined String format default to GMT+0
     */
    public String getCreatedDateString() {
        // Set the time zone for UTC or GMT+0
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        return dateFormat.format(createdDate);
    }

    /**
     *
     * @return the Date object of this class.
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     *
     * @param timeZone        Requested time zone to return
     * @return Date String for the requested {@param timezone}
     */
    public String convertTimeZone(TimeZone timeZone) {
        // Set the time zone
        this.dateFormat.setTimeZone(timeZone);

        // Return the string for the requested time zone.
        return dateFormat.format(createdDate);
    }

    /**
     *
     * @return The Date format string
     */
    public static String getDateFormatString() {
        return dateFormatString;
    }
}
