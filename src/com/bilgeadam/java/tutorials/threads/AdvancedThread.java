package com.bilgeadam.java.tutorials.threads;

public class AdvancedThread extends Thread{
    private static final int maxTurn = 10;

    /**
     * Constructor
     * @param group Thread group belonging
     * @param name  Name of the thread
     */
    public AdvancedThread(ThreadGroup group, String name) {
        super(group, name);
    }

    /**
     * Runs current thread and waits until further notification
     */
    @Override
    public void run() {
        // Print turns
        for (int i = 0; i < maxTurn; i++) {
            System.out.println(Thread.currentThread().getName() + " turn is " + i);
        }

        // Waits until further notification
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(getName() + " is awoken!");
            }
        }
    }
}
