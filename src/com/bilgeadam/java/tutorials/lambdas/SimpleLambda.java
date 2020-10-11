package com.bilgeadam.java.tutorials.lambdas;

public class SimpleLambda {
    private final Homeworks homework;
    private final Housework housework;

    /**
     * This constructor initializes two functional interface {@link Housework} and {@link Homeworks}
     */
    public SimpleLambda() {
        homework = LessonName -> {
            printMyName();
            System.out.println(LessonName + " is done");
            System.out.println("Waiting more homeworks");
        };

        housework = () -> {
            printMyName();
            System.out.println("Too many housework to do");
            System.out.println("Total works done:" + Housework.nbOfJobs);
        };
    }

    /**
     * This method prints name of itself
     */
    public static void printMyName(){
        System.out.println("This is " + SimpleLambda.class.getName());
    }

    /**
     * Generates a runnable result
     *
     * @return A lambda process to be used
     */
    public Runnable generateWork(){
        return ()-> {
            System.out.println("This is lambda execution");
            printMyName();
        };
    }

    /**
     * This method runs the given lambda
     *
     * @param runnable A runnable lambda to be executed
     */
    public void processLambda(Runnable runnable) {
        runnable.run();
    }


    public void executeHomework() {
        homework.doHomework("Java");
    }

    public void executeHousework(){
        housework.doHousework();

    }
}
