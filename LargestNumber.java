import java.util.Scanner;

public class LargestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first number");
        int firstNumber = sc.nextInt();

        System.out.println("Enter the second number");
        int secondNumber = sc.nextInt();

        System.out.println("Enter the third number");
        int thirdNumber = sc.nextInt();

        int largestNumber;

        if (firstNumber > secondNumber) {
            if (firstNumber > thirdNumber) {
                largestNumber = firstNumber;
            } else {
                largestNumber = thirdNumber;
            }
        } else {
            if (secondNumber > thirdNumber) {
                largestNumber = secondNumber;
            } else {
                largestNumber = thirdNumber;
            }
        }

        System.out.println("Largest number is " + largestNumber);
    }
}
