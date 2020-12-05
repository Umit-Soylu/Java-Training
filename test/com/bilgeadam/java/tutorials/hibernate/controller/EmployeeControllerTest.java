package com.bilgeadam.java.tutorials.hibernate.controller;

import com.bilgeadam.java.tutorials.hibernate.entities.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


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

        assertNotNull(testClass.addEmployee(employee));
    }
}