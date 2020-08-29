package com.bilgeadam.java.tutorials.oop.abstraction;

/**
 * Assume any given Company can only be built by one person (cannot be built by legal entities)
 */
public abstract class GenericCompany implements Company {

    // The owner of the company
    private final String owner;

    // Name of the company
    private final String name;

    // The number of employees for both current and total needed.
    private int currentNbOfEmployees;
    private final int totalNbOfEmployees;

    // The current income & expense
    private float income, expense;

    /**
     * The constructor for Company. This method is called when a new company is built.
     * @param owner                     Owner of the company
     * @param name                      Name of the company
     * @param totalNbOfEmployeesNeeded  Number of employees needed for running the company
     */
    public GenericCompany(String owner, String name, int totalNbOfEmployeesNeeded) {
        this.owner = owner;
        this.name = name;
        this.currentNbOfEmployees = 1; // This is the owner of the company
        this.totalNbOfEmployees = totalNbOfEmployeesNeeded;
        this.expense = 0F;
        this.income = 0F;
    }

    /**
     * This method allow us to calculate occupancy rate of the company.
     *
     * @return the rate of occupancy
     */
    @Override
    public float occupancyRate() {
        return (float) currentNbOfEmployees / totalNbOfEmployees;
    }

    /**
     * This method allow us to acquired the profit of the last year.
     *
     * @return the profit of the last year
     */
    @Override
    public float yearlyProfit() {
        return income / expense;
    }

    /**
     * Recruiting method for new employee
     */
    public void recruitEmployee(String name){
        // Can call abstract methods in abstract classes since it is guaranteed that this method will be implemented.
        if (isEmployeeAcceptable(name))
            this.currentNbOfEmployees++;
        else
            throw new IllegalArgumentException("Cannot hire " + name);
    }

    /**
     * A generic method to verify whether or not given employee able to be recruit
     *
     * @param   name Name of the employee
     * @return  'true' if employee is accepted, 'false' otherwise.
     */
    // Abstract methods can be protected or public but not private
    // This method is guaranteed to be implemented by extending class
    // This method can be used in this abstract class even if it is not implemented yet
    protected abstract boolean isEmployeeAcceptable(String name);

    /**
     * A method to be called when an employee is fired.
     * @param name name of the fired employee
     */
    public void fireEmployee(String name){
        if (isEmployeeExist(name))
            this.currentNbOfEmployees--;
        else
            throw new IllegalArgumentException(name + " does not exist in " + this.name + " " + Company.companyType);
    }

    /**
     * A generic method to verify whether or not given employee exists in company
     * @param name Name of the employee
     * @return 'true' if exist, 'false' otherwise
     */
    protected abstract boolean isEmployeeExist(String name);

    /**
     * An expense for the company
     * @param expense Should be positive
     */
    public void addExpense(float expense){
        if (expense > 0F)
            this.expense += expense;
    }

    /**
     * Income for the company (Assume no recurring case)
     * @param income Should be positive
     */
    public void addIncome(float income){
        if (income > 0F)
            this.income += income;
    }
}
