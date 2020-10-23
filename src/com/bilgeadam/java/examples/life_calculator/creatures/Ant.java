package com.bilgeadam.java.examples.life_calculator.creatures;

import java.util.ArrayList;

public class Ant extends Creature{
    private static final int maxChildrenCount = 4;
    private static final short lifeExpectancy = 5;

    // This is the total number ants that is created
    private static int index;

    private static final int maxStringSize = 10;

    // Id of the current ant
    private final int id;

    public Ant(short birthday, int x, int y) {
        super(lifeExpectancy, birthday, x, y);
        id = index++;
    }

    /**
     * Generate children according to given criteria
     *
     * @param size total size of children to be born
     * @return List of children
     */
    @Override
    protected ArrayList<Ant> generateChild(int size) {
        if (size == 0)
            return null;
        else {
            ArrayList<Ant> children = new ArrayList<>(size);

            while (size > 0) {
                children.add(new Ant((short) 1, getX(), getY()));
                size--;
            }

            //System.out.println("Creature = " + toString() + " children" + children.size());
            return children;
        }
    }

    /**
     * @return The maximum number of children can be produced only in one mating
     */
    @Override
    protected int getMaximumChildSize() {
        return maxChildrenCount;
    }

    /**
     * This method decided whether or not given creatures can copulate
     *
     * @param c The candidate mate
     * @return true if they can copulate, false otherwise
     */
    @Override
    protected boolean isCompatible(Creature c) {
        return (c instanceof Ant && getSex() == Gender.Female && c.getSex() == Gender.Male);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Ant-" + id);

        while (s.length() < maxStringSize)
            s.append(" ");

        return s.toString();
    }
}
