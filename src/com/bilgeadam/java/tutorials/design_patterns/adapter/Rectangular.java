package com.bilgeadam.java.tutorials.design_patterns.adapter;

public class Rectangular implements Shape {
    private final int width, length;

    public Rectangular(int width, int length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public float calculateArea() {
        return width * length;
    }

    @Override
    public int calculateCircumference() {
        return 2 * (width + length);
    }

    public void demoMethod(){
        ;
    }
}
