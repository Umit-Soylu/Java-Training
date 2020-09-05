package com.bilgeadam.java.tutorials.enumeration;

/**
 * These are the acceptable Book Stages
 */
public enum BookStages {
    // All values are Public, static and final
    Preparing,
    Reviewing,
    Published,
    Cancelled;


    /**
     * Counter of the elements
     * @return Total number of Enum size.
     */
    public static int numberOfElements() {
        return 4;
    }


    /**
     * Returns the name of this enum constant, as contained in the
     * declaration.  This method may be overridden, though it typically
     * isn't necessary or desirable.  An enum type should override this
     * method when a more "programmer-friendly" string form exists.
     *
     * @return the name of this enum constant
     */
    @Override
    public String toString() {
        return super.toString() + " of BookStages";
    }

    public String myCustomMethod(){
        return "Test";
    }
}
