package com.bilgeadam.java.tutorials.packages;

public class Variables {

    // Primitive Types
    protected byte testByte = 127;        // 8 bit variable   [-128 .. 127]
    private final short testShort = 32767;    // 16 bit variable  [-32768 .. 32767]
    public int testInt = 2_147_483_647;// Same as '2147483647'; 32 bit variable
    long testLong = 9_223_372_036_854_775_806L; // 64 bit variable

    /*
    Primitive Floating Types
    Examples
     */
    float testFloat = 19.234F;              // 'F' is essential
    double testDouble = 134555.12344556D;   // 'D' is essential

    // Other Primitive Types
    char testChar = 's';
    boolean testBoolean = false;

    // Reference Types, these types can be assigned as 'null'.
    Byte testObjectByte = Byte.MIN_VALUE;               // Wrapper of byte primitive type
    Short testObjectShort = Short.MAX_VALUE;            // Wrapper of short primitive type
    Integer testObjectInteger = Integer.MIN_VALUE;      // Wrapper of int primitive type
    Long testObjectLong = Long.MAX_VALUE;               // Wrapper of long primitive type

    Float testObjectFloat = Float.NEGATIVE_INFINITY;    // Wrapper of float primitive type
    Double testObjectDouble = Double.MIN_VALUE;         // Wrapper of double primitive type

    Character testObjectChar = 'c';                     // Wrapper of char primitive type
    Boolean testObjectBoolean = Boolean.FALSE;          // Wrapper of boolean primitive type

    String className = "Variables";                     // Special type for storing strings

    private Float getTestObjectFloat(){
        return testObjectFloat;
    }

    protected double getTestDouble() {
        return testDouble;
    }

    public boolean getTestBoolean(){
        return testBoolean;
    }
}
