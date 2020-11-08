package com.bilgeadam.java.tutorials.threads.barrier;

import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;

public class Work {

    private final Thread[] workers;

    private final CyclicBarrier cyclicBarrier;

    private final int limit;
    public Work(int workerCount, int turnLimit) {
        this.workers = new Thread[workerCount];
        this.limit = turnLimit;
        cyclicBarrier = new CyclicBarrier(workerCount, new Coordinator());
    }

    public void startWork(){
        System.out.println("Work.startWork");

        Arrays.stream(workers).parallel().forEach(t ->{
            Worker w = new Worker(cyclicBarrier, limit);
            t = new Thread(w);
            t.start();
        });

        Arrays.stream(workers).parallel().forEach(t -> {
            try {
                if (t != null && t.isAlive())
                    t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("Work.endWork");

    }
}
