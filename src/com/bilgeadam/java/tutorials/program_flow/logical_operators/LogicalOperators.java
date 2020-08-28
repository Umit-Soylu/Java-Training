package com.bilgeadam.java.tutorials.program_flow.logical_operators;

public class LogicalOperators {
    private static double varOne, varTwo;

    public static void main(String[] args) {
        varOne = Math.random();
        varTwo = Math.random();

        System.out.println("varOne is " + varOne + " and varTwo is " + varTwo);

        System.out.println("Logical And: " + ((varOne<varTwo) && (varTwo < 0.5)));
        System.out.println("Logical Or: " + ((varOne<varTwo) || (varTwo < 0.5)));
        System.out.println("Logical Not: " + !((varOne<varTwo) || (varTwo < 0.5)));
    }
}
