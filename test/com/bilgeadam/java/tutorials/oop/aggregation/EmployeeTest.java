package com.bilgeadam.java.tutorials.oop.aggregation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeTest {

    Employee testEmployee;

    // Input parameters for the new object.
    String name = "Umit Soylu", city = "Istanbul", country = "TR", details = "details";
    int zipCode = 11111;

    @Test
    public void TestOne(){
        // Create employee class.
        testEmployee = new Employee(name, city, country, zipCode, details);

        // The resulting address string will be this.
        String address = "Country:" + country + "City: " + city + "Zip code " + zipCode + "Details: " + details;

        assertEquals(address, testEmployee.getAddress());
    }

    @Test
    public void TestTwo(){
        // Create address class.
        Address testAddress = new Address(city, country, zipCode, details);

        // Create employee class using address object.
        testEmployee = new Employee(name, testAddress);

        // The resulting address string will be this.
        String address = "Country:" + country + "City: " + city + "Zip code " + zipCode + "Details: " + details;

        assertEquals(address, testEmployee.getAddress());
    }

}