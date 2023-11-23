
// getName() - is used to find the file name.
// getAbsolutePath() - is used to get the absolute pathname of the file.
// canRead() -  is used to check whether we can read the data of the file or not.
// createNewFile() -is used to create a new empty file.
// canWrite() - is used to check whether we can write the data into the file or not.
// exists() - is used to check whether the specified file is present or not.
// delete() - is used to delete a file.
// length() - is used to get the size of the file in bytes.
// list() - is used to get an array of the files available in the directory.
// mkdir() - is used for creating a new directory.
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;

public class FileSystem {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        File directory = new File("C:\\Users\\Reejisha\\Desktop\\Task\\Sample");

        try {
            createDirectory(directory);
            File testFile = new File(directory, "testFile.txt");
            createFile(testFile);

            if (testFile.canWrite()) {
                writeAndReadFile(testFile);
                System.out.println("File write successfully");

                if (testFile.canRead()) {
                    writeAndReadFile(testFile);
                    System.out.println("File read successfully");

                } else {
                    System.out.println("I cannot read file");
                }
            } else {
                System.out.println("I cannot write file");
            }

        } catch (IOException e) {
            System.out.println("Error found in directory created.");
            e.printStackTrace();
        }
    }

    private static void createDirectory(File directory) throws IOException {
        if (directory.mkdir()) {
            System.out.println("Directory create successfully.");
            System.out.println("Directory name is" + directory.getName());
            System.out.println("Directory path is " + directory.getAbsolutePath());
        } else {
            System.out.println("Directory already created.");
        }
    }

    private static void createFile(File file) throws IOException {
        if (file.createNewFile()) {
            System.out.println("File successfully created.");
            System.out.println("File name: " + file.getName());
            System.out.println("File path: " + file.getAbsolutePath());
        } else {
            System.out.println("File already exist.");
        }
    }

    private static void writeAndReadFile(File file) throws IOException {
        try {
            FileWriter fw = new FileWriter(file);
            System.out.println("Write any sentence in to file.");
            String sentence = sc.nextLine();
            fw.write(sentence);

        } catch (IOException e) {
            System.out.println("Error occured in the file writer.");
            fw.close();
        }

        try {
            FileReader fr = new FileReader(file);
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
            System.out.println();

        } catch (IOException e) {
            System.out.println("Error occured in the file reader.");
            fr.close();
        }
    }
}