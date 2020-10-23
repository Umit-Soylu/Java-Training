package com.bilgeadam.java.tutorials.threads;

public class SimpleThread implements Runnable {


    /**
     * This method writes 'I am SimpleThread'
     */
    @Override
    public void run() {
        System.out.println("I am " + this.getClass().getSimpleName());
    }
}
