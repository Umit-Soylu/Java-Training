package com.bilgeadam.java.tutorials.design_patterns.builder;

import java.util.HashMap;
import java.util.Map;

class Hamburger implements Food{
    // Required Parameters
    // Used for representing double Burger, triple burger
    private int meatCount;

    // Used for representing no cheese, double cheese, triple cheese
    private int cheeseCount;

    // Optional parameters
    private boolean ketchup, mayonnaise;

    // Functional requirements
    HashMap<String, String> ingredients;

    protected Hamburger() {
        ingredients = new HashMap<>();
        this.meatCount = 1;
        this.cheeseCount = 1;
        this.ketchup = true;
        this.mayonnaise = true;
    }

    protected void setMeatCount(int meatCount) {
        this.meatCount = Math.max(1 , meatCount);
    }

    protected int getMeatCount() {
        return meatCount;
    }

    protected void setCheeseCount(int cheeseCount) {
        this.cheeseCount = Math.max(0, cheeseCount);
    }

    protected int getCheeseCount() {
        return cheeseCount;
    }

    protected void setKetchup(boolean ketchup) {
        this.ketchup = ketchup;
    }

    protected boolean isKetchup() {
        return ketchup;
    }

    protected void setMayonnaise(boolean mayonnaise) {
        this.mayonnaise = mayonnaise;
    }

    protected boolean isMayonnaise() {
        return mayonnaise;
    }

    @Override
    public Map getIngredients() {
        ingredients.put("Meat", String.valueOf(getMeatCount()));
        ingredients.put("Cheese", String.valueOf(getCheeseCount()));
        ingredients.put("Ketchup", String.valueOf(isKetchup()));
        ingredients.put("Mayonnaise", String.valueOf(isMayonnaise()));

        return ingredients;
    }
}
