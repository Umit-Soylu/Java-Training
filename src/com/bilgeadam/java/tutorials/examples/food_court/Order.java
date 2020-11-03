package com.bilgeadam.java.tutorials.examples.food_court;

import java.util.Date;

public class Order {

    private final FoodTypes order;

    private final Date orderTime;

    private Date deliveryTime;

    public Order(FoodTypes order) {
        this.order = order;
        orderTime = new Date();
    }

    public FoodTypes getOrder() {
        return order;
    }

    public void deliverOrder(){
        deliveryTime = new Date();
    }

    public long completionTime(){
        return deliveryTime.getTime() - orderTime.getTime();
    }

    public boolean isCompleted(){
        return (deliveryTime != null);
    }
}
