package com.bilgeadam.java.tutorials.collections.arrays_lists;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArraysAndLists {
    // Arrays are fixed size.
    private final Integer[] arrays;

    // Both ArrayList and LinkedList are extended from List Interface
    private final ArrayList<Integer> arrayList;
    private final LinkedList<Integer> linkedList;

    /**
     * Initializes Array, ArrayList and LinkedList
     * @param length for the array
     */
    public ArraysAndLists(int length) {
        arrays = new Integer[length];      // Length size is reserved (fixed size)
        arrayList = new ArrayList<>();     // 10 element reserved
        linkedList = new LinkedList<>();   // 0 element reserved
    }

    /**
     * Adds new element to the lists.
     * @param element Integer to be added.
     * @param index   Location for Array, List will append to the end.
     */
    public void addArrayElement(int element, int index){
        arrays[index] = element;
    }

    /**
     * Adds new element to the lists.
     * @param element Integer to be added.
     */
    public void addLinkedListElement(int element){
        linkedList.add(element);
    }
    /**
     * Adds new element to the lists.
     * @param element Integer to be added.
     */
    public void addArrayListElement(int element){
        arrayList.add(element);
    }

    /**
     * Removed the element from the list
     * @param element Element to be removed
     * @return Result
     */
    public boolean removeArrayList(int element){
        return arrayList.remove(Integer.valueOf(element));
    }

    /**
     * Removed the element from the list
     * @param element Element to be removed
     * @return Result
     */
    public boolean removeLinkList(int element){
        return linkedList.remove(Integer.valueOf(element));
    }
    /**
     * Removed the element from the list
     * @param index  to be removed
     * @return Result
     */
    public Integer removeArrayListIndex(int index){
        return arrayList.remove(index);
    }

    /**
     * Removed the element from the list
     * @param index  to be removed
     * @return Result
     */
    public Integer removeLinkListIndex(int index){
        return linkedList.remove(index);
    }

    /**
     * Getter method for array
     * @return Integer array
     */
    public Integer[] getArrays() {
        return arrays;
    }

    /**
     * Getter method for ArrayList
     * @return ArrayList
     */
    public ArrayList<Integer> getArrayList() {
        return arrayList;
    }

    /**
     * Getter method for LinkedList
     * @return LinkedList
     */
    public LinkedList<Integer> getLinkedList() {
        return linkedList;
    }
}
