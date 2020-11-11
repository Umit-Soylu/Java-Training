package com.bilgeadam.java.tutorials.design_patterns.builder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HamburgerBuilderTest {
    HamburgerBuilder testClass;

    Food food;
    @BeforeEach
    void setUp() {
        testClass = new HamburgerBuilder();
    }

    @AfterEach
    void tearDown() {
        testClass = null;
        food = null;
    }

    @Test
    void hamburgerBuild() {
        food = testClass.HamburgerBuild().addCheese().addCheese().addMeat().removeKetchup().build();

        food.getIngredients().forEach((k,v) -> System.out.println(k + " is " + v));

    }
}