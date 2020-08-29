package com.bilgeadam.java.tutorials.oop.abstraction;

public class SoleProprietorship extends GenericCompany{

    // Sole Proprietorship companies can be deactivated for time being
    private boolean isCompanyActive;

    /**
     * The constructor for Company. This method is called when a new company is built.
     *
     * @param owner        Owner of the company
     * @param name         Name of the company
     * @param employeeSize Expected size of the company
     */
    public SoleProprietorship(String owner, String name, int employeeSize) {
        super(owner, name, 30);
        this.isCompanyActive = true;
    }

    /**
     * Verifies whether or not given employee is able to be recruited
     *
     * @param name Name of the employee
     * @return 'true' if employee is accepted, 'false' otherwise.
     */
    @Override
    protected boolean isEmployeeAcceptable(String name) {
        // TODO: Check recruiters accepted candidate

        return true;  // Assume employee is a valid candidate.
    }

    /**
     * A generic method to verify whether or not given employee exists in company
     *
     * @param name name of the Employee
     * @return True (Assume it exists all the time)
     */
    @Override
    protected boolean isEmployeeExist(String name) {
        // TODO: Check employee is in the company database.

        return true; //Assume it exist.
    }

    /**
     * A method to deactivate the company for time being
     */
    protected void deactivateCompany(){
        this.isCompanyActive = false;
    }

    /**
     * A method to activate the company for time being
     */
    protected void activateCompany(){
        this.isCompanyActive = true;
    }

    /**
     * A method to display current status of the company
     * This method overrides a default method - default methods do not need to be override.
     * @return 'true' if company is active, 'false' otherwise.
     */
    @Override
    public boolean isCompanyActive() {
        return this.isCompanyActive;
    }
}
