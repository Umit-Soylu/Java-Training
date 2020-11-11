package com.bilgeadam.java.examples.paranthesis_matcher;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.util.*;

public class ParenthesisMatcher {
    private final Stack matcher;

    public ParenthesisMatcher() {
        matcher = new Stack();
    }

    public void atest(){
        int i = 5;
        btest();
    }

    private void btest(){
        int j = 3;
        Date d = new Date();
        SimpleDateFormat f;
        Calendar x = new GregorianCalendar();
        List l = new LinkedList() ;
        Map x = new Hashtable();
        Deque d =new ArrayDeque();
        Queue s = new PriorityQueue();
        Set s = new LinkedHashSet();

    }
    /**
     * This method will parse the string as mathematical expression and generate result
     * Assumption, only add, subtract, multiply, division
     * Uses only integer
     * Solves the problem using recursive approach
     * @param input String to parse
     * @return The mathematical result
     */
    public float parseInput(String input){
        Stack bucket = new Stack();
        // Loop through each element of String
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '('){
                int j = input.indexOf(')',i);
                float res = parseInput(input.substring(i+1, j));
                i = j;
                bucket.push(res);
            }
            else if(Character.isDigit(input.charAt(i))){
                if (bucket.size() >=2 && !Character.isDigit((Character) bucket.peek())){
                    // This will result '+', '-', '*', '/'
                    Character operation = (Character) bucket.pop();

                    String c = String.valueOf(bucket.pop());
                    Float operandOne = Float.parseFloat(c);

                    c = String.valueOf(input.charAt(i));
                    Float operandTwo = Float.parseFloat(c);

                    switch (operation){
                        case '+':
                            bucket.push(operandOne + operandTwo);
                            break;
                        case '-':
                            bucket.push(operandOne - operandTwo);
                            break;
                        case '*':
                            bucket.push(operandOne * operandTwo);
                            break;
                        case '/':
                            bucket.push(operandOne / operandTwo);
                            break;
                        default:
                            throw new IllegalArgumentException("Unknown");
                    }
                } else
                    bucket.push(input.charAt(i));
            }
            // this case only occurs for '+', '-', '*', '/'
            else if(!Character.isAlphabetic(input.charAt(i)))
                bucket.push(input.charAt(i));

        }

        String c = String.valueOf(bucket.pop());
        return Float.parseFloat(c);
    }

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

        return matcher.isEmpty();
    }
}
