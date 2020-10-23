package com.bilgeadam.java.examples.life_calculator.simulation;

public enum Configuration {
    length,
    width,
    nbOfEntities,
    foodRatio,
    turn;

    private Number value;

    public Number getValue() {
        return value;
    }

    public void setValue(Number value) {
        this.value = value;
    }
}
