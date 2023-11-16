import java.util.*;
import java.util.stream.*;

public class EvenStream {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        System.out.println("Enter the array size: ");
        int size = input.nextInt();

        System.out.println("Enter the Array element: ");
        for (int i = 0; i < size; i++) {
            int numbers = input.nextInt();
            list.add(numbers);
        }
        System.out.println("Even numbers without duplicate: ");
        list.stream()
                .filter(num -> num % 2 == 0)
                .distinct()
                .forEach(num -> System.out.println(num));

    }

}