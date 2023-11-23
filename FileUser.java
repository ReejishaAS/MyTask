import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileUser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {

            File file = new File("C:\\Users\\Reejisha\\Desktop\\Task\\tes.txt");
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            System.out.println("Write any sentence into file:");
            String sentence = sc.nextLine();
            fw.write(sentence);
            System.out.println("Write Successfully.");
            fw.close();

            FileReader fr = new FileReader(file);
            int i;
            while ((i = fr.read()) != -1)
                System.out.print((char) i);
            fr.close();
        } catch (IOException e) {
            System.out.println("Error has occurred");
            e.printStackTrace();
        }
    }

}