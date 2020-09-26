package com.bilgeadam.java.examples.paranthesis_matcher;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void verifyParenthesis() {
        String input = "(2+3)*(2-5)";

        assertEquals(true, testClass.verifyParenthesis(input));
    }


    @Test
    void verifyParenthesis2() {
        String input = "(2+3)*(2-5";

        assertEquals(false, testClass.verifyParenthesis(input));
    }

    @Test
    void verifyParenthesis3() {
        String input = "((2+3)*(2-5)-5";

        assertEquals(false, testClass.verifyParenthesis(input));
    }


    @Test
    void verifyParenthesis4() {
        String input = "(((2+3)-(2-5))-(5-6))";

        assertEquals(true, testClass.verifyParenthesis(input));
    }


    @Test
    void verifyParenthesis5() {
        String input = "(((2+3)-2-5))-(5-6))";

        assertEquals(false, testClass.verifyParenthesis(input));
    }

    @Test
    void parseInput() {
        String input = "2+3-5+(3*2)";

        assertEquals(6.0, testClass.parseInput(input));
    }

    @Test
    void atest() {
        testClass.atest();
    }
}