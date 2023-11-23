import java.io.File;
import java.io.IOException;

public class FileCreate {
    public static void main(String[] args) throws IOException {

        File directory = new File("C:\\Users\\Reejisha\\Desktop\\Task");
        directory.mkdir(); // Create directory

        File file = new File(directory, "testFile.txt");
        try {

            file.createNewFile(); // Create file
            System.out.println("File name " + file.getName());
            System.out.println("File created successfully.");

        } catch (IOException e) {

            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}