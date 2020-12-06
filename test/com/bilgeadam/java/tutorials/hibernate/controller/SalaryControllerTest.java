package com.bilgeadam.java.tutorials.hibernate.controller;

import com.bilgeadam.java.tutorials.hibernate.entities.Salary;
import com.bilgeadam.java.tutorials.hibernate.entities.SalaryTypes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SalaryControllerTest {
    SalaryController testClass;

    @BeforeEach
    void setUp() {
        testClass = new SalaryController();
    }

    @AfterEach
    void tearDown() {
        List<Salary> salaries = testClass.getSalaries();
        salaries.forEach(System.out::println);
        salaries.forEach(e -> testClass.deleteSalary(e.getId()));

        testClass = null;
    }

    /**
     * Support function for creating salaries
     * @param newSalary salary
     * @return created salary object
     */
    private Salary createSalary(int newSalary){
        Salary salary = null;
        try {
            salary = new Salary(newSalary);
        } catch (Exception e) {
            fail("Test cannot start");
        }
        return salary;
    }

    /**
     * Support function for creating salaries
     * @param newSalary salary
     * @param type type of the salary
     * @return created salary object
     */
    private Salary createSalary(int newSalary, SalaryTypes type){
        Salary salary = null;
        try {
            salary = new Salary(newSalary);
            salary.setType(type);
        } catch (Exception e) {
            fail("Test cannot start");
        }
        return salary;
    }

    @Test
    void addSalary() {
        Long id;

        id = testClass.addSalary(createSalary(3250));
        assertNotNull(id);
    }

    @Test
    void getSalary(){
        Long id;
        id = testClass.addSalary(createSalary(1000, SalaryTypes.Default));

        assertNotNull(testClass.getSalary(id));

        id = testClass.addSalary(createSalary(2500, SalaryTypes.Default));
        assertNull(testClass.getSalary(id));
    }

    @Test
    void getSalaries() {
        testClass.addSalary(createSalary(5000));
        testClass.addSalary(createSalary(10000));

        List<Salary> salaries = testClass.getSalaries();
        salaries.forEach(System.out::println);
        assertFalse(salaries.isEmpty());
    }

    @Test
    void deleteSalary() {
        Long id = testClass.addSalary(createSalary(5000));

        testClass.deleteSalary(id);
        assertNull(testClass.getSalary(id));
    }

    @Test
    void updateSalaryByType() {
        Long id = testClass.addSalary(createSalary(2500, SalaryTypes.Min));

        Salary salary = testClass.getSalary(id);
        assertEquals(2500L, salary.getSalary());

        testClass.updateSalaryByType(3500, SalaryTypes.Min);
        salary = testClass.getSalary(id);
        assertEquals(3500L, salary.getSalary());

        testClass.updateSalaryByType(50000, SalaryTypes.Custom);
    }
}