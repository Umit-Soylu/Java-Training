package com.bilgeadam.java.tutorials.hibernate.controller;

import com.bilgeadam.java.tutorials.hibernate.entities.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


class EmployeeControllerTest {
    EmployeeController testClass;

    @BeforeEach
    void setUp() {
        testClass = new EmployeeController();
    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    @Test
    void addEmployee() {
        Employee employee = new Employee("Con", "java");

        int id = testClass.addEmployee(employee);
        assertNotNull(id);

        testClass.deleteEmployee(id);
        assertNull(testClass.getEmployee(id));
    }

    @Test
    void addEmployeeWithSalary() {
        Employee employee = new Employee("Employee", "Test");
        Salary salary = null;
        try {
            salary = new Salary(9999);
        } catch (Exception e) {
            e.printStackTrace();
        }

        employee.setSalary(salary);
        //employee.getSalary().setEmployee(employee);
        int id = testClass.addEmployee(employee);
        assertEquals(salary.getId(), testClass.getEmployee(id).getSalary().getId());

        testClass.deleteEmployee(id);
        assertNull(testClass.getEmployee(id));
    }

    @Test
    void addEmployeeWithAddress() {
        Employee employee = new Employee("Employee", "Test");
        Address address = new Address("Test", "TR", "Ist", "Bilge Adam", 11111);
        address.setEmployee(employee);
        Set<Address> addresses = new HashSet<>();
        addresses.add(address);
        employee.setAddresses(addresses);

        //employee.getSalary().setEmployee(employee);
        int id = testClass.addEmployee(employee);
        boolean res = testClass.getEmployee(id).getAddresses().stream().findAny().stream().anyMatch(e -> e.getId() == address.getId());
        System.out.println("res = " + res);
        testClass.deleteEmployee(id);
        assertNull(testClass.getEmployee(id));
    }

    @Test
    void listEmployees(){
        Employee employee = new Employee("First", "Test");
        testClass.addEmployee(employee);

        List<Employee> employees = testClass.getEmployees();
        assertNotNull(employees);
        employees.forEach(System.out::println);

        employees.forEach(e -> testClass.deleteEmployee(e.getId()));
        assertTrue(testClass.getEmployees().isEmpty());
    }

    @Test
    void getEmployee(){
        Employee employee = new Employee("New", "Employee");
        int id = testClass.addEmployee(employee);

        assertNotNull(testClass.getEmployee(id));

        testClass.deleteEmployee(id);
        assertNull(testClass.getEmployee(id));
    }

    @Test
    void deleteEmployee() {
        Employee employee = new Employee("New", "Employee");
        int id = testClass.addEmployee(employee);

        testClass.deleteEmployee(id);

        assertNull(testClass.getEmployee(id));
    }

    @Test
    void updateEmployeeRole() {
        Employee employee = new Employee("Test", "Employee");
        employee.setCurrentRole(Roles.Mid);
        int id = testClass.addEmployee(employee);

        employee = testClass.getEmployee(id);
        assertEquals(Roles.Mid, employee.getCurrentRole());

        testClass.updateEmployeeRole(id, Roles.Senior);
        employee = testClass.getEmployee(id);
        assertEquals(Roles.Senior, employee.getCurrentRole());

        testClass.deleteEmployee(id);
    }

    @Test
    void addEmployeeWithDepartments() {
        Employee employeeOne = new Employee("EmployeeOne", "Dept");
        Employee employeeTwo = new Employee("EmployeeTwo", "Dept");
        Department departmentOne = new Department("one");
        Department departmentTwo = new Department("two");

        // First Case
        Set<Department> departments = new HashSet<>();
        departments.add(departmentOne);
        employeeOne.setDepartments(departments);
        int id = testClass.addEmployee(employeeOne);
        assertTrue(
                Arrays.equals(departments.stream().mapToLong(Department::getId).toArray(),
                        testClass.getEmployeeDepartments(id).stream().mapToLong(Department::getId).toArray()));

        // Second Case
        employeeTwo.setDepartments(departments);
        id = testClass.addEmployee(employeeTwo);

        // Third Case
        departments.add(departmentTwo);
        employeeOne.setDepartments(departments);
        id = testClass.addEmployee(employeeOne);
        assertEquals(departments.size(), testClass.getEmployeeDepartments(id).size());
        // Forth Case
        employeeTwo.setDepartments(departments);
        id = testClass.addEmployee(employeeTwo);
        assertEquals(departments.size(), testClass.getEmployeeDepartments(id).size());

        testClass.deleteEmployee(id);
        assertNull(testClass.getEmployee(id));
    }
}