import java.util.Scanner;

public class SumOfDigit {
    public static void main(String[] args) {
        int num, reminder, sum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        num = sc.nextInt();
        while (num > 0) {
            reminder = num % 10;
            sum = sum + reminder;
            num = num / 10;
        }
        System.out.println("Sum of the given digit is = " + sum);
    }
}