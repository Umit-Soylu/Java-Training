package com.bilgeadam.java.examples.life_calculator.creatures;

import java.util.List;

/**
 * An organism is a generic type defines organism lives within the simulation
 */
public interface Organism {

    /**
     * This method allow organism to consume food
     */
    void eat(String foodType, Number currentDay);

    /**
     * This method allow organism to move into another location
     */
    void move(Number borderWidth, Number borderHeight);

    /**
     * This method allows an organism to copulate with another organism.
     *
     * @param o The mate current organism copulates
     * @return The list of children resulting current copulation.
     */
    List copulate(Object o);

}
