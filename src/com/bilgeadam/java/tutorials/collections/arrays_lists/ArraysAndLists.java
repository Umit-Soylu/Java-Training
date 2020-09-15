package com.bilgeadam.java.tutorials.collections.arrays_lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArraysAndLists {
    // Arrays are fixed size.
    private final Integer[] arrays;

    // Both ArrayList and LinkedList are extended from List Interface
    private final List arrayList;
    private final List linkedList;

    /**
     * Initializes Array, ArrayList and LinkedList
     * @param length for the array
     */
    public ArraysAndLists(int length) {
        arrays = new Integer[length];
        arrayList = new ArrayList();
        linkedList = new LinkedList();
    }

    /**
     * Adds new element to the lists.
     * @param element       Integer to be added.
     * @param arrayLocation Location for Array, List will append to the end.
     */
    public void addElement(int element, int arrayLocation){
        arrays[arrayLocation] = element;

        arrayList.add(element);
        linkedList.add(element);
    }
}
