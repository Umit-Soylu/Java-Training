package com.bilgeadam.java.examples.stacks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParenthesisMatcherTest {
    ParenthesisMatcher testClass;

    @BeforeEach
    void setUp() {
        testClass = new ParenthesisMatcher();
    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    @Test
    void verifyParenthesisOne() {
        String input = "(2+3)*(2-5)";

        assertTrue(testClass.verifyParenthesis(input));
    }

    @Test
    void verifyParenthesisTwo() {
        String input = "(2+3)*(2-5";

        assertFalse(testClass.verifyParenthesis(input));
    }

    @Test
    void verifyParenthesisThree() {
        String input = "((2+3)*(2-5)-5";

        assertFalse(testClass.verifyParenthesis(input));
    }

    @Test
    void verifyParenthesisFour() {
        String input = "(((2+3)-(2-5))-(5-6))";

        assertTrue(testClass.verifyParenthesis(input));
    }


    @Test
    void verifyParenthesisFive() {
        String input = "(((2+3)-2-5))-(5-6))";

        assertFalse(testClass.verifyParenthesis(input));
    }
}