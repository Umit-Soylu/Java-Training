package com.bilgeadam.java.examples.life_calculator.simulation;

import java.util.Arrays;
import java.util.Random;

public class Simulation implements Environment {
    private static final String food = "Food ";

    // An array to store simulation environment values.
    private String[][] simulationEnvironment;

    // Number of entities in the simulation.
    private int numberOfEntities;

    // Ratio of the foods in the environment
    private float foodRatio;

    /**
     * Constructor
     * @param length           The max length of the simulation
     * @param width            The max width of the simulation
     * @param numberOfEntities The number of entities for the simulation initial phase
     * @param foodRatio        The food ratio in the simulation
     */
    public Simulation(int length, int width, int numberOfEntities, float foodRatio){
        initializeEnvironment(length, width);

        setNumberOfEntities(numberOfEntities);

        setFoodRatio(foodRatio);

        initializeFoods();
    }

    /**
     * Initialize the simulation environment without any values within itself.
     *
     * @param length The max length of the simulation
     * @param width  The max width of the simulation
     */
    private void initializeEnvironment(int length, int width){
        simulationEnvironment = new String[length][width];

        // Fill the whole array as 'Empty'
        for (int i = 0; i < simulationEnvironment.length; i++)
            Arrays.fill(simulationEnvironment[i], "Empty");
    }

    /**
     * Fills the simulation environment according to the initialized food ratio
     */
    private void initializeFoods(){
        // Calculate the total number of foods needed.
        int remainingFoods = Math.round(simulationEnvironment.length * simulationEnvironment[0].length * foodRatio);

        // Fill the environment with foods
        while (remainingFoods > 0){
            if (generateFood())
                remainingFoods--;
        }
    }

    /**
     * This method adds food to the environment using {@link Random} approach.
     *
     * @return true if successfully added food; false otherwise
     */
    @Override
    public boolean generateFood() {
        int x = (int) Math.floor(Math.random() * (simulationEnvironment.length - 1)),
                y = (int) Math.floor(Math.random() * (simulationEnvironment[0].length - 1));

        if (!(simulationEnvironment[x][y]).equalsIgnoreCase(food)){
            simulationEnvironment[x][y] = food;
            return true;
        } else
            return false;
    }

    /**
     * This method consumes the food in the given location.
     *
     * @param width  Latitude of the food
     * @param height Longitude of the food
     *
     * @throws IllegalArgumentException  if no food exist in given location
     * @throws IndexOutOfBoundsException if given location does not reside in the environment borders
     */
    @Override
    public void consumeFood(Number width, Number height) throws IllegalArgumentException, IndexOutOfBoundsException {
        int x = (int) width, y = (int) height;

        // Check if dimensions are within the simulation borders
        if (x >= simulationEnvironment.length || y >= simulationEnvironment[0].length)
            throw new IndexOutOfBoundsException("The given dimensions x:" + x + " y:" + y + " are out of the simulation borders");

        // Remove food if exists, throw exception otherwise.
        if ((simulationEnvironment[x][y]).equalsIgnoreCase(food))
            simulationEnvironment[x][y] = "Empty";
        else
            throw new IllegalArgumentException("Current location does not have food in it");
    }

    /**
     *
     * @param numberOfEntities The number of creatures to be set
     */
    private void setNumberOfEntities(int numberOfEntities) {
        // Check given entity size is a positive value
        if (numberOfEntities < 0)
            throw new IllegalArgumentException("Number of creatures cannot be negative");
        // Check given entity size is less than the capacity
        if (numberOfEntities > simulationEnvironment.length * simulationEnvironment[0].length)
            throw new IllegalArgumentException("Number of creatures cannot exceed simulation capacity");

        this.numberOfEntities = numberOfEntities;
    }

    /**
     * This method accepts food ration in between 0.0 .. 1.0
     *
     * @param foodRatio The ratio of food in the environment
     */
    private void setFoodRatio(float foodRatio){
        if (foodRatio < 0.0)
            throw new IllegalArgumentException("Food ratio cannot be negative");

        if (foodRatio > 1.0)
            throw new IllegalArgumentException("Food ratio cannot exceed 1.0");

        this.foodRatio = foodRatio;
    }
    /**
     * This method prints all the entities in the simulation
     */
    public void display(){
        StringBuilder currentLine;

        for (String[] s: simulationEnvironment){
            currentLine = new StringBuilder();
            for (String element: s) {
                currentLine.append(element).append(" ");
            }

            System.out.println(currentLine.toString());
        }
    }
}
