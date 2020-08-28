package com.bilgeadam.java.tutorials.constructors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ConstructorDemoTest {

    // This test will use default constructor
    @Test
    public void testOne(){
        ConstructorDemo testObject = new ConstructorDemo();

        assertNull(testObject.getName());
    }

    // This test will use constructor with String input
    @Test
    public void testTwo(){
        String name = "Learning Java";
        ConstructorDemo testObject = new ConstructorDemo(name);

        assertEquals(name, testObject.getName());
    }

    // This test will use constructor with String and boolean input
    @Test
    public void testThree(){
        String name = "Learning Java";
        ConstructorDemo testObject = new ConstructorDemo(name, true);

        assertEquals(name, testObject.getName());
    }

    // This test will use constructor with String and boolean input
    @Test
    public void testFour(){
        String name = "Learning Java";
        ConstructorDemo testObject = new ConstructorDemo(name, false);

        assertEquals("Invalid Name", testObject.getName());
    }
}