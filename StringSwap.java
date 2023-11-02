import java.util.Scanner;

public class StringSwap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first string:");
        String firstString = sc.nextLine();

        System.out.println("Enter the second string:");
        String seconString = sc.nextLine();

        System.out.println("Before swapping strings:");
        System.out.println("First string=" + firstString);
        System.out.println("Second string=" + seconString);

        firstString = firstString + seconString;
        seconString = firstString.substring(0, firstString.length() - seconString.length());
        firstString = firstString.substring(seconString.length());

        System.out.println("After swapping strings:");
        System.out.println("str1=" + firstString);
        System.out.println("str2=" + seconString);

    }
}