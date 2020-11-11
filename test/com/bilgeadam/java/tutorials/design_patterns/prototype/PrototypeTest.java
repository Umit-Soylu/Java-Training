package com.bilgeadam.java.tutorials.design_patterns.prototype;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrototypeTest {
    Prototype testClass;
    @BeforeEach
    void setUp() {
        testClass = new Prototype();
    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    @Test
    void getCar() {
        Car c1, c2;
        c1 = testClass.getCar("Personnel");
        c2 = testClass.getCar("Personnel");
        assertNotEquals(c1, c2);
    }
}