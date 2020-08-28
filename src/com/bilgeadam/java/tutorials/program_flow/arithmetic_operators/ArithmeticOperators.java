package com.bilgeadam.java.tutorials.program_flow.arithmetic_operators;

public class ArithmeticOperators {

    // Decrement example
    private static void Decrement(int varOne) {
        int y;
        --varOne; // varOne = varOne + 1;
        y = varOne;
        varOne--; // varOne = varOne + 1;

        System.out.println("Decrement y: " + y);
        System.out.println("Decrement varOne-1: " + varOne);

        System.out.println("Decrement varOne-2: " + varOne--);
        System.out.println("Decrement varOne-3: " + varOne);
        System.out.println("Decrement y-2: " + y);

        System.out.println("Decrement varOne-4: " + --varOne);
        System.out.println("Decrement varOne-5: " + varOne);
    }

    // Increment example
    private static int Increment(int varOne) {
        int x;
        ++varOne; // varOne = varOne + 1;
        x = varOne;
        varOne++; // varOne = varOne + 1;

        System.out.println("Increment x: " + x);
        System.out.println("Increment varOne-1: " + varOne);

        System.out.println("Increment varOne-2: " + varOne++);
        System.out.println("Increment varOne-3: " + varOne);

        System.out.println("Increment varOne-4: " + ++varOne);
        System.out.println("Increment varOne-5: " + varOne);
        return varOne;
    }

    // Division example
    private static void Division(float floatOne, float floatTwo) {
        float localResult;// localResult =  varOne / varTwo; // 0.0
        // localResult = (float) varOne / varTwo; // 0.5
        // result = (float) varOne / varTwo; // Casting error
        localResult = floatOne / floatTwo; // 0.5
        System.out.println("Division Result: " + localResult);
    }

    // Multiplication example
    private static void Multiplication(int varOne, int varTwo) {
        int result;
        result = varOne * varTwo;

        System.out.println("Multiplication Result: " + result);
    }

    // Subtraction example
    private static void Subtraction(int varOne, int varTwo) {
        int result;
        result = varOne - varTwo;

        System.out.println("Subtraction Result: " + result);
    }

    // Addition example
    private static void Addition(int varOne, int varTwo) {
        int result;
        result = varOne + varTwo;

        System.out.println("Addition Result: " + result);
    }

    public static void main(String[] args) {
        int varOne, varTwo, result;
        float floatOne, floatTwo;

        varOne = 1;
        varTwo = 2;

        Addition(varOne, varTwo);

        Subtraction(varOne, varTwo);

        Multiplication(varOne, varTwo);

        floatOne = varOne;
        floatTwo = varTwo;

        Division(floatOne, floatTwo);

        varOne = Increment(varOne);

        Decrement(varOne);
    }
}

