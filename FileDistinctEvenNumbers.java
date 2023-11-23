import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileDistinctEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File testFile1 = new File("C:\\Users\\Reejisha\\Desktop\\Task\\File\\testFile1.txt");

        try {
            testFile1.createNewFile();
            List<Integer> inputNumbers = new ArrayList<>();

            // Write numbers to file
            FileWriter fw = new FileWriter(testFile1);
            BufferedWriter bw = new BufferedWriter(fw);

            try {
                System.out.println("How many numbers do you want to write to the file?");
                int size = sc.nextInt();
                System.out.println("Enter the numbers:");

                for (int i = 0; i < size; i++) {
                    int number = sc.nextInt();

                    bw.write(Integer.toString(number));
                    bw.newLine();
                    inputNumbers.add(number);
                }

                System.out.println("Write successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while writing to the file.");
                e.printStackTrace();
            } finally {
                bw.close();
                fw.close();
            }

            // Filter even numbers using Java streams
            List<Integer> distinctEvenNumbers = inputNumbers.stream()
                    .filter(num -> num % 2 == 0)
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());

            // Write distinct even numbers back to the file
            try (BufferedWriter updated = new BufferedWriter(new FileWriter(testFile1))) {
                for (int i = 0; i < distinctEvenNumbers.size(); i++) {
                    updated.write(Integer.toString(distinctEvenNumbers.get(i)));
                    updated.newLine();
                }
                System.out.println("Distinct even numbers written back to the file successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while updating the file.");
                e.printStackTrace();
            }

            // Read numbers from the file
            FileReader fr = new FileReader(testFile1);
            BufferedReader br = new BufferedReader(fr);

            try {
                String line;
                System.out.println("Numbers in the file after filtering even numbers:");
                while ((line = br.readLine()) != null) {
                    try {
                        int number = Integer.parseInt(line);
                        System.out.print(number + "\t");
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping non-integer value: " + line);
                    }
                }
                System.out.println("\nRead successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while reading from the file.");
                e.printStackTrace();
            } finally {
                br.close();
                fr.close();
            }

        } catch (IOException e) {
            System.out.println("Error occurred while creating the file.");
            e.printStackTrace();
        }
    }
}
