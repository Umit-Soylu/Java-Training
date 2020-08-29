package com.bilgeadam.java.tutorials.oop.aggregation;

public class Address {
    protected final String city, country, details;
    protected final Integer zipCode;

    public Address(String city, String country, Integer zipCode, String address) {
        this.details = address;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
    }
}
