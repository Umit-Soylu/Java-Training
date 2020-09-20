package com.bilgeadam.java.tutorials.collections.queues;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueuesTest {
    Queues testClass;

    @BeforeEach
    void setUp() {
        testClass = new Queues();
    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    @Test
    void addElement() {
        // Arrays can be created without size only in the initialization.
        String[] elements = new String[]{"A", "Z", "S", "A", "Z", "S"};

        for (String s : elements) {
            testClass.addElement(s);
        }

        testClass.printElements();
    }

    @Test
    void offerElement() {
        // Arrays can be created without size only in the initialization.
        String[] elements = new String[]{"A", "Z", "S", "A", "Z", "S"};

        for (String s : elements) {
            testClass.pushElement(s);
        }

        testClass.removeElements();
    }


}