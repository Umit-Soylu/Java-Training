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
        arrayList = new ArrayList();     // 10 element reserved
        linkedList = new LinkedList();   // 0 element reserved
    }

    /**
     * Adds new element to the lists.
     * @param element  Integer to be added.
     * @param index    Location for Array, List will append to the end.
     */
    public void addArrayElement(int element, int index){
        arrays[index] = element;
    }

    /**
     * Adds new element to the lists.
     * @param element       Integer to be added.
     */
    public void addLinkedListElement(int element){
        linkedList.add(element);
    }
    /**
     * Adds new element to the lists.
     * @param element       Integer to be added.
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
    public Object removeArrayListIndex(int index){
        return arrayList.remove(index);
    }

    /**
     * Removed the element from the list
     * @param index  to be removed
     * @return Result
     */
    public Object removeLinkListIndex(int index){
        return linkedList.remove(index);
    }
    public Integer[] getArrays() {
        return arrays;
    }

    public List getArrayList() {
        return arrayList;
    }

    public List getLinkedList() {
        return linkedList;
    }
}
