package com.bilgeadam.java.examples.stacks;

import java.util.Stack;

public class ParenthesisMatcher {
    private final Stack<Character> matcher;

    public ParenthesisMatcher() {
        matcher = new Stack<>(); //Create an empty stack
    }


    /**
     * This method verifies that each "(" is matched with a ")" while ignoring all other {@link Character} of the {@code input}
     * @param input String to be validated
     * @return true if parenthesis are matched, false otherwise
     */
    public boolean verifyParenthesis(String input){
        // Loop through each element of String
        for (Character c : input.toCharArray()) {
            if (c.equals('('))
                matcher.push(c);
            else if(c.equals(')')) {
                // If my bucket  is empty, the parenthesis are not matched
                if (matcher.isEmpty())
                    return false;
                else
                    matcher.pop();
            }
        }

        // There should be nothing left in the stack for parenthesis to be matched.
        return matcher.isEmpty();
    }
}
