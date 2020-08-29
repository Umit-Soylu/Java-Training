package com.bilgeadam.java.tutorials.constructors;

public class ConstructorDemo {
    private String name;

    //
    // The default constructor. This constructor will be created automatically if no constructor is defined.
    public ConstructorDemo(){
    }

    // Custom constructor with variable
    public ConstructorDemo(String name){
        this.name = name;
    }

    // Another constructor with 2 arguments
    public ConstructorDemo(String newName, boolean isValid){
        this.name = isValid ? newName : "Invalid Name";
    }

    public String getName() {
        return name;
    }

}
