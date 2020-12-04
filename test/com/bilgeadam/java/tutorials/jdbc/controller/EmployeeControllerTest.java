package com.bilgeadam.java.tutorials.jdbc.controller;

import com.bilgeadam.java.tutorials.jdbc.entities.Employee;
import com.bilgeadam.java.tutorials.jdbc.entities.Gender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.SQLException;

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
    void getEmployee() {
        System.out.println(testClass.getEmployee(-10001));
        assertNotNull(testClass.getEmployee(10001));
        assertNull(testClass.getEmployee(-10001));
    }

    @Test
    void getEmployees() throws SQLException {
        testClass.getEmployees(5).forEach(System.out::println);

        assertEquals(5, testClass.getEmployees(5).size());

        assertTrue(testClass.getEmployees(-5).isEmpty());
    }

    @Test
    void addEmployee() {
        Employee employee = new Employee(61, new Date(100000000), new Date(200000000), "Test", "Java", Gender.F);

        assertEquals(1, testClass.addEmployee(employee));
        assertEquals(0, testClass.addEmployee(employee));
    }

    @Test
    void updateEmployee() {
        Employee employee = new Employee(61, new Date(30000000), null, "Java", "YJS4436", Gender.F);

        assertEquals(1, testClass.updateEmployee(employee));

        employee = new Employee(610, new Date(30000000), null, "Java", "YJS4436", Gender.F);

        assertEquals(0, testClass.updateEmployee(employee));
    }

    @Test
    void deleteEmployee() {
        Employee employee = new Employee(99, new Date(100000000), new Date(200000000), "Test", "Java", Gender.F);

        assertEquals(1, testClass.addEmployee(employee));

        assertEquals(1, testClass.deleteEmployee(99));

        assertEquals(0, testClass.deleteEmployee(99));
    }

    @Test
    void addEmployees() throws SQLException {
        Employee employee = new Employee(99, new Date(100000000), new Date(200000000), "Test", "Java", Gender.F);
        testClass.addEmployee(employee);
        employee = new Employee(100, new Date(100000000), new Date(200000000), "Test", "Java", Gender.F);
        testClass.addEmployee(employee);

        Integer[] ids = new Integer[]{99, 101};
        String[] names = new String[]{"Up1", "Up2"};
        testClass.getEmployees(5).forEach(System.out::println);

        testClass.updateEmployeeNames(ids[0], names[0], null, null);
        testClass.getEmployees(5).forEach(System.out::println);

        testClass.deleteEmployee(99);
        testClass.deleteEmployee(100);
    }
}