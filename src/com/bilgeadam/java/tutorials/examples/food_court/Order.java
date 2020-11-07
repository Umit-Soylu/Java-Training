package com.bilgeadam.java.tutorials.examples.food_court;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Order {

    private final FoodTypes order;

    private final Date orderTime;

    private Date deliveryTime;

    public Order(FoodTypes order) {
        this.order = order;
        orderTime = new Date();
    }

    /**
     * Get the type of the food
     * @return Food Type
     */
    public FoodTypes getOrder() {
        return order;
    }

    /**
     * This method is called in order to deliver the order and time tag it.
     */
    public void deliverOrder(){
        deliveryTime = new Date();
    }

    /**
     * This method calculates how long it take to complete an order.
     *
     * @return {@link TimeUnit#MILLISECONDS} to complete given order
     */
    public long completionTime(){
        return deliveryTime.getTime() - orderTime.getTime();
    }

    /**
     * Check if the order is completed via {@code deliveryTime}
     *
     * @return true if delivery is complete, false otherwise
     */
    public boolean isCompleted(){
        return (deliveryTime != null);
    }
}
