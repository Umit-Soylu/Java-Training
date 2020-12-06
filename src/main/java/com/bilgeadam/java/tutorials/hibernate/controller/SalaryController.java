package com.bilgeadam.java.tutorials.hibernate.controller;

import com.bilgeadam.java.tutorials.hibernate.config.SessionFactoryGenerator;
import com.bilgeadam.java.tutorials.hibernate.entities.Employee;
import com.bilgeadam.java.tutorials.hibernate.entities.Roles;
import com.bilgeadam.java.tutorials.hibernate.entities.Salary;
import com.bilgeadam.java.tutorials.hibernate.entities.SalaryTypes;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SalaryController {
    private final SessionFactory sessionFactory;

    public SalaryController() {
        sessionFactory = SessionFactoryGenerator.getInstance().acquireSessionFactoryViaJava();
    }

    /**
     * Adds a new salary to the database
     * @param salary new salary to be added
     * @return id of the salary
     */
    public Long addSalary(Salary salary){
        Long newId = null;

        // Acquire session using factory
        Session session = sessionFactory.openSession();

        // Create transaction - manipulate DB after this.
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            newId = (Long) session.save(salary); // Stores the salary to the DB.

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
     * Return the list of all {@link Salary}
     * @return list of salaries, null if it is empty
     */
    public List<Salary> getSalaries(){
        // Acquire session using factory
        Session session = sessionFactory.openSession();

        // Create transaction - manipulate DB after this.
        Transaction transaction = null;

        // Result list
        List<Salary> salaries = null;

        try{
            transaction = session.beginTransaction();

            // Use java object types (Salary) since it is HQL not SQL (for SQL it is employees)
            salaries = session.createQuery("FROM Salary", Salary.class).list();

            // Commit the transaction
            transaction.commit();
        } catch (Exception exception){
            if (transaction != null)
                transaction.rollback();
        } finally {
            session.close();
        }

        return salaries;
    }

    /**
     * Gets the employee according to id
     * @param id Primary key of the employee
     * @return salary
     */
    public Salary getSalary(long id){
        // Acquire session using factory
        Session session = sessionFactory.openSession();

        // Create transaction - manipulate DB after this.
        Transaction transaction = null;

        // Result list
        Salary salary = null;

        try{
            transaction = session.beginTransaction();
            salary = session.get(Salary.class, id);

            // Commit the transaction
            transaction.commit();
        } catch (Exception exception){
            if (transaction != null)
                transaction.rollback();
        } finally {
            session.close();
        }

        return salary;
    }

    /**
     * Deletes the salary according to id
     * @param id Primary key of the salary
     */
    public void deleteSalary(long id){
        // Acquire session using factory
        Session session = sessionFactory.openSession();

        // Create transaction - manipulate DB after this.
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            // First find the relevant employee
            Salary salary = session.get(Salary.class, id);
            // Delete the employee
            session.delete(salary);

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
     * Updates the salary based on {@link SalaryTypes}
     * @param newSalary updated salary for the type
     * @param type type of the salary
     */
    public void updateSalaryByType(int newSalary, SalaryTypes type){
        // Acquire session using factory
        Session session = sessionFactory.openSession();

        // Create transaction - manipulate DB after this.
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            // First find the relevant employee
            Query query = session.createQuery("FROM Salary AS S WHERE S.type = :salaryType" , Salary.class);
            query.setParameter("salaryType", type);
            Salary salary = (Salary) query.list().get(0);

            // Create new if given typed salary does not exist
            if (salary == null) {
                salary = new Salary();
                salary.setType(type);
            }

            // Update the employee
            salary.setSalary(newSalary);
            session.save(salary);

            // Commit the transaction
            transaction.commit();
        } catch (Exception exception){
            if (transaction != null)
                transaction.rollback();
        } finally {
            session.close();
        }
    }
}
