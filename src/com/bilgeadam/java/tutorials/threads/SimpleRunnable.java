package com.bilgeadam.java.tutorials.threads;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleRunnable implements Runnable {
    private static final String pattern = "dd/MMMM/YYYY HH:mm:ss:SSS";
    private final SimpleDateFormat formatter;

    private final Date birth;

    public SimpleRunnable() {
        birth = new Date(); //Store its birthday :)

        formatter = new SimpleDateFormat(pattern);
    }

    /**
     * This method writes 'I am SimpleRunnable'
     */
    @Override
    public void run() {
        System.out.println("I am " + this.getClass().getSimpleName() + " and " + getBirth());
    }


    /**
     * Provides birthday based on its {@link #pattern}
     *
     * @return Birthday
     */
    public String getBirth() {
        return "You are " + Thread.currentThread().getName() +
                " and I was born at " + formatter.format(birth);
    }

}
