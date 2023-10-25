import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListWithLimit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size (n) of the ArrayList:");
        int n = sc.nextInt();

        ArrayList<Integer> arrayList = new ArrayList<>(n);

        System.out.println("Enter elements to add to the ArrayList (type 'exit' to stop):");
        int count = 0;

        while (count < n) {
            System.out.print("Enter an element: ");
            String input = sc.next();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                int element = Integer.parseInt(input);
                arrayList.add(element);
                count++;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter an integer.");
            }
        }

        if (count >= n) {
            System.err.println("Error: ArrayList is full. Limit reached.");
        } else {
            System.out.println("ArrayList elements: " + arrayList);
        }

        sc.close();
    }
}
