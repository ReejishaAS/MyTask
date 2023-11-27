import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CSVtInfo {
    String firstName;
    String lastName;
    long phoneNumber;
    String email;

    public CSVtInfo(String firstName, String lastName, long phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}

public class FileCSV {
    public static void main(String[] args) {

        // Create File
        File file = new File("C:\\Users\\Reejisha\\Desktop\\Task\\File\\contactInfo.csv");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<CSVtInfo> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the First Name:");
        String firstName = sc.nextLine();
        System.out.println("Enter the Last Name:");
        String lastName = sc.nextLine();
        System.out.println("Enter the Phone number:");
        long phoneNumber = sc.nextLong();
        sc.nextLine();
        System.out.println("Enter the Email id:");
        String email = sc.nextLine();
        list.add(new CSVtInfo(firstName, lastName, phoneNumber, email));

        // Write to file
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < list.size(); i++) {
                bufferedWriter
                        .write(list.get(i).firstName + "," + list.get(i).lastName
                                + ","
                                + list.get(i).phoneNumber + "," + list.get(i).email + "\n");
            }
            bufferedWriter.close();

            System.out.println("Contact add successfully..");
        } catch (Exception e) {
            System.out.println("Error.." + e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error..");
        }

    }

}