package com.bilgeadam.java.tutorials.fileIO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class asd {
    int test ;
    static ha t1 = new ha();
    static ha t2 = new ha();

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
