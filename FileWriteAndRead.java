import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriteAndRead {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            File testFile = new File("C:\\Users\\Reejisha\\Desktop\\Task\\Sample\\file.txt");
            testFile.createNewFile();
            System.out.println(testFile.getName() + " created successfully.");

            if (testFile.canWrite()) {
                // Writing
                System.out.println("Enter text to write to the file:");
                String sentence = sc.nextLine();

                try (FileWriter fw = new FileWriter(testFile)) {
                    fw.write(sentence);
                    System.out.println("Write successfully.");
                }

                if (testFile.canRead()) {
                    // Reading
                    try (FileReader fr = new FileReader(testFile)) {
                        int i;
                        while ((i = fr.read()) != -1)
                            System.out.print((char) i);
                        System.out.println("\nSize of the file: " + testFile.length());
                    } catch (IOException e) {
                        System.out.println("Error occurred while reading the file.");
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Cannot read the file.");
                }
            } else {
                System.out.println("Cannot write to the file.");
            }
        } catch (IOException e) {
            System.out.println("Error occurred.");
            e.printStackTrace();
        }
    }
}
