package com.bilgeadam.java.tutorials.streams;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamsTest {
    Streams testClass;
    @BeforeEach
    void setUp() {
        testClass = new Streams();
    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    @Test
    void printListElements() {
        testClass.printListElements();
    }

    @Test
    void generateEmployees() {
        List<Employee> testList = new ArrayList<>();

        testClass.generateEmployees(testList);
        assertEquals(6, testList.size());
    }

    @Test
    void generateCustomEmployees() {
        List<Employee> testList = new ArrayList<>();

        testClass.generateCustomEmployees(testList, 500, 1_000_000);
        assertEquals(2, testList.size());
    }

    @Test
    void countEmployees() {
        assertEquals(6, testClass.countEmployees(new ArrayList<>()));
    }

    @Test
    void generateLimitedEmployees() {
        List<Employee> testList = new ArrayList<>();
        int limit = 3;
        testClass.generateLimitedEmployees(testList, limit);

        assertEquals(Math.min(6, limit), testList.size());
    }

    @Test
    void generateIntegerArray() {
        assertEquals(1_000_000, testClass.generateIntegerArray(0,1_000_000).length);

    }

    @Test
    void handGeneratedList(){
        int[] array = new int[1_000_000];
        for (int i = 0; i < 1_000_000; i++) {
            array[i] = i;
        }
    }

    @Test
    void collectElements() {
        // Following is a simple case to show where sets are distinguished only be Employee's Id
        Set<Employee> test = new HashSet<>();
        test.add(new Employee(1000));
        test.add(new Employee(1000));
        assertEquals(1, test.size());

        // Implementation used with streams
        assertEquals(3, testClass.collectElements().size());
    }
}