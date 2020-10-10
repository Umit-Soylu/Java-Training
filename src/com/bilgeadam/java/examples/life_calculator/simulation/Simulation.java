package com.bilgeadam.java.examples.life_calculator.simulation;

import com.bilgeadam.java.examples.life_calculator.creatures.Ant;
import com.bilgeadam.java.examples.life_calculator.creatures.Creature;
import com.bilgeadam.java.examples.life_calculator.creatures.FoodType;

import java.util.*;

public class Simulation implements Environment {
    // A set to store simulation environment values.
    private HashSet<Object>[][] simulationEnvironment;

    // A set of alive creatures
    private HashSet<? extends Creature> aliveCreatures;

    // Number of entities in the simulation.
    private int numberOfEntities;

    // Ratio of the foods in the environment
    private float foodRatio;

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

        //initializeFoods();

        initializeCreatures(getNumberOfEntities());
    }


    /**
     * A method to fill simulation with {@link Ant}
     *
     * @param size Total number of {@link Ant}
     */
    private void initializeCreatures(int size) {
        LinkedList<? super Creature> creatures = new LinkedList<>();
        Ant ant;

        while (creatures.size() < size) {
            // Creates an ant.
            ant = new Ant(getTurn(),
                    findRandomLocation(simulationEnvironment.length),
                    findRandomLocation(simulationEnvironment[0].length));

            // Add ant to the creatures list.
            creatures.add(ant);

            // Put ants name to simulation Environment
            simulationEnvironment[ant.getX()][ant.getY()].add(ant);
        }
    }

    /**
     * Initialize the simulation environment without any values within itself.
     *
     * @param length The max length of the simulation
     * @param width  The max width of the simulation
     */
    private void initializeEnvironment(int length, int width){
        simulationEnvironment = new HashSet[length][width];

        // Fill the whole array with empty linkedList
        for (int i = 0; i < simulationEnvironment.length; i++)
            for (int j = 0; j < simulationEnvironment[0].length; j++)
                simulationEnvironment[i][j] = new HashSet<>();
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

        return Collections.disjoint(simulationEnvironment[x][y], Arrays.asList(FoodType.values()))
                && simulationEnvironment[x][y].add(generateRandomEnum(FoodType.values()));
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
        if (getFoodTypeOrNull(x, y) != null) {
            simulationEnvironment[x][y].removeAll(Arrays.asList(FoodType.values()));
        } else
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

        for (HashSet<Object>[] s: simulationEnvironment){
            currentLine = new StringBuilder();
            for (HashSet<Object> elements: s) {
                currentLine.append(elements.isEmpty() ? empty : elements.toArray()[elements.size() - 1].toString()).append(" ");
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
        // Iterate over all simulation locations
        for (int i = 0; i < simulationEnvironment.length; i++)
            for (int j = 0; j < simulationEnvironment[0].length; j++) {
                List<Object> removable = new ArrayList<>();

                if (!simulationEnvironment[i][j].isEmpty()) {
                    // Iterate over all elements in current location
                    for (Object o : simulationEnvironment[i][j])
                        if (isCreatureInstance(o)) {
                            processCreatures((Creature) o);
                            removable.add(o);
                        }
                }

                // Remove all creatures from old location
                simulationEnvironment[i][j].removeAll(removable);
            }

        setTurn((short)(getTurn() + 1));
    }

    /**
     *
     * @param creature Creature to be investigated for given turn
     * @param <T> Type that extends {@link Creature}
     */
    private <T extends Creature> void processCreatures(T creature){
        // Check the state of creature
        if (creature.isAlive(getTurn())) {
            // Feed the creature if food exist
            FoodType food = getFoodTypeOrNull(creature.getX(), creature.getY());
            if (food != null)
                creature.eat(food, getTurn());

            // Move the creature to new location
            creature.move(simulationEnvironment.length, simulationEnvironment[0].length);

            // Store the creature to the simulation
            simulationEnvironment[creature.getX()][creature.getY()].add(creature);
        }
    }


    /**
     * Checks whether or not any food exist in given location
     *
     * @param x Location x
     * @param y Location y
     * @return {@link FoodType} if food exist in given location, null otherwise
     */
    private FoodType getFoodTypeOrNull(int x, int y){

        // Iterate over all elements in given location
        for (Object o : simulationEnvironment[x][y]) {
            if (o instanceof FoodType)
                return (FoodType) o;
        }
        // Means there is no food in given location
        return null;
    }

    /**
     * This class return a random element of any given Enum class.
     *
     * @param inputArray of an Enum class
     * @param <E> Type of the Enum class element
     * @return A random Element of {@param inputArray}.
     */
    private <E extends Enum<E>> Enum<E> generateRandomEnum(Enum<E>[] inputArray){
        return inputArray[(int) Math.round(Math.random() * (inputArray.length - 1))];
    }

    /**
     *
     * @param input type of input to be checked
     * @param <T> A generic type
     * @return true if it is type of a {@link Creature}
     */
    private <T> boolean isCreatureInstance(T input){
        return input instanceof Creature;
    }
}
