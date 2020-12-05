package com.bilgeadam.java.tutorials.jdbc.entities;

import java.util.Date;

public class Employee {
    private final Integer id; //emp_no
    private final Date birthDay, hireDate;
    private final String firstName, lastName;
    private final Gender gender;

    public Employee(Integer id, Date birthDay, Date hireDate, String firstName, String lastName, Gender gender) {
        this.id = id;
        this.birthDay = birthDay;
        this.hireDate = hireDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", birthDay=" + birthDay +
                ", hireDate=" + hireDate +
                ", id=" + id +
                '}';
    }
}
