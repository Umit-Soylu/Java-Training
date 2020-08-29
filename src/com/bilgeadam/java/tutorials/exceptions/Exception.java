package com.bilgeadam.java.tutorials.exceptions;

public class Exception {

    /**
     * An example method for rounding the results.
     * @param x Divisor
     * @param y Dividend
     * @return Division (Rounded)
     */
    public int roundedDivision(int x, int y){
        return (int) Math.round((double) x / y);
    }

    /**
     * This method will result 2^32-1 or -2^32 based on the input. The exceptions will be handled within the method.
     * @param x Divisor
     * @param y Dividend
     * @return Division
     */
    public double division (int x, int y){
        double z;

        try{
            z = (double) x / y;
        } catch (ArithmeticException e){
            if (x > 0 && y > 0)
                z = Integer.MAX_VALUE;
            else
                z = Integer.MIN_VALUE;
        }
        return z;
    }

    /**
     * This method will result 2^32-1 or -2^32 based on te input. The exceptions will be handled within the method.
     * @param x Operand-1
     * @param y Operand-2
     * @return Result (may cast to max/min int value)
     */
    public int addition (int x, int y){
        int z;

        try{
            z = Math.addExact(x ,y);
        } catch (ArithmeticException e){
            if (x > 0 && y > 0)
                z = Integer.MAX_VALUE;
            else
                z = Integer.MIN_VALUE;
        }
        return z;
    }

    /**
     * This method throws an exception and executed finally blog regardless.
     */
    public int finallyExample(){
        try {
            // Throws an exception
            throw new java.lang.Exception("Demo exception");
        } catch (java.lang.Exception e) {
            // Catches the exception but does nothing.
            return 1;
        } finally{
            return 0;
        }

    }
}
