package com.bilgeadam.java.tutorials.hibernate.controller;

import com.bilgeadam.java.tutorials.hibernate.entities.Employee;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import java.io.IOException;
import java.util.Properties;


public class EmployeeController {

    private final SessionFactory sessionFactory;

    public EmployeeController() {
        sessionFactory = acquireSessionFactoryViaJava();
    }

    /**
     * Acquires the session factory
     * @return Session factory
     */
    private SessionFactory acquireSessionFactoryViaXml(){
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().
                //configure("/hibernate.cfg.xml").
                configure("/main/resources/hibernate.cfg.xml").
                build();

        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        return meta.getSessionFactoryBuilder().build();
    }

    private SessionFactory acquireSessionFactoryViaJava(){
        SessionFactory result = null;

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernate_tutorial");
        properties.setProperty("hibernate.connection.username", "umitsoylu");
        properties.setProperty("hibernate.connection.password", "");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        //properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");

        Configuration configuration = new Configuration();
        configuration.setProperties(properties);

        configuration.addAnnotatedClass(Employee.class);

        try {
            result = configuration.buildSessionFactory();
        } catch (HibernateException exception){
            exception.printStackTrace();
        }

        return result;
    }

    private SessionFactory acquireSessionFactoryViaProperties() {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        //load properties file
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        configuration.setProperties(properties);

        // Return session factory
        return configuration.buildSessionFactory();
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
            transaction.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }

        return newId;
    }
}
