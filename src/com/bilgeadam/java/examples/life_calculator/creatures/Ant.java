package com.bilgeadam.java.examples.life_calculator.creatures;

import java.util.ArrayList;
import java.util.List;

public class Ant extends Creature{
    private static final int maxChildrenCount = 4;

    public Ant(short lifeExpectancy, short birthday, int x, int y) {
        super(lifeExpectancy, birthday, x, y);
    }

    /**
     * Generate children according to given criteria
     *
     * @param size total size of children to be born
     * @return List of children
     */
    @Override
    protected List<Ant> generateChild(int size) {
        if (size == 0)
            return null;
        else {
            List<Ant> children = new ArrayList<>(size);

            while (size > 0) {
                children.add(new Ant((short) 10, (short) 1, getX(), getY()));
                size--;
            }

            return children;
        }
    }

    /**
     * @return The maximum number of children can ber produced only in one mating
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
}
