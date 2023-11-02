import java.util.Scanner;

public class RightRotateArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the array size:");
        int size = sc.nextInt();

        System.out.println("Enter the position to right rotate:");
        int position = sc.nextInt();

        System.out.println("Enter the array elements:");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println("Array is:");
        for (int element : array) {
            System.out.print(element + " ");
        }

        rightRotate(array, position);

        System.out.println("\nRight rotated array is:");
        for (int element : array) {
            System.out.print(element + " ");
        }
    }

    public static void rightRotate(int[] arr, int pos) {
        int arrayLength = arr.length;
        pos = pos % arrayLength;
        int[] temp = new int[pos];

        for (int i = 0; i < pos; i++) {
            temp[i] = arr[arrayLength - pos + i];
        }

        for (int i = arrayLength - 1; i >= pos; i--) {
            arr[i] = arr[i - pos];
        }

        for (int i = 0; i < pos; i++) {
            arr[i] = temp[i];
        }
    }
}
