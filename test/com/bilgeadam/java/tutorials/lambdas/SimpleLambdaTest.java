package com.bilgeadam.java.tutorials.lambdas;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleLambdaTest {
    SimpleLambda testClass;

    @BeforeEach
    void setUp() {
        testClass = new SimpleLambda();
    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    @Test
    void executeInterface() {
        testClass.executeHomework();
    }

    @Test
    void executeHousework() {
        testClass.executeHousework();
    }

    @Test
    void generateWork() {
        testClass.generateWork().run();
    }

    @Test
    void processLambda() {
        testClass.processLambda(()-> System.out.println(this.getClass().getName()));
    }

    @Test
    void printName(){
        SimpleLambda.printMyName();
    }
}