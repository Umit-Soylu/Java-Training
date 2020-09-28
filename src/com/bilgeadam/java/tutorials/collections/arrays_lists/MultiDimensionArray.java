package com.bilgeadam.java.tutorials.collections.arrays_lists;

public class MultiDimensionArray {
    private final char[][][] charArray;

    public MultiDimensionArray(int dimOne, int dimTwo, int dimThree) {
        charArray = new char[dimOne][dimTwo][dimThree];
    }

    /**
     * Insert method for the array
     * @param dimOne   Index of first dimension
     * @param dimTwo   Index of second dimension
     * @param dimThree Index of third dimension
     * @param element  Element to be added
     */
    public void insertElement(int dimOne, int dimTwo, int dimThree, char element){
        charArray[dimOne][dimTwo][dimThree] = element;
    }

    /**
     * Getter method for Multi-Dimensional Array
     * @return multi-dimensional array
     */
    public char[][][] getCharArray() {
        return charArray;
    }

    @Override
    public String toString() {
        // Generate String representation of the array via String Builder
        StringBuilder myString = new StringBuilder();

        // Loop for all elements of the array.
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < charArray[0].length; j++) {
                for (int k = 0; k < charArray[0][0].length; k++) {
                    myString.append("Element[").append(i).append("]").
                            append("[").append(j).append("]").
                            append("[").append(k).append("] = ").
                            append(charArray[i][j][k]).
                            append(System.lineSeparator()); //Appends end-of-line based on OS type
                }
            }
        }

        return myString.toString();
    }
}
