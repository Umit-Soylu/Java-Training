package com.bilgeadam.java.examples.recursive;

import java.util.Stack;

public class MathematicalExpressionParser {
    // All tokens separated by space will be stored in here
    private final String[] strings;

    // Current index of the strings array
    private int currentIndex;

    /**
     * This constructor will create a Stack to store and parse mathematical expressions
     * @implSpec only +, -, *, / and {@link Integer} values, separated by space, are present in the {@code input}
     *
     * @param input String to parse
     */
    public MathematicalExpressionParser(String input) {
        strings = input.split(" ");
        currentIndex = 0;
    }

    /**
     * This method will parse the string as mathematical expression and generate result
     * @implNote Solves the problem using recursive approach
     *
     * @return The mathematical result as {@link Float}
     */
    public float parseInput(){
        // Initialize a Stack to store mathematical expressions
        Stack<String> bucket = new Stack<>();

        // Acquire new tokens from the string array is not empty
        for (int i = currentIndex; i < strings.length; i++){
            // Recursively call itself
            if (strings[i].equals("(")) {
                currentIndex = ++i;
                bucket.push((String.valueOf(parseInput())));
                i = currentIndex;
            }
            // This means end of the current call, return
            else if (strings[i].equals(")")) {
                currentIndex = i;
                return Float.parseFloat(consumeBucket(bucket));
            }
            // Check if current string is a number or not
            else if (isNumeric(strings[i])){
                // If the bucket does not have a number, then it means the current expressions needs to be parsed.
                if (!bucket.isEmpty() && !isNumeric(bucket.peek())) {
                    char operand = bucket.pop().charAt(0);
                    float left = Float.parseFloat(bucket.pop());
                    bucket.push(
                            String.valueOf(
                                    parseSimpleExpression(left, Float.parseFloat(strings[i]), operand)));
                } else // Store current number
                    bucket.push(strings[i]);
            } else // Means it is only +, -, *, / symbol
                bucket.push(strings[i]);

        }

        return Float.parseFloat(consumeBucket(bucket));
    }

    /**
     * This method consumes the stack and generate only the last result
     *
     * @param currentStack Current Stack
     * @return the last result of mathematical expression
     */
    private String consumeBucket(Stack<String> currentStack){
        // Consume remaining mathematical expressions if left any
        while (currentStack.size() > 2){
            float right = Float.parseFloat(currentStack.pop());
            char operand = currentStack.pop().charAt(0);
            float left = Float.parseFloat(currentStack.pop());
            currentStack.push(
                    String.valueOf(
                            parseSimpleExpression(left, right, operand)));
        }

        return currentStack.pop();
    }
    /**
     * This method will parse current mathematical expression and generate a result
     * @param operandOne Left operand
     * @param operandTwo Right operand
     * @param operator   + or - or * or /
     * @return the result
     */
    private float parseSimpleExpression(float operandOne, float operandTwo, char operator){
        switch (operator){
            case '+':
                return operandOne + operandTwo;
            case '-':
                return operandOne - operandTwo;
            case '*':
                return operandOne * operandTwo;
            case '/':
                return operandOne / operandTwo;
            default:
                throw new IllegalArgumentException("Unknown symbol: " + operator);
        }
    }
    /**
     * This method verifies given string is a {@link Double} number or not
     *
     * @param input The string to be parsed
     * @return true if {@code input} is {@link Double}, false otherwise
     */
    private boolean isNumeric(String input){
        try {
            Double.parseDouble(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
