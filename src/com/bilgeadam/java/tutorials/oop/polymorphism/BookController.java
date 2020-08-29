package com.bilgeadam.java.tutorials.oop.polymorphism;

/**
 * This Controller Class will dynamically manipulate any book class and its extended class.
 */
public class BookController {

    /**
     * This is a method for setting the name of the Book.
     * @param theBook The book itself
     * @param name    Name of the book
     */
    public void setBookName(Book theBook, String name){
        theBook.setName(name);
    }

    /**
     * This is a method for setting the reviewer of the Book.
     * @param theBook  The book itself
     * @param reviewer Reviewer of the book
     */
    public void setBookReviewer(Book theBook, String reviewer){
        theBook.setReviewer(reviewer);
    }

    /**
     * This is an example for Dynamic Binding - Dynamic Binding occurs only for override methods with call of super class type.
     * SetNbOfPages is an Override Method and theBook can be Novel or Book class.
     * @param theBook   The book itself
     * @param nbOfPages Number of pages
     */
    public void setBookPages(Book theBook, int nbOfPages){
        theBook.setNbOfPages(nbOfPages);
    }

    /**
     * This is an example for Dynamic Binding - Dynamic Binding occurs only for override methods with call of super class type.
     * SetState is an Override Method and theBook can be Novel or Tale class.
     *
     * @param theBook  The book itself
     * @param state    State of the book.
     */
    public void setBookState(Book theBook, String state){
        theBook.setState(state);
    }



}
