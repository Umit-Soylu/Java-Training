package com.bilgeadam.java.tutorials.examples.food_court;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Shop extends Thread{
    private final Object workLock = new Object();

    private final List<Order> orders;

    private final ScheduledExecutorService cooks, carriers;
    private final long workHours;

    /**
     * The constructor for the shop.
     *
     * @param nbOfCooks    Number of Cooks working in the shop
     * @param nbOfCarriers Number of Carriers working in the shop
     * @param workHours    Total work hours of the shop
     */
    public Shop(int nbOfCooks, int nbOfCarriers, long workHours) {
        this.workHours = workHours;
        orders = Collections.synchronizedList(new LinkedList<>());

        cooks = Executors.newScheduledThreadPool(nbOfCooks, new ThreadCounterFactory("Cook"));

        carriers = Executors.newScheduledThreadPool(nbOfCarriers, new ThreadCounterFactory("Carrier"));
    }

    /**
     * This method allow us to acquire order
     * @param o The order itself
     */
    public void acceptOrder(Order o){
        orders.add(o);

        synchronized (workLock) {
            workLock.notify();
        }
    }

    /**
     * This method allow us to prepare meals
     */
    private void prepareMeal(Order o)  {
        carriers.schedule(() -> this.deliverOrder(o), 30, TimeUnit.MILLISECONDS);
        System.out.println(Thread.currentThread().getName() + " prepared " + o.getOrder());
    }

    /**
     * This method allow carriers to deliver order
     * @param o The order to be delivered
     */
    private void deliverOrder(Order o) {
        o.deliverOrder();
        System.out.println(Thread.currentThread().getName() + " is delivered " + o.getOrder());
    }

    @Override
    public void run(){
        long startTime = (new Date()).getTime();
        System.out.println("Shop is open.");

        closeShopTimer();

        while (((new Date()).getTime() - startTime) < this.workHours) {

            while (!orders.isEmpty()) {
                Order o = orders.remove(0);
                cooks.schedule(() -> this.prepareMeal(o), o.getOrder().getPreparationTime() , TimeUnit.MILLISECONDS);
            }

            synchronized (workLock) {
                try {
                    workLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " going to close.");

        cooks.shutdown();
        carriers.shutdown();
        try {
            cooks.awaitTermination(30, TimeUnit.MILLISECONDS);
            carriers.awaitTermination(30, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ignored) {}
    }

    private void closeShopTimer(){
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            /**
             * The action to be performed by this timer task.
             */
            @Override
            public void run() {
                System.out.println("Time to close");

                synchronized (workLock) {
                    workLock.notify();
                }
            }
        }, this.workHours);
    }
}
