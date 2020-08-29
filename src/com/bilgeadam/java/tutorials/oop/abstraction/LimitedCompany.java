package com.bilgeadam.java.tutorials.oop.abstraction;

public class LimitedCompany extends GenericCompany{


    public LimitedCompany(String owner, String name, int totalNbOfEmployeesNeeded) {
        super(owner, name, totalNbOfEmployeesNeeded);
    }

    /**
     * A generic method to verify whether or not given employee able to be recruit
     *
     * @param name Name of the employee
     * @return 'true' if employee is accepted, 'false' otherwise.
     */
    @Override
    protected boolean isEmployeeAcceptable(String name) {
        return true;
    }

    /**
     * A generic method to verify whether or not given employee exists in company
     *
     * @param name name of the employee
     * @return true
     */
    @Override
    protected boolean isEmployeeExist(String name) {
        return true;
    }
}
