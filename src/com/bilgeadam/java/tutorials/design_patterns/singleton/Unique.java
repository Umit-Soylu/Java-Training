package com.bilgeadam.java.tutorials.design_patterns.singleton;


import java.util.Date;

/**
 * This class is Singleton and {@link Thread} safe
 */
public class Unique {

    // This field shows whether or not the Unique is initialized.
    private static volatile Unique instance;

    private final Long name;

    private Unique() {
        //name = Thread.currentThread().getName();
        name = (new Date()).getTime();
    }

    /**
     *
     * @return Unique instance
     */
    public static Unique getInstance() {
        // Initialize if not.
        if (Unique.instance == null) {
            synchronized (Unique.class) {
                if (Unique.instance == null)
                    Unique.instance = new Unique();
            }
        }
        return Unique.instance;
    }

    public Long getName() {
        return name;
    }
}
