package com.bilgeadam.java.tutorials.examples.food_court;

public enum FoodTypes {
    Hamburger(15, 25),
    Cheeseburger(10,20),
    DoubleCheeseburger(15, 20);

    private final long min, max;

    FoodTypes(long min, long max) {
        this.min = min;
        this.max = max;
    }

    public long getPreparationTime() {
        return min + (long) (Math.random() * (max - min));
    }

    public static FoodTypes getRandomEnum(){
        return FoodTypes.values()[(int) Math.round(Math.random() * (FoodTypes.values().length - 1))];
    }
}
