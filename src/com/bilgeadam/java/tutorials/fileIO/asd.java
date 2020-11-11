package com.bilgeadam.java.tutorials.fileIO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class asd {
    int test ;
    static Thread t1 = new Thread();
    static Thread t2 = new Thread();

    public static void main(String[] args) throws InterruptedException {
        t1.start();

        try {
            t1.join(10);
        } catch (InterruptedException e){
            System.out.println(t1.getName());
        }
        ExecutorService s = Executors.newFixedThreadPool(3);
        t2.start();
    }
}
