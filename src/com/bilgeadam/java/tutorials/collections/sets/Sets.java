package com.bilgeadam.java.tutorials.collections.sets;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Sets {
    TreeSet<String> treeSet;
    HashSet<String> hashSet;


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
     * Intersects current sets with the given {@code input} and modify lists to preserve only with intersecting elements
     * @param input The other set to be intersected
     */
    public void findIntersection(List<String> input){
         hashSet.retainAll(input);
         treeSet.retainAll(input);
    }
    /**
     * Remove given {@code element} from both Sets
     * @param element New element
     */
    public void removeElements(String element){
        hashSet.remove(element);
        treeSet.remove(element);
    }

    /**
     *
     * @return Array representation the HashSet
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
