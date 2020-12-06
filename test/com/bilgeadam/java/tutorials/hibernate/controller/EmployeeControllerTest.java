package com.bilgeadam.java.tutorials.hibernate.controller;

import com.bilgeadam.java.tutorials.hibernate.entities.Employee;
import com.bilgeadam.java.tutorials.hibernate.entities.Roles;
import com.bilgeadam.java.tutorials.hibernate.entities.Salary;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        employee.getSalary().setEmployee(employee);
        int id = testClass.addEmployee(employee);
        assertNotNull(id);

        System.out.println(testClass.getEmployee(id));

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
}