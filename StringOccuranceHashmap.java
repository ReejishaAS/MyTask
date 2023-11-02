import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringOccuranceHashmap {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the input:");
		String input = sc.nextLine();

		String[] words = input.split(" ");
		Map<String, Integer> wordOccurance = new HashMap<>();

		for (String word : words) {
			word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();

			if (!word.isEmpty()) {
				wordOccurance.put(word, wordOccurance.getOrDefault(word, 0) + 1);
			}
		}

		for (Map.Entry<String, Integer> entry : wordOccurance.entrySet()) {
			System.out.println("Word: " + entry.getKey() + " Occurance is " + entry.getValue());
		}
	}
}
