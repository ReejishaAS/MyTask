import java.util.*;

public class TryCatchFinally {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");
        int number = sc.nextInt();
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