package com.bilgeadam.java.tutorials.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    // Declaration
    Product testProduct;

    String type = "Book", name_1 = "Learning Java", name_2 = "Understanding Java", name_3 = "Bilgeadam";

    /**
     * Will test adding product and counter
     */
    @Test
    void addProductTest() {
        // Reset the counter for initial state.
        Product.resetCounter();

        // Instantiation
        testProduct = new Product(type, name_1);
        new Product(type, name_2);
        new Product(type, name_3);

        assertEquals(3, Product.getCounter());
    }
}