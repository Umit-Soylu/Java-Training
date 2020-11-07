package com.bilgeadam.java.tutorials.examples.food_court;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Simulation {
    // Period in between the orders
    private static final long orderPeriod = 45;
    private static final int nbOfCustomers = 15;

    private static final LinkedList<Order> orders = new LinkedList<>();

    private static final Shop s = new Shop(4,10, 8 * 60);


    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService customers = Executors.newScheduledThreadPool(nbOfCustomers, new ThreadCounterFactory("Customer"));

        for (int i = 0; i < nbOfCustomers; i++)
            customers.scheduleWithFixedDelay(()-> {
                Order tmp = new Order(FoodTypes.getRandomEnum());
                orders.add(tmp);
                s.acceptOrder(tmp);
                System.out.println(Thread.currentThread().getName() + " ordered " + tmp.getOrder());
            }, 1, orderPeriod, TimeUnit.MILLISECONDS);

        // Setup the shop.
        Thread shop = new Thread(s, "Shop");
        shop.start();
        shop.join();

        // Finalize the customers.
        customers.shutdownNow();
        customers.awaitTermination(10, TimeUnit.SECONDS);

        printStatistics();
        //printOrders();
    }


    private static void printStatistics(){
        System.out.println("Total order count:" + orders.size() +
                "; Unfinished Order count: " + (orders.size() - orders.stream().filter(Order::isCompleted).count()) +
                "; Average Completion Time: " +
                orders.stream().filter(Order::isCompleted).mapToLong(Order::completionTime).average().orElse(Double.NaN));
    }
    private static void printOrders(){
        orders.stream().filter(Order::isCompleted).
                forEach(e -> System.out.println("Order is " + e.getOrder() + " completion time:" + e.completionTime()));
    }
}
