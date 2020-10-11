package com.bilgeadam.java.tutorials.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
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
     * @param employees Where the new employees wıll be stored
     */
    public void generateEmployees(List<Employee> employees){
//        for (Integer i : integerList) {
//            Employee e = new Employee(i);
//            employees.add(e);
//        }

        integerList.forEach(e -> employees.add(new Employee(e)));
    }


    /**
     * Creates employees where {@code Employee#id} is bigger than lowerBoundary
     * @param employees
     * @param lowerBoundary
     */
    public void generateCustomEmployees(List<Employee> employees, int lowerBoundary, int upperBoundary){
//        integerList.forEach(e -> {
//            if(e > lowerBoundary)
//                employees.add(new Employee(e));
//        });
//
        integerList.stream().                                   // Creates stream
                filter(e -> e > lowerBoundary).                 // Intermediate operation
                filter(e -> e < upperBoundary).                 // Intermediate operation
                forEach(e -> employees.add(new Employee(e)));  // Terminate operation (calls only once)
    }

    /**
     * Generates and return empty firstname size
     *
     * @param employees  Employee list to be filled
     * @return Number of employees with empty names
     */
    public long countEmployees(List<Employee> employees){
        generateEmployees(employees);

        return employees.stream().
                filter(e -> e.getFirstName().isEmpty()).
                count();
    }

    /**
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
     * @param start   Start value
     * @param finish  End value (not included)
     * @return Array of integers
     */
    public int[] generateIntegerArray(int start, int finish){
        return IntStream.range(start, finish).toArray();
    }

    public Set collectElements(){
        List<Employee> employees = new ArrayList<>();
        generateEmployees(employees);

        Set<Employee> employeeSet =
                employees.stream().
                filter(e -> e.getFirstName().isEmpty()).
                collect(Collectors.toSet());

        return employeeSet;
    }
}
