package com.bilgeadam.java.tutorials.strings;

public class Strings {
    private String name = "Java";

    /**
     * The constructor will create 2 different Strings for the String Pool
     */
    public Strings(){
        name = "New Java"; // 'New Java' is stored as a string in the background

        String test;
        test = "Java"; // 'Java' string, which is stored in the background for the variable 'name' in the first place,
        // is associated with 'test' variable.
    }

    /**
     * This appends a new string to current string
     * @return
     */
    public String appendStrings(String value){
        return name.concat(" " + value);
    }

    public String replaceChars(char oldChar, char newChar){
        return name.replace(oldChar, newChar);
    }

    public String replaceFirstChar(String oldChar, String newChar){
        return name.replaceFirst(oldChar, newChar);
    }

    public String substring(int start){
        name = "Java Class YJS 4436";
        name = name.substring(start);

        System.out.println("name = " + name);
        return name;
    }


    public void buildingStrings(){

    }
}
