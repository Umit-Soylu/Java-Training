package com.bilgeadam.java.tutorials.oop.polymorphism;

/**
 * A book entity that is or will be published.
 */
public class Book {
    // Name of the book
    private String name;

    // Author of the book
    // Final variables should be initialized either in every constructor or in declaration
    private final String author; // Here author is initialized in every constructor.

    // Reviewer of the book
    private String reviewer;

    // Number of pages.
    private int nbOfPages;

    // State of the book
    private String state; // Preparing, Reviewing, Published

    /**
     * Initial book preparation - state is always 'Preparing'.
     * @param name     Name of the book
     * @param author   Author of the book
     */
    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        setState("Preparing");
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
     *
     * @return name of the reviewer
     */
    public String getReviewer() {
        return reviewer;
    }

    /**
     * Set the reviewer according to criteria based on book type
     * @param reviewer  Reviewer of the Book
     */
    protected void setReviewer(String reviewer) {
        // TODO: Only allow reviewer based on book type.
        this.reviewer = reviewer;
    }

    /**
     *
     * @return Number of pages
     */
    public int getNbOfPages() {
        return nbOfPages;
    }

    /**
     * Set number of pages according to criteria based on book type
     * @param nbOfPages The number of pages
     */
    protected void setNbOfPages(int nbOfPages) {
        // TODO: Set according to type.
        this.nbOfPages = nbOfPages;
    }

    /**
     * This method cannot be Override.
     * @return Current state of the book.
     */
    public final String getState() {
        return state;
    }

    /**
     * Set state of the book
     * @param state Set state of the book - 'Preparing', 'Reviewing', 'Published'
     */
    protected void setState(String state) {
        if (state.equals("Preparing") || state.equals("Reviewing") || state.equals("Published"))
            this.state = state;
        else
            throw new IllegalArgumentException("State is not 'Preparing' or 'Reviewing' or 'Published'");
    }
}
