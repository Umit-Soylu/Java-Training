package com.bilgeadam.java.tutorials.threads.vectors;

import java.util.Vector;

public class SharedVector {

    private final Vector<Integer> integerVector = new Vector<>();

    /**
     * Adds new element to the vector
     * @param i new element
     */
    public void addToVector(int i){
        integerVector.add(i);
    }

    /**
     * Prints vector
     */
    public void printVector(){
        integerVector.forEach(System.out::println);
    }

    /**
     *
     * @return Size of the vector
     */
    public int getVectorSize(){
        return integerVector.size();
    }
}
