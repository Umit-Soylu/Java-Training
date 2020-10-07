package com.bilgeadam.java.examples.life_calculator.creatures;

public enum FoodType {
    Spoiled(1),
    Vegetable(2),
    Meat(3);

    // This value is used when converting to string
    private final static int maxStringLength = 10;

    // Nutritional value of the given food
    private final int nutritionValue;

    /**
     * A private constructor for {@link FoodType}
     *
     * @param nutritionValue to assign given food
     */
    FoodType(int nutritionValue) {
        this.nutritionValue = nutritionValue;
    }

    /**
     *
     * @return Nutritional value of the food
     */
    public int getNutritionValue() {
        return nutritionValue;
    }


    /**
     * Returns the name of this enum constant, as contained in the
     * declaration.  This method may be overridden, though it typically
     * isn't necessary or desirable.  An enum type should override this
     * method when a more "programmer-friendly" string form exists.
     *
     * @return the name of this enum constant limited by {@code maxStringLength}
     */
    @Override
    public String toString() {
        // Append spaces if current string value is less than desired value
        if (super.toString().length() < maxStringLength) {
            StringBuilder s =  new StringBuilder(super.toString());
            while (s.length() < maxStringLength)
                s.append(" ");
            return s.toString();
        } else // Concat exceeding values
            return super.toString().substring(0, maxStringLength);
    }
}
