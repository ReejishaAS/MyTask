
import java.text.NumberFormat;
import java.util.Scanner;

public class NumberToWordsConverter {

    public static final String[] units = { "", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
            "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen" };

    public static final String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
            "Seventy", "Eighty", "Ninety" };

    public static String convert(final int n) {
        if (n < 0) {
            return "Minus " + convert(-n);
        }

        if (n < 20) {
            return units[n];
        }
        return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
    }

    public static void main(final String[] args) {

        int n;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number to convert into word: ");
        n = input.nextInt();
        System.out.println(convert(n));

    }

}