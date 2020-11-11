package com.bilgeadam.java.tutorials.design_patterns.prototype;

public abstract class Car implements Cloneable{
    private final String type;

    private long id;

    public Car(String type) {
        this.id++;
        this.type = type;
    }

    public String getCarType(){
        return type;
    }

    public Long getCarId(){
        return id;
    }

    @Override
    protected Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
