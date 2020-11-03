package com.bilgeadam.java.tutorials.examples.food_court;

import java.util.concurrent.ThreadFactory;

public class ThreadCounterFactory implements ThreadFactory {

    private final String naming;

    private int count;

    public ThreadCounterFactory(String name) {
        naming = name;
    }

    /**
     * Constructs a new {@code Thread}.  Implementations may also initialize
     * priority, name, daemon status, {@code ThreadGroup}, etc.
     *
     * @param r a runnable to be executed by new thread instance
     * @return constructed thread, or {@code null} if the request to
     * create a thread is rejected
     */
    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, naming + "-" + count++);
    }
}
