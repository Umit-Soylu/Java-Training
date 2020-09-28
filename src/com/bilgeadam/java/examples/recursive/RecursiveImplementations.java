package com.bilgeadam.java.examples.recursive;

public class RecursiveImplementations {
    /**
     * This method calls {@code methodB} within itself
     */
    public int methodA(){
        // Method specific variable
        int i = 5;

        // Call another method, the other method cannot see variable 'i'
        methodB();

        return i;
    }

    /**
     * This method cannot see the variables stored in {@code methodA}
     */
    private void methodB(){
        int j = 3;
        System.out.println("Local variable j = " + j);
    }

    /**
     * Calculates the factorial of given number
     *
     * @param i The value to be calculated
     * @return the factorial result
     */
    public int factorial(int i){
        return (i == 1) ? i : i * factorial(i-1);
    }
}
