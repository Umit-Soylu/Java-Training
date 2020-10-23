package com.bilgeadam.java.tutorials.threads.deadlock;

public class Locker implements RunForLock {
    // These are the locks will be locked
    private final Object lockOne, lockTwo;

    /**
     * Constructor with lock objects as reference
     *
     * @param lockOne First lock to acquire
     * @param lockTwo Second lock to acquire
     */
    public Locker(Lock lockOne, Lock lockTwo) {
        this.lockOne = lockOne;
        this.lockTwo = lockTwo;
    }

    /**
     * Tries to lock given object
     *
     * @param lock The lock to be acquired
     * @return
     */
    @Override
    public Runnable LockObject(Object lock) {
        return () -> {
            // Capture initial lock
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " is holding " + lock);

                try {
                    Thread.sleep(10);//currentThread().wait(10);
                } catch (InterruptedException exception) {
                    // Thread.currentThread().interrupt();
                }

                Object target = lock.equals(lockOne) ? lockTwo : lockOne;
                //System.out.println(Thread.currentThread().getName() + " is missing " + target);

                // Capture remaining lock
                synchronized (target) {
                    System.out.println(Thread.currentThread().getName() + " is holding " + target);

                }
            }
        };
    }

}
