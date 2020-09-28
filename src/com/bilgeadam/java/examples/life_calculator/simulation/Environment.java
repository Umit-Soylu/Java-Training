package com.bilgeadam.java.examples.life_calculator.simulation;

import java.util.Random;

public interface Environment {

    /**
     * This method adds food to the environment using {@link Random} approach.
     *
     * @return true if successfully added food; false otherwise
     */
    boolean generateFood();

    /**
     * This method consumes the food in the given location.
     *
     * @param latitude  Latitude of the food
     * @param longitude Longitude of the food
     *
     * @throws IllegalArgumentException if no food exist in given location
     * @throws IndexOutOfBoundsException if given location does not reside in the environment borders
     */
    void consumeFood(Number latitude, Number longitude) throws IllegalArgumentException, IndexOutOfBoundsException;
}
