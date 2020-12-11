package com.bilgeadam.java.tutorials.hibernate.controller;

import com.bilgeadam.java.tutorials.hibernate.config.SessionFactoryGenerator;
import com.bilgeadam.java.tutorials.hibernate.entities.Department;
import com.bilgeadam.java.tutorials.hibernate.entities.Employee;

import com.bilgeadam.java.tutorials.hibernate.entities.Roles;
import org.hibernate.*;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;


public class EmployeeController {

    private final SessionFactory sessionFactory;

    public EmployeeController() {
        SessionFactoryGenerator generator = SessionFactoryGenerator.getInstance();
        sessionFactory = generator.acquireSessionFactoryViaJava();
    }



    /**
     * Adds a new employee to the DB.
     * @param employee new employee
     * @return employee id - null if not created.
     */
    public Integer addEmployee(Employee employee){
        Integer newId = null;

        // Acquire session using factory
        Session session = sessionFactory.openSession();

        // Create transaction - manipulate DB after this.
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            newId = (Integer) session.save(employee); // Stores the employee to the DB.

            // Commit the transaction
            transaction.commit();
        } catch (Exception exception){
            if (transaction != null)
                transaction.rollback();
        } finally {
            session.close();
        }

        return newId;
    }

    /**
     * Return the list of all {@link Employee}
     * @return list of employees, null if it is empty
     */
    public List<Employee> getEmployees(){
        // Acquire session using factory
        Session session = sessionFactory.openSession();

        // Create transaction - manipulate DB after this.
        Transaction transaction = null;

        // Result list
        List<Employee> employees = null;

        try{
            transaction = session.beginTransaction();

            // Use java object types (Employee) since it is HQL not SQL (for SQL it is employees)
            employees = session.createQuery("FROM Employee", Employee.class).list();

            // Commit the transaction
            transaction.commit();
        } catch (Exception exception){
            if (transaction != null)
                transaction.rollback();
        } finally {
            session.close();
        }

        return employees;
    }

    /**
     * Gets the employee according to id
     * @param id Primary key of the employee
     * @return employee
     */
    public Employee getEmployee(int id){
        // Acquire session using factory
        Session session = sessionFactory.openSession();

        // Create transaction - manipulate DB after this.
        Transaction transaction = null;

        // Result list
        Employee employee = null;

        try{
            transaction = session.beginTransaction();
            employee = session.get(Employee.class, id);

            // Commit the transaction
            transaction.commit();
        } catch (Exception exception){
            if (transaction != null)
                transaction.rollback();
        } finally {
            session.close();
        }

        return employee;
    }

    /**
     * Deletes the employee according to id
     * @param id Primary key of the employee
     */
    public void deleteEmployee(int id){
        // Acquire session using factory
        Session session = sessionFactory.openSession();

        // Create transaction - manipulate DB after this.
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            // First find the relevant employee
            Employee employee = session.get(Employee.class, id);
            // Delete the employee
            session.delete(employee);

            // Commit the transaction
            transaction.commit();
        } catch (Exception exception){
            if (transaction != null)
                transaction.rollback();
        } finally {
            session.close();
        }
    }

    /**
     * Updates the role of the employee
     * @param id Id of the employee
     * @param newRole new role for the employee
     */
    public void updateEmployeeRole(int id, Roles newRole){
        // Acquire session using factory
        Session session = sessionFactory.openSession();

        // Create transaction - manipulate DB after this.
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            // First find the relevant employee
            Employee employee = session.get(Employee.class, id);

            // Update the employee
            employee.setCurrentRole(newRole);
            session.save(employee);

            // Commit the transaction
            transaction.commit();
        } catch (Exception exception){
            if (transaction != null)
                transaction.rollback();
        } finally {
            session.close();
        }
    }

    /**
     * Gets the employee departments according to id
     * @param id Primary key of the employee
     * @return departments of the employee
     */
    public Set<Department> getEmployeeDepartments(int id){
        // Acquire session using factory
        Session session = sessionFactory.openSession();

        // Create transaction - manipulate DB after this.
        Transaction transaction = null;

        // Result list
        Set<Department> departments = null;

        try{
            transaction = session.beginTransaction();
            //departments =
            Employee employee = session.get(Employee.class, id);//.getDepartments();
            Hibernate.initialize(employee.getDepartments());
            departments = employee.getDepartments();
            // Commit the transaction
            transaction.commit();
        } catch (Exception exception){
            if (transaction != null)
                transaction.rollback();
        } finally {
            session.close();
        }

        return departments;
    }
}
