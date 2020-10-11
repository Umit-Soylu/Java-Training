package com.bilgeadam.java.tutorials.streams;

import java.util.*;
import java.util.stream.IntStream;

public class Streams {
    List<Integer> integerList;

    /**
     * This constructor method creates a custom integer list
     */
    public Streams(){
        integerList = new ArrayList<>(Arrays.asList(1, 1000, 1000, 1000, 1000, 2_000_000));
    }

    /**
     * Prints the elements of the integer list
     */
    public void printListElements(){
        //for (Integer i : integerList)
        //    System.out.println("i = " + i);

        integerList.forEach(e -> System.out.println("e = " + e));
    }

    /**
     * Creates employees according to integer list
     *
     * @param employees Where the new employees will be stored
     */
    public void generateEmployees(List<Employee> employees){
//        for (Integer i : integerList) {
//            Employee e = new Employee(i);
//            employees.add(e);
//        }

        integerList.forEach(e -> employees.add(new Employee(e)));
    }


    /**
     * Creates employees, using {@link #integerList}, where;
     * <ul>
     *     <li> {@code Employee#id} > {@code lowerBoundary} </li>
     *     <li> {@code Employee#id} < {@code upperBoundary} </li>
     * </ul>
     * @param employees     Where the new employees will be stored
     * @param lowerBoundary Lower limit used with {@link #integerList}
     * @param upperBoundary Upper limit used with {@link #integerList}.
     */
    public void generateCustomEmployees(List<Employee> employees, int lowerBoundary, int upperBoundary){
//        integerList.forEach(e -> {
//            if(e > lowerBoundary)
//                employees.add(new Employee(e));
//        });

        integerList.stream().                                 // Creates a stream from the current list
                filter(e -> e > lowerBoundary).               // Intermediate operation
                filter(e -> e < upperBoundary).               // Intermediate operation
                forEach(e -> employees.add(new Employee(e))); // Terminate operation (Can only be called once)
    }

    /**
     * Generates and return empty firstname size
     *
     * @param employees  Employee list to be filled
     * @return Number of employees with empty names {@link Employee#getFirstName()} == {@code null}
     */
    public long countEmployees(List<Employee> employees){
        generateEmployees(employees);

        return employees.stream().
                filter(e -> e.getFirstName().isEmpty()).
                count();
    }

    /**
     * Generates an employee list with a maximum {@code limit}
     *
     * @param employees  Employee list to be filled
     * @param limit      total size of Employees to be created
     */
    public void generateLimitedEmployees(List<Employee> employees, int limit){
        integerList.stream().
                limit(limit).
                forEach(e -> employees.add(new Employee(e)));

    }

    /**
     * Generate an array of integers
     *
     * @param start   Start value
     * @param finish  End value (not included)
     * @return Array of integers
     */
    public int[] generateIntegerArray(int start, int finish){
        return IntStream.range(start, finish).toArray();
    }

    /**
     * Generate a set of {@link Employee} consists of unique {@link Employee#getId()}
     *
     * @return Set of {@link Employee}
     */
    public Set<Employee> collectElements(){
        List<Employee> employees = new ArrayList<>();
        generateEmployees(employees);
        Set<Employee> res = new HashSet<>();

        employees.stream().
                filter(e -> e.getFirstName().isEmpty()).
                forEach(res::add); //Used method reference to be called for each element

        return res;
    }
}
