package com.bilgeadam.java.examples.life_calculator.simulation;

import com.bilgeadam.java.examples.life_calculator.creatures.Ant;
import com.bilgeadam.java.examples.life_calculator.creatures.FoodType;

import java.util.*;

public class Simulation implements Environment {
    // An array to store simulation environment values.
    private String[][] simulationEnvironment;

    // Number of entities in the simulation.
    private int numberOfEntities;

    // Ratio of the foods in the environment
    private float foodRatio;

    // Stores the creatures in the environment
    private LinkedList<Ant> creatures;

    // Stores the current turn.
    private short turn;

    // A display value if nothing exists
    private static final String empty = "Barren    ";

    /**
     * Constructor
     * @param length           The max length of the simulation
     * @param width            The max width of the simulation
     * @param numberOfEntities The number of entities for the simulation initial phase
     * @param foodRatio        The food ratio in the simulation
     */
    public Simulation(int length, int width, int numberOfEntities, float foodRatio){
        setTurn((short) 0);

        initializeEnvironment(length, width);

        setNumberOfEntities(numberOfEntities);

        setFoodRatio(foodRatio);

        initializeFoods();

        initializeCreatures(getNumberOfEntities());
    }


    /**
     *
     * @param size Total number of entities
     */
    private void initializeCreatures(int size) {
        creatures = new LinkedList<Ant>();
        Ant ant;

        while (creatures.size() < size) {
            // Creates an ant.
            ant = new Ant(getTurn(),
                    findRandomLocation(simulationEnvironment.length),
                    findRandomLocation(simulationEnvironment[0].length));

            // Add ant to the creatures list.
            creatures.add(ant);

            // Put ants name to simulationEnv
            simulationEnvironment[ant.getX()][ant.getY()] = ant.toString();
        }

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
            Arrays.fill(simulationEnvironment[i], empty);
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
        int x = findRandomLocation(simulationEnvironment.length),
                y = findRandomLocation(simulationEnvironment[0].length);

        if(Arrays.stream(FoodType.values()).noneMatch((f) -> f.toString().equals(simulationEnvironment[x][y]))){
            simulationEnvironment[x][y] = FoodType.values()[(int) Math.round(Math.random() * (FoodType.values().length - 1))].toString();
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
        if (isFoodExist(x, y))
            simulationEnvironment[x][y] = empty;
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

    public int getNumberOfEntities() {
        return numberOfEntities;
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
     * Returns the turn of the simulation
     *
     * @return current turn
     */
    public short getTurn() {
        return turn;
    }

    /**
     * Sets the Turn of the simulation
     *
     * @param turn current turn
     */
    private void setTurn(short turn) {
        if (turn >= 0)
            this.turn = turn;
        else
            throw new IllegalArgumentException("Turn cannot be negative.");

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

    /**
     * Generates a {@code Math.random} value within the {@code limit} of the border
     *
     * @param limit Border of the simulation
     * @return A random value within the limits
     */
    private int findRandomLocation(int limit){
        return (int) Math.floor(Math.random() * (limit - 1));
    }

    /**
     * This method handles the result of current turn and proceeds to next turn
     */
    public void endTurn(){
        ListIterator<Ant> it = creatures.listIterator();
        List<Ant> willRemoved = new ArrayList<>();

        while (it.hasNext()) {
            Ant a = it.next();
            // Remove thee creature from the simulation
            simulationEnvironment[a.getX()][a.getY()] = empty;

            if (a.isAlive()) {
                // Feed the creature if food exist
                if (isFoodExist(a.getX(), a.getY()))
                    a.eat(FoodType.valueOf(simulationEnvironment[a.getX()][a.getY()]), getTurn());

                // Move the creature to new location
                a.move(simulationEnvironment.length, simulationEnvironment[0].length);

                // Store the creature to the simulation
                simulationEnvironment[a.getX()][a.getY()] = a.toString();
            } else
                willRemoved.add(a);
        }

        creatures.removeAll(willRemoved);

        setTurn((short)(getTurn() + 1));
    }

    private boolean isFoodExist(int x, int y){
        return Arrays.stream(FoodType.values()).anyMatch((f) -> f.toString().equals(simulationEnvironment[x][y]));
    }
}
