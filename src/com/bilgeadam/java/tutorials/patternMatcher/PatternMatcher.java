package com.bilgeadam.java.tutorials.patternMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {
    // Divide the String to key & value parameters. Ex: 'key' : ' value'
    private String key, value;

    private Integer keyValue;

    private static final String regexForWords = "\\w+"; // [a..zA..Z]

    // Regex for catching String_Id
    private static final String regexForObjectId = "(\\w+)_(\\d+)";
    // Same Regex as above
    private static final String regexForObjectId2 = "([a-zA-Z]+)_([0-9]+)";

    private List<String> results;

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public Integer getKeyValue() {
        return keyValue;
    }

    public List<String> getResults() {
        return results;
    }

    /**
     * Divide the String as Key and Value using ':'
     * @param input String (Ex: 'Student : Umit'
     */
    public void keyValueDivider(String input){
        int dividerIndex = input.indexOf(':');

        this.key = input.substring(0, dividerIndex).trim();
        this.value = input.substring(dividerIndex + 1).trim();
    }

    /**
     * This will catch Word groups and stores them to results array
     * @param input String
     */
    public void keyValueRegex(String input) {
        // Creates a pattern according Regex
        Pattern p = Pattern.compile(regexForWords);
        Matcher m = p.matcher(input);

        results = new ArrayList<>();

        while (m.find()){
            System.out.println("Matcher = " + m.start() + " to " + m.end());
            //results.add(input.substring(m.start(), m.end()));
            results.add(m.group());
        }
    }

    /**
     * This method will verify given string satisfies <Type>-<Counter>
     *
     * @param input String
     * @return      result as boolean
     */
    public boolean isValidString(String input){
        // Creates a pattern according Regex
        Pattern p = Pattern.compile(regexForObjectId2);
        Matcher m = p.matcher(input);

        // print out match
        while (m.find()) {
            this.key = m.group(1).toUpperCase();
            this.keyValue = Integer.parseInt(m.group(2));
        }

        return m.matches();
    }
}
