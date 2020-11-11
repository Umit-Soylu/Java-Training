package com.bilgeadam.java.tutorials.design_patterns.prototype;

import java.util.Hashtable;

public class Prototype {
    Hashtable<String, Car> tables;

    public Prototype() {
        this.tables = new Hashtable<>();
        tables.put("Personnel", new Personnel());
        tables.put("Commercial", new Commercial());
    }

    public Car getCar(String type){
        return (Car) tables.get(type).clone();
    }
}
