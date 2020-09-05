package com.bilgeadam.java.tutorials.oop.polymorphism;


/**
 * Novel is type of a book
 * This class cannot be extended - because it is final.
 */
public final class Novel extends Book {

    // Adventure, Science Fiction, Romantic
    String type, secondType;


    // A novel can have at least 100 and at most 1000 pages.
    private static final short minPage = 100;
    private static final short maxPage = 1000;

    /**
     * A novel that is in 'Preparing' state.
     * @param name   Name of the Novel
     * @param author Author of the Novel
     */
    public Novel(String name, String author) {
        // Call constructor of Book class.
        super(name, author);
    }


    /**
     * A novel that is ready to be 'published' or 'reviewed'
     * @param name   Name of the novel
     * @param author Author of the novel
     * @param state  State of the novel - 'Published' or 'Reviewing'
     */
    public Novel(String name, String author, String state) {
        // Call constructor of Book class.
        super(name, author, state);
    }

    /**
     * Set number of pages in between 100 .. 1000
     * This is an example of Overriding method.
     * @param nbOfPages The number of pages of the Novel
     */
    @Override
    protected void setNbOfPages(int nbOfPages) {
        if (nbOfPages >= minPage && nbOfPages <= maxPage) {
            // Call the method of Book class. Cannot access private methods & variables.
            // Protected methods & variables can only be accessed if within same package.
            super.setNbOfPages(nbOfPages);
        } else
            throw new IllegalArgumentException("Pages should be in between " + minPage + " and " + maxPage);
    }

    /**
     *
     * @return type of Novel
     */
    public String getType() {
        return type;
    }

    /**
     * This is method overloading example
     * @param type Type of the novel - 'Adventure', 'Science Fiction', 'Romantic'
     */
    public void setType(String type) {
        if (checkNovelType(type))
            this.type = type;
        else
            throw new IllegalArgumentException("Type is not correct");
    }

    /**
     * This is method overloading example
     * @param type              Additional book type to be added - 'Adventure', 'Science Fiction', 'Romantic'
     * @param isAdditionalType  Should be true
     */
    public void setType(String type, boolean isAdditionalType){
        if (this.getType() != null && !this.getType().isEmpty() && isAdditionalType){
            if (checkNovelType(type))
                this.secondType = type;
            else
                throw new IllegalArgumentException("Second type is wrong");
        } else
            throw new IllegalArgumentException("First type is not initialized yet or isAdditionalType is 'false'");

    }

    /**
     *
     * @return the additional type of the book.
     */
    public String getSecondType() {
        return secondType;
    }

    /**
     * This method verifies the Novel type is valid.
     * @param type Type of the novel
     * @return 'True' if novel type is valid; 'False' otherwise.
     */
    private boolean checkNovelType(String type){
        return type.equalsIgnoreCase("Adventure") ||
                type.equalsIgnoreCase("Science Fiction") ||
                type.equalsIgnoreCase("Romantic");
    }

//    /**
//     * This method cannot be Override.
//     *
//     * @return Current state of the book.
//     */
//    @Override
//    public String getState() {
//        return super.getState() + "-Novel";
//    }
//

}
