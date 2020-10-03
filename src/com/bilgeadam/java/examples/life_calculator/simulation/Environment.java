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
     * @param width  Latitude of the food
     * @param height Longitude of the food
     *
     * @throws IllegalArgumentException if no food exist in given location
     * @throws IndexOutOfBoundsException if given location does not reside in the environment borders
     */
    void consumeFood(Number width, Number height) throws IllegalArgumentException, IndexOutOfBoundsException;
}
