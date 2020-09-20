package com.bilgeadam.java.examples.recursive;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MathematicalExpressionParserTest {
    MathematicalExpressionParser testClass;

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    /**
     * Here all test cases are created
     * @return inputs and results for each test case
     */
    private static Stream<Arguments> testParameters(){
        return Stream.of(
                Arguments.arguments("2 + 3", "5"),
                Arguments.arguments("( 2 + 3 )", "5"),
                Arguments.arguments("3 - ( 2 + 3 )", "-2"),
                Arguments.arguments("( 3 - 4 ) / ( 2 + 3 )", "-0.2"),
                Arguments.arguments("( 3 - ( 2 * 3 ) ) / 5", "-0.6"),
                Arguments.arguments("( 3 - 1 ) + ( 2 + 3 )", "7")
        );
    }

    @ParameterizedTest(name = "{index} => parseInput({0}) should return {1}")
    @MethodSource("testParameters")
    void parseInput(String input, String result) {
        testClass = new MathematicalExpressionParser(input);

        assertEquals(Float.parseFloat(result), testClass.parseInput());
    }
}