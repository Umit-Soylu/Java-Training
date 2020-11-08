package com.bilgeadam.java.tutorials.threads.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Worker implements Runnable{

    private final CyclicBarrier barrier;
    private final int counter;
    public Worker(CyclicBarrier barrier, int limit) {
        this.barrier = barrier;
        this.counter = limit;
    }

    @Override
    public void run() {
        for (int i = 0; i < counter; i++) {

            System.out.println(Thread.currentThread().getName() + " is running for turn " + i);

            try {
                //System.out.println("barrier waiting counter = " + barrier.getNumberWaiting());
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

    }
}
