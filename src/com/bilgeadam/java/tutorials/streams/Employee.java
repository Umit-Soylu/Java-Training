package com.bilgeadam.java.tutorials.streams;

/**
 * A custom class to be used with Stream Api
 *
 * @implNote this class overrides {@link #equals(Object)} and {@link #hashCode()} in order to store each object according to it's {@link #id}
 */
public class Employee {
    private String firstName = "", lastname = "";
    private final Integer id;

    public Employee(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * A method overriden which is used for {@link Comparable} interface like {@link java.util.Set}
     *
     * @param obj Another object to compare
     * @return {@code true} if both Objects are {@link Employee} and {@link Employee#id} are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employee)
            return this.getId().compareTo(((Employee) obj).getId()) == 0;
        else
            return false;
    }


    /**
     * A method overriden which is used for {@link Comparable} interface like {@link java.util.Set}
     *
     * @return {@link Employee#getId()}
     */
    @Override
    public int hashCode() {
        return this.getId();
    }
}
