package com.bilgeadam.java.tutorials.collections.sets;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets {
    Set<String> treeSet;
    Set<String> hashSet;

    public Sets() {
        hashSet = new HashSet<>();
        treeSet = new TreeSet<>();
    }

    /**
     * Add given element to both Sets
     * @param element New element
     */
    public void addElements(String element){
        hashSet.add(element);
        treeSet.add(element);
    }

    /**
     * Intersects current sets with the given {@param input}
     * @param input The other set to be intersected
     */
    public void findIntersection(Collection input){
         hashSet.retainAll(input);
         treeSet.retainAll(input);
    }
    /**
     * Add given element to both Sets
     * @param element New element
     */
    public void removeElements(String element){
        hashSet.remove(element);
        treeSet.remove(element);
    }

    /**
     *
     * @return Array of my Set
     */
    public Object[] convertArray(){
        return hashSet.toArray();
    }

    /**
     * Print current size of array
     */
    public void printInfo(){
        System.out.println("treeSet.size = " + treeSet.size());
        System.out.println("hashSet.size = " + hashSet.size());
    }
    public Set<String> getTreeSet() {
        return treeSet;
    }

    public Set<String> getHashSet() {
        return hashSet;
    }
}
