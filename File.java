import java.io.File;
import java.io.IOException;

public class FileSystem {
    public static void main(String[] args) {
        try {
            File file = new File("File.txt");
            if (file.createNewFile()) {
                System.out.println("File created " + file.getName());
            } else {
                System.out.println("File already exit");
            }

        } catch (IOException e) {
            System.out.println("Error has occurred.");
            e.printStackTrace();
        }
    }
}