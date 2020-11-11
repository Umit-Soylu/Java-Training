package com.bilgeadam.java.tutorials.design_patterns.adapter;

public class Square implements Shape{
    private final int dimension;

    public Square(int dimension) {
        this.dimension = dimension;
    }

    protected String getSize(){
        return "Square";
    }

    @Override
    public float calculateArea() {
        return dimension * dimension;
    }

    @Override
    public int calculateCircumference() {
        return 4 * dimension;
    }
}
