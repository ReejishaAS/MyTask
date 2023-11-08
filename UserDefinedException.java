import java.util.Scanner;

class SeniorCitizenFactorException extends Exception {
    public SeniorCitizenFactorException(String message) {
        super(message);
    }
}

public class UserDefinedException {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserDefinedException userDefine = new UserDefinedException();

        try {
            System.out.println("Enter your age to check if you are a senior citizen:");
            int age = sc.nextInt();
            userDefine.checkCitizen(age);

        } catch (SeniorCitizenFactorException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

    public void checkCitizen(int age) throws SeniorCitizenFactorException {
        if (age < 60) {
            throw new SeniorCitizenFactorException("You are not a senior citizen.");
        } else {
            System.out.println("Your are a senior citizen");
        }
    }
}
