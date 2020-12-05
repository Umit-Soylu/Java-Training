package com.bilgeadam.java.tutorials.jdbc.controller;

import com.bilgeadam.java.tutorials.jdbc.connection.Connector;
import com.bilgeadam.java.tutorials.jdbc.entities.Employee;
import com.bilgeadam.java.tutorials.jdbc.entities.Gender;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeController {
    // This class allow us to access DB
    private final Connector connector;

    // This is the connection to access to the DB
    //private Connection connection;

    public EmployeeController() {
        this.connector = new Connector();
    }

    /**
     * Returns the employee for the given {@code id}
     *
     * @param id emp_no
     * @return The employee that is found or {@link null}
     */
    public Employee getEmployee(int id) {
        String employeeSQL = "SELECT * FROM employees.employees E WHERE E.emp_no = ?";
        ResultSet resultSet;
        Employee employee = null;

        // Automatically closes connection upon completion.
        try (Connection connection = connector.getConnection()) {
            PreparedStatement st = connection.prepareStatement(employeeSQL);
            st.setInt(1, id);

            resultSet = st.executeQuery();

            employee = convertResultToEmployeeList(resultSet).get(0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }

    /**
     * Returns the number of employees for the given {@code limit}
     *
     * @param limit The number of employees
     * @return employee list
     */
    public List<Employee> getEmployees(int limit) {
        String returnEmployees = "Select * from employees.employees";
        ResultSet resultSet;
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = connector.getConnection()) {
            PreparedStatement st = connection.prepareStatement(returnEmployees);

            st.setMaxRows(limit);

            resultSet = st.executeQuery();
            employees = convertResultToEmployeeList(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return employees;
    }

    /**
     * Inserts given employee to the database.
     *
     * @param employee The employee class
     * @return Number of affected rows
     */
    public int addEmployee(Employee employee){
        String addEmployee = "Insert employees.employees (emp_no, birth_date, first_name, last_name, gender, hire_date)" +
                "values(?, ?, ?, ?, ?, ?)";
        int nbOfRows = 0;
        try(Connection connection = connector.getConnection()){
            PreparedStatement st = connection.prepareStatement(addEmployee);
            st.setInt(1, employee.getId());
            st.setDate(2, (Date) employee.getBirthDay());
            st.setString(3, employee.getFirstName());
            st.setString(4, employee.getLastName());
            st.setString(5, employee.getGender().toString());
            st.setDate(6, (Date) employee.getHireDate());

            nbOfRows = st.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return nbOfRows;
    }

    /**
     * Adds multiple employees in a single call, or add none.
     * @param idOne   Id of first employee
     * @param nameOne New name of first employee
     * @param idTwo   Id of second employee
     * @param nameTwo New name of second employee
     * @return Number of affected rows
     */
    public int[] updateEmployeeNames(int idOne, String nameOne, Integer idTwo, String nameTwo) throws SQLException {
        int[] nbOfRows = new int[2];

        String employeeOne = "Update employees.employees E Set E.first_name = '" + nameOne + "' Where E.emp_no = " + idOne;
        String employeeTwo = "Update employees.employees E Set E.first_name = '" + nameTwo + "' Where E.emp_no = " + idTwo;
        Connection connection = null;

        try{
            connection = connector.getConnection();
            connection.setAutoCommit(false);

            Statement st = connection.createStatement();

            st.addBatch(employeeOne);
            st.addBatch(employeeTwo);

            nbOfRows = st.executeBatch();

            if (Arrays.stream(nbOfRows).anyMatch(e -> e == 0))
                throw new SQLException("Not expected result");

            connection.commit();
        } catch (SQLException throwable) {
            throwable.printStackTrace();

            assert connection != null;
            connection.rollback();
        } finally {
            assert connection != null;
            connection.close();
        }
        return nbOfRows;
    }

    /**
     * This method updates the employee with the new values provides, not updated if the field is {@link null}
     * @param employee The employee class with new values
     * @return Number of affected rows, -1 if not executed
     */
    public int updateEmployee(Employee employee){
        int nbOfRows = 0;
        StringBuilder updateSQL = new StringBuilder("Update employees.employees E Set ");

        // Update block for not null values
        if (employee.getFirstName() != null)
            updateSQL.append("E.first_name = ?, ");
        if (employee.getLastName() != null)
            updateSQL.append("E.last_name = ?, ");
        if (employee.getGender() != null)
            updateSQL.append("E.gender = ?, ");
        if (employee.getBirthDay() != null)
            updateSQL.append("E.birth_date = ?, ");
        if (employee.getHireDate() != null)
            updateSQL.append("E.hire_date = ?, ");

        // Remove the last comma, which is not needed.
        int lastComma = updateSQL.lastIndexOf(",");
        if (lastComma != -1)
            updateSQL.replace(lastComma, lastComma+1, "");
        else
            return -1;

        // Add Where statement
        updateSQL.append("Where E.emp_no = ?");

        try(Connection connection = connector.getConnection()){
            PreparedStatement st = connection.prepareStatement(updateSQL.toString());
            // Set the values for updates
            int index = 1;
            if (employee.getFirstName() != null)
                st.setString(index++, employee.getFirstName());
            if (employee.getLastName() != null)
                st.setString(index++, employee.getLastName());
            if (employee.getGender() != null)
                st.setString(index++, employee.getGender().toString());
            if (employee.getBirthDay() != null)
                st.setDate(index++, (Date) employee.getBirthDay());
            if (employee.getHireDate() != null)
                st.setDate(index++, (Date) employee.getHireDate());

            // Check if emp_no is valid
            if (employee.getId() != null && employee.getId() >= 0)
                st.setInt(index, employee.getId());
            else
                throw new IllegalArgumentException("Employee no is " + employee.getId());

            nbOfRows = st.executeUpdate();
        } catch (SQLException | IllegalArgumentException exception) {
            exception.printStackTrace();
        }
        return nbOfRows;
    }

    /**
     * Deletes the employee according to the given {@param id}
     * @param id Emp_no
     * @return number of deleted rows
     */
    public int deleteEmployee(int id){
        int nbOfRows = 0;
        String deleteSQL = "Delete From employees.employees E where E.emp_no = ?";

        try (Connection connection = connector.getConnection()){
            PreparedStatement st = connection.prepareStatement(deleteSQL);
            st.setInt(1, id);

            nbOfRows = st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return nbOfRows;
    }

    /**
     * Converts given {@code resultSet} to an Employee Array.
     * @param resultSet Result of an SQL
     * @return The list of employees
     * @throws SQLException
     */
    private List<Employee> convertResultToEmployeeList(ResultSet resultSet) throws SQLException {
        ArrayList<Employee> employees = new ArrayList<>();
        while (resultSet.next()) {
            employees.add(
                    new Employee(
                            resultSet.getInt("emp_no"),
                            resultSet.getDate("birth_date"),
                            resultSet.getDate("hire_date"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            Gender.valueOf(resultSet.getString("gender"))));
        }
        return employees;
    }
}
