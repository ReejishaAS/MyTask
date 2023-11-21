import java.io.File;
import java.io.IOException;

public class FileSystem {
    public static void main(String[] args)throws IOException {
        // Create file
        File testFile = new File("C:\\Users\\Reejisha\\Desktop\\Task\\testFile.txt");

        try {
            // Check if the file doesn't exist, then create it
            if (!testFile.exists()) {
                testFile.createNewFile();
                    System.out.println("File created successfully.");
                
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
