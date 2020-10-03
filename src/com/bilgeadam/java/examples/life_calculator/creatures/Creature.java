package com.bilgeadam.java.examples.life_calculator.creatures;

import java.util.List;

public abstract class Creature implements Organism{
    // The birthday, death and life expectancy of the creature
    private Short lifeExpectancy, birthday, death;

    // Location of the creature
    private Integer x, y;

    // Last day create eat food
    private Integer lastMealDay;

    // The gender of the creature
    private Gender sex;

    /**
     * The initialization of the creature
     *
     * @param lifeExpectancy Life expectancy of the creature
     * @param birthday       Birthday of the creature
     * @param x              Current x location of the creature
     * @param y              Current x location of the creature
     */
    public Creature(short lifeExpectancy, short birthday, int x, int y) {
        setLifeExpectancy(lifeExpectancy);
        setBirthday(birthday);
        setX(x);
        setY(y);
        setGender();
        // The last day should be the birthday for initialization
        setLastMealDay(getBirthday());
    }

    /**
     * This method allow us to assign a gender using {@code Math.random} approach.
     * <p>
     * Assigns {@link Gender} to current creature.
     * </p>
     */
    private void setGender(){
        this.sex = Gender.values()[(int) Math.round(Math.random() * (Gender.values().length - 1))];
    }

    /**
     * Sets the life expectancy of the current creature
     *
     * @param lifeExpectancy A positive value
     */
    public void setLifeExpectancy(short lifeExpectancy) {
        if (lifeExpectancy > 0)
            this.lifeExpectancy = lifeExpectancy;
        else
            throw new IllegalArgumentException("Life expectancy should be positive");
    }

    /**
     * Birthday of the creature
     *
     * @param birthday A positive value
     */
    public void setBirthday(short birthday) {
        if (birthday > 0)
            this.birthday = birthday;
        else
            throw new IllegalArgumentException("Birthday should be positive");
    }

    public short getBirthday() {
        return birthday;
    }

    public void setDeath(short death) {
        if (death > getBirthday())
            this.death = death;
        else
            throw new IllegalArgumentException("Death should be later than birthday");
    }

    public short getDeath() {
        return death;
    }

    /**
     *
     * @param lastMealDay The last day a meal is eaten.
     */
    public void setLastMealDay(int lastMealDay) {
        if (lastMealDay >= getBirthday())
            this.lastMealDay = lastMealDay;
        else
            throw new IllegalArgumentException("Last meal day should be later than or equal to birthday");
    }

    public int getLastMealDay() {
        return lastMealDay;
    }


    /**
     * Initial x position of creature
     * @param x Position X
     */
    private void setX(int x) {
        this.x = x;
    }

    /**
     * Moves the creature in X dimension
     *
     * @param stepX       The current step for X position
     * @param borderWidth Simulation border of width
     */
    private void setX(int stepX, int borderWidth) {
        int newPosition = getX() + stepX;

        if (newPosition < 0) // Check for leftMost index
            newPosition = borderWidth - 1;
        else if (newPosition >= borderWidth) // Check for rightMost index
            newPosition = 0;

        setX(newPosition);
    }

    public Integer getX() {
        return x;
    }

    /**
     * Initial y position of creature
     * @param y Position y
     */
    private void setY(int y) {
        this.y = y;
    }

    /**
     * Moves the creature in Y dimension
     *
     * @param stepY        The current step for Y position
     * @param borderHeight Simulation border of width
     */
    private void setY(int stepY, int borderHeight) {
        int newPosition = getY() + stepY;

        if (newPosition < 0) // Check for leftMost index
            newPosition = borderHeight - 1;
        else if (newPosition >= borderHeight) // Check for rightMost index
            newPosition = 0;

        setY(newPosition);
    }

    public Integer getY() {
        return y;
    }

    public Short getLifeExpectancy() {
        return lifeExpectancy;
    }

    protected Gender getSex() {
        return sex;
    }

    /**
     * This method allow organism to consume food
     */
    @Override
    public void eat(String foodType, Number currentDay) {
        if (foodType != null && currentDay != null)
            setLastMealDay((Integer) currentDay);

    }

    /**
     * This method allow organism to move into another location
     */
    @Override
    public void move(Number borderWidth, Number borderHeight) {
        setX((int) (Math.round(Math.random() * 2) - 1), (int) borderHeight);
        setY((int) (Math.round(Math.random() * 2) - 1), (int) borderWidth);
    }

    /**
     * This method allows an organism to copulate with another organism.
     *
     * @param o The mate current organism copulates
     * @return The list of children resulting current copulation.
     */
    @Override
    public List<? extends Creature> copulate(Object o) {
        int childSize = ((o instanceof Creature) && isCompatible((Creature) o)) ? (int) Math.round(Math.random() * getMaximumChildSize()) : 0;

        return generateChild(childSize);
    }

    /**
     * Generate children according to given criteria
     *
     * @param size total size of children to be born
     * @return List of children
     */
    protected abstract List<? extends Creature> generateChild(int size);

    /**
     *
     * @return The maximum number of children can ber produced only in one mating
     */
    protected abstract int getMaximumChildSize();

    /**
     * This method decided whether or not given creatures can copulate
     * @param c The candidate mate
     * @return true if they can copulate, false otherwise
     */
    protected abstract boolean isCompatible(Creature c);


}
