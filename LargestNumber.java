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

        if ((firstNumber > secondNumber)) {
            if (firstNumber > thirdNumber) {
                System.out.println("largest number is " + firstNumber);
            } else {
                System.out.println("Largest number is " + thirdNumber);
            }
        } else {
            if (secondNumber > thirdNumber) {
                System.out.println("Largest number is " + secondNumber);
            } else {
                System.out.println("Largest number is " + thirdNumber);
            }
        }
    }
}