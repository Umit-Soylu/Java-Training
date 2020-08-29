package com.bilgeadam.java.tutorials.oop;

/**
 * This class will keep track of number of products
 */
public class Product {

    // Type can be Book, Cardpostal, Dergi, Karikatur,...
    private final String type;

    // Name of the product
    private final String name;

    // Number of products
    private static int counter;

    /**
     * Constructor for a product
     * @param type Type of the product
     * @param name Name of the product
     */
    public Product(String type, String name) {
        // These are object variables
        this.type = type;
        this.name = name;

        // This is static variable
        Product.counter++;
    }

    /**
     * Used for resetting the counter
     */
    public static void resetCounter(){
        Product.counter = 0;
    }

    /**
     *
     * @return the counter
     */
    public static int getCounter(){
        return Product.counter;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

}
