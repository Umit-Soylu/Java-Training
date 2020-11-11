package com.bilgeadam.java.tutorials.design_patterns.factory;

public class CPU extends Hardware{

    protected CPU(String name, float value) {
        super(name,  value, "Ghz");
    }

    // Other custom methods...
}
