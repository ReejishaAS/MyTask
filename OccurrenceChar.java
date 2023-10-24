import java.util.Scanner;

public class OccurrenceChar {
    public static void main(String[] args) {
        String word;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        word = sc.nextLine();
        int[] occur = new int[word.length()];
        int i, j;

        char character[] = word.toCharArray();

        for (i = 0; i < word.length(); i++) {
            occur[i] = 1;
            for (j = i + 1; j < word.length(); j++) {
                if (character[i] == character[j]) {
                    occur[i]++;
                    character[j] = '0';
                }
            }
        }

        for (i = 0; i < occur.length; i++) {

            System.out.println(character[i] + " is occured for " + occur[i] + " times");
        }
    }
}