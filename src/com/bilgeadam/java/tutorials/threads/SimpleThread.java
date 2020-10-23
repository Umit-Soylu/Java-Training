package com.bilgeadam.java.tutorials.threads;

public class SimpleThread extends Thread{
    // The sleep time for the thread, prevents its death
    private static final long duration = 10_000_000L;

    /**
     * Let this thread to print its name and sleep for {@link #duration}
     */
    @Override
    public void run() {
        System.out.println("I am " + currentThread().getName());

        // Let it sleep
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println("I, '" + Thread.currentThread().getName() + "', is awake");
            //e.printStackTrace();
        }
    }
}
