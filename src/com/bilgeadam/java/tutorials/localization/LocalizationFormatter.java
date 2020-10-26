package com.bilgeadam.java.tutorials.localization;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizationFormatter {
    // Pattern to represent
    private static final String regex = "dd/MMMM/YYYY hh:mm:ss:SSSS";

    // Formatter used to change date or time format with requested locale
    DateTimeFormatter formatter;

    NumberFormat numberFormat;

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

    /**
     * This method generate messages according to the input params
     * @param messageType Type of message to be generated
     * @param locale      The requested locale for message
     * @return the message
     */
    public String generateMessage(String messageType, Locale locale){
        //This allow us to override default locale as Turkish
        Locale.setDefault(new Locale("tr"));

        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", locale);

        return resourceBundle.getString(messageType);
    }
}
