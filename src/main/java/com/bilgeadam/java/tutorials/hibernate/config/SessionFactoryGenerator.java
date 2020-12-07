package com.bilgeadam.java.tutorials.hibernate.config;

import com.bilgeadam.java.tutorials.hibernate.entities.Employee;
import com.bilgeadam.java.tutorials.hibernate.entities.Salary;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class SessionFactoryGenerator {
    private static SessionFactoryGenerator instance;

    /**
     * Singleton pattern
     * @return instance of this class
     */
    public static SessionFactoryGenerator getInstance() {
        if (instance == null)
            instance = new SessionFactoryGenerator();
        return instance;
    }

    private SessionFactoryGenerator() {
    }

    /**
     * Acquires the session factory
     * @return Session factory
     */
    public SessionFactory acquireSessionFactoryViaXml(){
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().
                //configure("/hibernate.cfg.xml").
                        configure("/main/resources/hibernate.cfg.xml").
                        build();

        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        return meta.getSessionFactoryBuilder().build();
    }

    /**
     * Generates session factory using {@link Configuration} and {@link Properties}
     * @return Session factory
     */
    public SessionFactory acquireSessionFactoryViaJava(){
        SessionFactory result = null;

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernate_tutorial");
        properties.setProperty("hibernate.connection.username", "umitsoylu");
        properties.setProperty("hibernate.connection.password", "");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        //properties.setProperty("hibernate.hbm2ddl.auto", "create");
        //properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");

        Configuration configuration = new Configuration();
        configuration.setProperties(properties);

        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Salary.class);

        try {
            result = configuration.buildSessionFactory();
        } catch (HibernateException exception){
            exception.printStackTrace();
        }

        return result;
    }

    public SessionFactory acquireSessionFactoryViaProperties() {
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
}
