package com.bilgeadam.java.tutorials.localization;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;

public class LocalizationFormatter {
    // Pattern to represent
    private final String regex = "dd/MMMM/YYYY hh:ss:SSSS";

    // Formatter used to change date or time format with requested locale
    DateTimeFormatter formatter;

    // Assign date to initialization time;
    Date date = new Date();

    Timer timer = new Timer();

    NumberFormat numberFormat;
    Currency currency;

    /**
     * Format currency with given locale
     * @param locale Requested locale
     */
    public String formatCurrency(Locale locale){
        double d = 3444555.433d;

        numberFormat = NumberFormat.getCurrencyInstance(locale);

        return numberFormat.format(d);
    }

    /**
     * Formats current day with requested locale
     * @param locale Requested locale
     */
    public String formatDate(Locale locale){
        formatter = DateTimeFormatter.ofPattern(regex, locale);


        LocalDateTime t = LocalDateTime.now();

        return formatter.format(t);
    }

}
