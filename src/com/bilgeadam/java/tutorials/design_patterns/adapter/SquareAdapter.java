package com.bilgeadam.java.tutorials.design_patterns.adapter;

public class SquareAdapter extends Rectangular{
    private final Square square;

    public SquareAdapter(int width, int length, Square square) {
        super(width, length);
        this.square = square;
    }

    @Override
    public float calculateArea() {
        return super.calculateArea() / square.calculateArea();
    }

    protected String getSize(){
        return square.getSize() + "Adapter";
    }
}
