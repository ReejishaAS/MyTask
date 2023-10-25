import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Swap {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array limit:");
        int limit = sc.nextInt();

        System.out.println("Enter the elements to the ArrayList:");
        for (int i = 0; i < limit; i++) {
            int num = sc.nextInt();
            numbers.add(num);
        }

        System.out.println("ArrayList is : " + numbers);

        System.out.println("Enter the index of swapping elements:");
        int index1 = sc.nextInt();
        int index2 = sc.nextInt();

        Collections.swap(numbers, index1, index2);

        System.out.println("Swaped ArrayList is : " + numbers);

    }
}
