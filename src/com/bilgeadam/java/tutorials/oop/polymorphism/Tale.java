package com.bilgeadam.java.tutorials.oop.polymorphism;

/**
 * Tale is type of a Book
 * This class cannot be extended - because it is final.
 */
public final class Tale extends Book {

    /**
     * The Tale may ready to be published
     *
     * @param name   Name of the tale
     * @param author Author of the tale
     * @param state  State of the tale - 'Preparing', 'Reviewing', 'Published'
     */
    public Tale(String name, String author, String state) {
        super(name, author, state);
    }

    // TODO: Assume there are other properties in tales.


    /**
     * Set state of the Tale
     *
     * @param state Set state of the Tale - 'Reviewing', 'Published'
     */
    @Override
    protected void setState(String state) {
        if (state.equals("Reviewing") || state.equals("Published"))
            super.setState(state); //Will call Book's setState.
        else
            throw new IllegalArgumentException("Tale state can only be 'Reviewing', 'Published'");
    }
}
