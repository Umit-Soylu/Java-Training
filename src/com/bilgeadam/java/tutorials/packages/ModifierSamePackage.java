package com.bilgeadam.java.tutorials.packages;

// No need for import statement in here since both files are in the same package.
// import com.bilgeadam.java.tutorials.packages.Variables;

public class ModifierSamePackage {

    public static void main(String[] args) {
        // Initialize testVariable Object using default constructor.
        Variables testVariable = new Variables();

        System.out.println("Modifiers Test");

        // Protected methods can be called. (!!!)
        System.out.println(testVariable.getTestDouble());

        // Public methods can be called.
        System.out.println(testVariable.getTestBoolean());

        // Protected variables can be called. (!!!)
        System.out.println(testVariable.testByte);

        // Public variables can be called.
        System.out.println(testVariable.testInt);

        /* Private variables & methods cannot be called
        Calling testShort & getTestObjectFloat() is not possible
         */

    }
}
