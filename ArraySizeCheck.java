import java.util.Scanner;

public class ArraySizeCheck {

    public void checkSize(int size) {
        try {
            if (size < 0) {
                throw new NegativeArraySizeException();

            }

        }

        catch (NegativeArraySizeException e) {
            System.out.println("Error: Array size cann't be negative");

        }
    }

    public static void main(String[] args) {
        ArraySizeCheck check = new ArraySizeCheck();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array size");
        int size = sc.nextInt();
        check.checkSize(size);

    }

}
