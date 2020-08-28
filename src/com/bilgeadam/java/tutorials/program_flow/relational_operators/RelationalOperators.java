package com.bilgeadam.java.tutorials.program_flow.relational_operators;

public class RelationalOperators {

    private static double varOne, varTwo;

    public static void main(String[] args) {
        varOne = Math.random();
        varTwo = Math.random();

        System.out.println("varOne is " + varOne + " and varTwo is " + varTwo);

        System.out.println("Is greater : " + (varOne > varTwo));
        System.out.println("Is less than : " + (varOne < varTwo));
        System.out.println("Is equal  : " + (varOne == varTwo));
        System.out.println("Is not equal  : " + (varOne != varTwo));
        System.out.println("Is greater than or equal : " + (varOne >= varTwo));
        System.out.println("Is less than or equal : " + (varOne <= varTwo));

    }
}
