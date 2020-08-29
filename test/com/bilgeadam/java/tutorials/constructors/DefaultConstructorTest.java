package com.bilgeadam.java.tutorials.constructors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

class DefaultConstructorTest {

    // This test will use default constructor
    @Test
    public void testOne(){
        // The following constructor is created by java automatically.
        DefaultConstructor testObject = new DefaultConstructor();

        assertNull(testObject.getMyName());
    }
}