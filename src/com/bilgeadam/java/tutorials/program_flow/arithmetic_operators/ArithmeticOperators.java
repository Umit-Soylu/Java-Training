package com.bilgeadam.java.tutorials.program_flow.arithmetic_operators;

public class ArithmeticOperators {

    public static void main(String[] args) {
        int varOne, varTwo, result;

        varOne = 1;
        varTwo = 2;

        // Addition example
        result = varOne + varTwo;
        System.out.println("Addition Result: " + result);

        // Subtraction example
        result = varOne - varTwo;
        System.out.println("Subtraction Result: " + result);

        // Multiplication example
        result = varOne * varTwo;
        System.out.println("Multiplication Result: " + result);

        // Division example
        float floatOne, floatTwo, localResult;
        floatOne = varOne;
        floatTwo = varTwo;
        // localResult =  varOne / varTwo; // 0.0
        // localResult = (float) varOne / varTwo; // 0.5
        // result = (float) varOne / varTwo; // Casting error
        localResult = floatOne / floatTwo; // 0.5
        System.out.println("Division Result: " + localResult);

        // Increment example
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

        // Decrement example
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
}

