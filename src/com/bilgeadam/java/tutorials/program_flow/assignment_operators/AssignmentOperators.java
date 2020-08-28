package com.bilgeadam.java.tutorials.program_flow.assignment_operators;

public class AssignmentOperators {

    public static void main(String[] args) {
        Double varOne, varTwo, fixedVal = 3.0;
        int y;

        // Math.random() is a build in java class that generates random numbers in between [0.0 .. 1.0].
        varOne = Math.random();
        varTwo = varOne;

        System.out.println("Addition");
        varOne = varOne + fixedVal;
        System.out.println("varOne = " + varOne);
        varTwo += fixedVal;
        System.out.println("varTwo = " + varTwo);

        System.out.println("Subtraction");
        varOne = varOne - fixedVal;
        System.out.println("varOne = " + varOne);
        varTwo -= fixedVal;
        System.out.println("varTwo = " + varTwo);

        System.out.println("Division");
        varOne = varOne / fixedVal;
        System.out.println("varOne = " + varOne);
        varTwo /= fixedVal;
        System.out.println("varTwo = " + varTwo);

        System.out.println("Multiplication");
        varOne = varOne * 100;
        System.out.println("varOne = " + varOne);
        varTwo *= 100;
        System.out.println("varTwo = " + varTwo);

        System.out.println("Modulus");
        varOne = varOne % fixedVal;
        System.out.println("varOne = " + varOne);
        varTwo %= fixedVal;
        System.out.println("varTwo = " + varTwo);

    }
}
