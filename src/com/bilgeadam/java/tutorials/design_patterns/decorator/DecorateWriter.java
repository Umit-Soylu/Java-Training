package com.bilgeadam.java.tutorials.design_patterns.decorator;

public class DecorateWriter {
    private final Writer target;

    public DecorateWriter(Writer target) {
        this.target = target;
    }

    public void writeAllLines(String[] lines){
        for (String line : lines) {
            target.printToFile(line);
        }
    }
}
