import java.util.Scanner;

public class LargestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array size ");
        int size = sc.nextInt();
        System.out.println("Enter the array elements: ");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }
        int large = array[0];
        int i;
        for (i = 0; i < array.length; i++) {
            if (array[i] > i) {
                large = array[i];
            }
        }
        System.out.println("Largest element in given array is " + large);
    }
}