import java.util.Scanner;

class SeniorCitizenFactorException extends Exception {
    public SeniorCitizenFactorException(String message) {
        super(message);
    }
}

public class UserDefinedException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your age to check if you are a senior citizen:");

        try {
            int age = sc.nextInt();
            if (age < 60) {
                throw new SeniorCitizenFactorException("You are not a senior citizen.");
            }

        } catch (SeniorCitizenFactorException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}
