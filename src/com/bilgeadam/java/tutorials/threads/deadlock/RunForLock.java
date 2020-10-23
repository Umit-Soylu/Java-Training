package com.bilgeadam.java.tutorials.threads.deadlock;

@FunctionalInterface
public interface RunForLock {
    /**
     * Tries to lock given object
     *
     * @param lock The lock to be acquired
     * @return Runnable to process lock
     */
    Runnable LockObject(Object lock);
}
