package com.bilgeadam.java.tutorials.enumeration;

/**
 * These are the acceptable Book Stages
 */
public enum BookStages {
    // All values are Public, Static and Final
    Preparing,
    Reviewing,
    Published,
    Cancelled;


    /**
     * Counter of the elements - This method belongs to the BookStages Enumeration itself
     *
     * @return Total number of Enum size.
     */
    public static int numberOfElements() {
        return 4;
    }


    /**
     * This is a custom method that belongs to each ENUM value separately.
     *
     * Returns the name of this enum constant, as contained in the
     * declaration.  This method may be overridden, though it typically
     * isn't necessary or desirable.  An enum type should override this
     * method when a more "programmer-friendly" string form exists.
     *
     * @return the name of this enum constant appended with ' of BookStages'
     */
    @Override
    public String toString() {
        return super.toString() + " of BookStages";
    }

    /**
     * This is a custom method that belongs to each ENUM value separately.
     *
     * @return 'Test' value
     */
    public String myCustomMethod(){
        return "Test";
    }
}
