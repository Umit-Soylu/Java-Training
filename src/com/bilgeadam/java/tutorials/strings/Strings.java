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
     * @return appended String
     */
    public String appendStrings(String value){
        return name.concat(" ").concat(value);
    }

    public String replaceChars(char oldChar, char newChar){
        return name.replace(oldChar, newChar);
    }

    public String replaceFirstRegex(String oldChar, String newChar){
        return name.replaceFirst(oldChar, newChar);
    }

    public String substring(int start){
        name = "Java Class YJS 4436";
        name = name.substring(start);

        System.out.println("name = " + name);
        return name;
    }

    /**
     * This splints the string for each ' '
     * @return Only one string
     */
    public String splitString(){
        name = "Java Class YJS 4436";

        // Just to show each string
        for (String s: name.split(" ")) {
            System.out.println("Split String = " + s);
        }

        return name.split(" ", 2)[0];
    }

    /**
     * The last index looks from right to left staring 'fromIndex' or starting from the end of the string
     *
     * @param c The character itself
     * @return  Index of the character
     */
    public int lastIndex(char c){
        name = "Java Class YJSa 4436";
        int index = 10;

        System.out.println("name = " + name.substring(0, 10));

        return name.lastIndexOf(c, index);
    }
    /**
     * Index of looks from left to right staring 'fromIndex' or starting from the beginning of the string
     *
     * @param c The character itself
     * @return  Index of the character
     */
    public int indexOf(char c){
        name = "Java Class YJSa 4436";
        int index = 10;
        System.out.println("name = " + name.substring(10));
        //System.out.println("I: " + name.indexOf("Testa", 0));
        return name.indexOf(c, index);
    }

    /**
     * This uses StringBuilder class
     */
    public String buildingStrings(String classCode, int classId, String typeOfClass, float occupancyRate){
        StringBuilder builder = new StringBuilder("Java");

        builder.append(" " + classCode);
        builder.append(" " + classId);
        builder.append(" " + typeOfClass);
        builder.append(" with " + occupancyRate);

        // If this has been done via Strings
//        name = "Java";                      // 'Java' stored in String Pool
//        name += " " + classCode;            // 'Java YSJ' stored in String Pool
//        name += " " + classId;              // 'Java YJS 4436' stored in String Pool
//        name += " " + typeOfClass;          // 'Java YJS 4436 class' stored in String Pool
//        name += " with " + occupancyRate;   // 'Java YJS 4436 class with 0.85' stored in String Pool

        return  builder.toString();         // Store the String in String Pool. - ONLY ONCE
    }

    /**
     *
     * @param classCode   Name of the class
     * @param classId     Id of the class
     * @param students    Students of the class
     * @return Reverse ordered students of the class.
     */
    public String reverseNames(String classCode, String classId, String[] students){
        StringBuilder builder = new StringBuilder(classCode + " " + classId + " ");

        for (int i = students.length -1; i >=0; i--) {
            builder.append(students[i]).append(" ");
        }

        return builder.toString().trim();
    }

    /**
     * Shows dynamic capacity and length values
     * @param initial  Initial String to build StringBuilder
     * @param appended The String that will be appended
     */
    public String capacity(String initial, String appended, int trim){
        StringBuilder builder = new StringBuilder(initial);

        // Thread Safe String Builder class
        // StringBuffer buffer = new StringBuffer(initial);

        System.out.println("builder.capacity() = " + builder.capacity());
        System.out.println("builder.length() = " + builder.length());
        System.out.println("builder = " + builder);
        
        builder.append(appended);
        System.out.println("builder.capacity() = " + builder.capacity());
        System.out.println("builder.length() = " + builder.length());
        System.out.println("builder = " + builder);

        // This method will trim extra capacity
        builder.trimToSize();
        System.out.println("builder.capacity() = " + builder.capacity());

        // Set length will cut the string from given length
        builder.setLength(trim);
        System.out.println("builder = " + builder);
        System.out.println("builder.capacity() = " + builder.capacity());

        return builder.toString();
    }

}
