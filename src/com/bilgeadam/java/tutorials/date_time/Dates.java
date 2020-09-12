package com.bilgeadam.java.tutorials.date_time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Dates {
    private static final String dateFormatString = "HH:mm:ss:SSS z dd/MM/yyyy";
    //private static String dateFormatString = "MMMMMMMMMMMM/ddddddddd/yyyy EEEEEE zzzzz HHHHH:mmmmm:ssssss:SSSS";

    private final String createdDateString;
    private Date createdDate;

    private final SimpleDateFormat dateFormat;


    public Dates() throws ParseException {
        // Create a format for Date object
        this.dateFormat = new SimpleDateFormat();
        this.dateFormat.applyPattern(dateFormatString);

        // Set the time zone for UTC or GMT+0
        this.dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+10"));

        // Acquire current time

        // Apply given format to the object
        this.createdDateString = this.dateFormat.format(new Date());

        this.createdDate = dateFormat.parse(createdDateString);
    }

    /**
     *
     * @return Creation date
     */
    public String getCreatedDateString() {
        return createdDateString;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void convertTimeZone(TimeZone timeZone) throws ParseException {
        this.dateFormat.setTimeZone(timeZone);

        this.createdDate = dateFormat.parse(this.createdDateString);
    }
}
