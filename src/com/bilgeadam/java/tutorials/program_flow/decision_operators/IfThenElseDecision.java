package com.bilgeadam.java.tutorials.program_flow.decision_operators;

public class IfThenElseDecision {
    private static double x;

    public static void main(String[] args) {
        x = Math.random();
        System.out.println("Initial x = " + x);

        // If example
        if (!(x >= 0.5)) {
            x += 0.1;
        }
        System.out.println("x = " + x);

        // Create a value in between 0 .. 50
        int y = (int) (Math.random() * 50);
        System.out.println("y = " + y);

        // If-then-else example
        /*
        if (y < 25)
            y += 3;
        else
            y += 10;
        */

        // If-then-else using conditional operator
        y += (y < 25) ? 3 : 10;
        System.out.println("y = " + y);
    }
}
