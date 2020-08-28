package com.bilgeadam.java.tutorials.oop.aggregation;

public class Employee {

    String name;

    // This will define 'has a' relationship between Employee & Address.
    Address address;

    /**
     * The address object can be created using required parameters as input.
     * @param name Employee name
     * @param city Employee city for address
     * @param country Employee country for address
     * @param zipCode Employee zip code for address
     * @param address Employee address details
     */
    public Employee(String name, String city, String country, Integer zipCode, String address) {
        this.name = name;
        this.address = new Address(city, country, zipCode, address);
    }

    /**
     * The address object can be provided as input.
     * @param name Employee name
     * @param address The address object to associate with Employee
     */
    public Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }


    public String getAddress() {
        return  "Country:" + address.country +
                "City: " + address.city +
                "Zip code " + address.zipCode +
                "Details: " + address.details;
    }

    
}
