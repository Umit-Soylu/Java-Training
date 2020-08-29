package com.bilgeadam.java.tutorials.program_flow.decision_operators;

public class DecisionOperators {

    private static int x;

    public static void main(String[] args) {
        double i = Math.random();
        double x=0;
        boolean isExecuted;

        // For example using custom step sizes, values
        for (; i < 10.8 && x < 5; i += Math.random()) {
            isExecuted = false;
            x += i;
            System.out.println("Loop-" + i + " x:" + x);

            // For example using default for-loop
            for (int j = 0; j < 2; j++)
                System.out.println("j = " + j);

            // While loop using multiple Logical decisions
            while(i < 5.0 && !isExecuted){
                System.out.println("i = " + ++i);
                isExecuted = true;
            }

            System.out.println("Do - while loop is coming");

            // Do while loop with single logical decision
            do{
                i += 5;
                System.out.println("i = " + i);
            } while(i < 5.0);
        }
    }
}
