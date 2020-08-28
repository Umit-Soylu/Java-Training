package com.bilgeadam.java.tutorials.modifiers;

// The class is imported (Java way of copied) in order to be used within this class.
import com.bilgeadam.java.tutorials.packages.Variables;

public class ModifiersTest {


    public static void main(String[] args) {
        // Initialize testVariable Object using default constructor.
        Variables testVariable = new Variables();

        System.out.println("Modifiers Test");

        // Protected methods cannot be called from another package.
        // System.out.println(testVariable.getTestDouble());

        // Public methods can be called.
        System.out.println(testVariable.getTestBoolean());

        // Protected variables cannot be called from another package.
        // System.out.println(testVariable.testByte);

        // Public variables can be called.
        System.out.println(testVariable.testInt);

        /* Private variables & methods cannot be called
        Calling testShort & getTestObjectFloat() is not possible
         */

    }
}
