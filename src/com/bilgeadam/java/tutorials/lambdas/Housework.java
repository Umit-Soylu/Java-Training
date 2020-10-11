package com.bilgeadam.java.tutorials.lambdas;

@FunctionalInterface
public interface Housework {
    int nbOfJobs = 0; // A public static final variable

    void doHousework(); // A method with no parameters as input

}
