package com.bilgeadam.java.tutorials.design_patterns.factory;

public abstract class Hardware {
    private final String name;

    private final Capacity capacity;

    public Hardware(String name, Number value, String unit) {
        this.name = name;
        this.capacity = new Capacity(value, unit);
    }

    public Capacity getCapacity() {
        return capacity;
    }
}

class Capacity{
    private final Number value;
    private final String unit;

    public Capacity(Number value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public Number getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }
}