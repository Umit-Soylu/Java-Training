package com.bilgeadam.java.tutorials.strings;

public class Strings {
    private String name = "Java";

    /**
     * This will create 2 different String variables in the backend
     */
    public void immutableStrings(){
        name = "Java";
        name = "New Java";

        String test;
        test = "Java";
    }


    public String appendStrings(){
        name = name.concat(" Class");

        return name;
    }

    public String replaceChars(char oldChar, char newChar){
        name = name.replace(oldChar, newChar);
        System.out.println("name = " + name);
        return name;
    }

     public String replaceFirstChar(String oldChar, String newChar){
        name = name.replaceFirst(oldChar, newChar);
        System.out.println("name = " + name);
        return name;
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
