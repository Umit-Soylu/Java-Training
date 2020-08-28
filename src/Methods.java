public class Methods {

    // This is the default method java will call for starting the execution of this class. (Entry point)
    public static void main(String[] args) {
        int x;

        testMethod();

        x = testReturnMethod();
        System.out.println("x = " + x);
    }

    // This is a demo method which will be called from main method.
    private static void testMethod(){
        System.out.println("This is a testMethod");
    }

    private static int testReturnMethod(){
        System.out.println("This is a testReturnMethod which returns a value");
        return 2; // Return is the keyword. The values should match with 'int' as defined in method name.
    }
}
