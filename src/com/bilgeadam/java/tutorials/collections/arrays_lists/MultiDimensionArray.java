package com.bilgeadam.java.tutorials.collections.arrays_lists;

public class MultiDimensionArray {
    private final char[][][] charArray;

    public MultiDimensionArray(int dimOne, int dimTwo, int dimThree) {
        charArray = new char[dimOne][dimTwo][dimThree];
    }

    public void insertElement(int dimOne, int dimTwo, int dimThree, char element){
        charArray[dimOne][dimTwo][dimThree] = element;
    }

    public char[][][] getCharArray() {
        return charArray;
    }

    @Override
    public String toString() {
        StringBuilder myString = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < charArray[0].length; j++) {
                for (int k = 0; k < charArray[0][0].length; k++) {
                    myString.append("Element[").append(i).append("]").
                            append("[").append(j).append("]").
                            append("[").append(k).append("] = ").
                            append(charArray[i][j][k]).append(System.getProperty("line.separator"));
                }
            }
        }
        return myString.toString();
    }
}
