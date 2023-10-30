import java.util.Scanner;

public class ArraySizeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array size");
        try {
            int size = sc.nextInt();
            if (size < 0) {
                throw new NegativeArraySizeException();

            }

        }

        catch (NegativeArraySizeException e) {
            System.out.println("Error: Array size cann't be negative");

        }
    }

}