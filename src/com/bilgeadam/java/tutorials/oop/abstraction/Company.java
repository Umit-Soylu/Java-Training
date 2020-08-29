package com.bilgeadam.java.tutorials.oop.abstraction;

/**
 * This class defines the concept of a Company
 */
public interface Company {
    // Any variable in Interface is 'public static final' and should be initialized in the interface.
    String companyType = "Commercial Company";


    /**
     * This method allow us to calculate occupancy rate of the company.
     * @return the rate of occupancy
     */
    float occupancyRate(); // Any method declared in an interface is public, cannot be protected or private

    /**
     * This method allow us to acquired the profit of the company.
     * @return the profit of the last year
     */
    float yearlyProfit();

    /**
     * A default method that can be override by extending classes
     * @return true if not set otherwise.
     */
    default boolean isCompanyActive(){
        return true;
    }

}
