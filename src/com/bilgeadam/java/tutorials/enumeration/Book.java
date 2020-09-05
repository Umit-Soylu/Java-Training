package com.bilgeadam.java.tutorials.enumeration;

/**
 * A book entity that is or will be published.
 */
public class Book {
    // Name of the book
    private String name;

    // Author of the book
    // Final variables should be initialized either in every constructor or in declaration
    private final String author; // Here author is initialized in every constructor.

    // State of the book
    private BookStages state; // Preparing, Reviewing, Published

    /**
     * Initial book preparation - state is always 'Preparing'.
     * @param name     Name of the book
     * @param author   Author of the book
     */
    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        setState(BookStages.Preparing);
    }


    /**
     * The book may ready to be published
     * @param name     Name of the book
     * @param author   Author of the book
     * @param state    State of the book - 'Preparing', 'Reviewing', 'Published'
     */
    public Book(String name, String author, String state) {
        this.name = name;
        this.author = author;
        setState(state);
    }

    /**
     * @return name of te book
     */
    public String getName() {
        return name;
    }

    /**
     * Change the name of the book - can only be changed if book is not 'Published'
     * @param name New name
     */
    protected void setName(String name) {
        if (!getState().equalsIgnoreCase("Published"))
            this.name = name;
        else
            throw new IllegalStateException("Book is already published");
    }

    /**
     * This method cannot be Override.
     * @return Current state of the book.
     */
    public final String getState() {
       return this.state.toString();
    }


    /**
     * Set state of the book using ENUM parameters
     *
     * @param state Set state of the book - 'Preparing', 'Reviewing', 'Published'
     */
    protected void setState(BookStages state) {
        this.state = state;
    }

    /**
     * Set state of the book using String as input and converting to ENUM value
     *
     * @param state Set state of the book - 'Preparing', 'Reviewing', 'Published'
     */
    protected void setState(String state) {
        this.state = BookStages.valueOf(state);
    }

}
