public class TryCatchFinally {
    public static void main(String[] args) {
        int number = 10;
        int result = 0;
        try {
            result = number / result;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.err.println("ArithmeticException: " + e);
        } finally {
            System.out.println("Finally block executed");
        }
    }
}