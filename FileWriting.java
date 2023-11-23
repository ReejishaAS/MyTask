import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;

public class FileWriting {
    public static void main(String[] args) {
        FileOutputStream fout = null;

        try {

            fout = new FileOutputStream("C:\\Users\\Reejisha\\Desktop\\Task\\file.txt");
            String sentenceString = "Hai java program";
            byte sentence[] = sentenceString.getBytes();
            fout.write(sentence);
            System.out.println(sentenceString);
            System.out.println("File Created Successfully.");
        } catch (IOException e) {
            System.out.println("Exception occured" + e.getMessage());
        } finally {
            try {
                fout.close();
            } catch (IOException e) {
                System.out.println("Exception occured" + e.getMessage());
            }
        }
    }
}