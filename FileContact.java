import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ContactInfo {
    int id;
    String firstName;
    String lastName;
    long phoneNumber;
    String email;

    public ContactInfo(int id, String firstName, String lastName, long phoneNumber, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getContactId() {
        return id;
    }
}

public class FileContact {
    public static void main(String[] args) {

        // Create File
        File file = new File("C:\\Users\\Reejisha\\Desktop\\Task\\File\\contactInfo.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<ContactInfo> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        BufferedWriter bufferedWriter = null;
        BufferedReader reader = null;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            reader = new BufferedReader(new FileReader(file));
            while (true) {
                System.out.println(
                        " 1.Add Contact\n 2.Update Contact\n 3.Delete Contact\n 4.List Contact/ Show Log\n 5.Get Contact\n 6.Exit\n");
                System.out.println("Select your choice:");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        System.out.println("Enter the id:");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter the First Name:");
                        String firstName = sc.nextLine();
                        System.out.println("Enter the Last Name:");
                        String lastName = sc.nextLine();
                        System.out.println("Enter the Phone number:");
                        long phoneNumber = sc.nextLong();
                        sc.nextLine();
                        System.out.println("Enter the Email id:");
                        String email = sc.nextLine();

                        list.add(new ContactInfo(id, firstName, lastName, phoneNumber, email));

                        // Write to file
                        try {
                            for (int i = 0; i < list.size(); i++) {
                                bufferedWriter
                                        .write(list.get(i).id + "  " + list.get(i).firstName + list.get(i).lastName
                                                + "  "
                                                + list.get(i).phoneNumber + "  " + list.get(i).email + "\n");
                            }
                            bufferedWriter.close();

                            System.out.println("Contact add successfully..");
                        } catch (Exception e) {
                            System.out.println("Error..");
                        }
                        break;

                    case 2:
                        System.out.println("Enter the updated contact user id:");
                        int contactId = sc.nextInt();
                        int indexToUpdate = -1;

                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getContactId() == contactId) {
                                indexToUpdate = i;
                                break;
                            }
                        }

                        if (indexToUpdate != -1) {
                            System.out.println("Enter the first Name to be updated:");
                            String updateFirstName = sc.next();
                            System.out.println("Enter the last Name to be updated:");
                            String updatedLastName = sc.next();
                            System.out.println("Enter the phone to be updated:");
                            long updatedPhoneNumber = sc.nextLong();
                            System.out.println("Enter the email to be updated:");
                            String updatedEmail = sc.next();

                            // Update the existing contact
                            ContactInfo updatedContact = new ContactInfo(contactId, updateFirstName, updatedLastName,
                                    updatedPhoneNumber, updatedEmail);
                            list.set(indexToUpdate, updatedContact);

                        } else {
                            System.out.println("Contact ID not found.");
                        }

                        // Update the file
                        try {
                            // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                            for (int j = 0; j < list.size(); j++) {
                                bufferedWriter
                                        .write(list.get(j).id + " " + list.get(j).firstName + list.get(j).lastName
                                                + "  "
                                                + list.get(j).phoneNumber + "  "
                                                + list.get(j).email + "\n");
                            }
                            // bufferedWriter.close();

                            System.out.println("Contact updated successfully.");
                        } catch (Exception e) {
                            System.out.println("Error updating contacts to file:" + e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.println("Enter the contact ID to delete:");
                        int deleteId = sc.nextInt();
                        sc.nextLine();
                        // Delete the contact
                        boolean removed = list.removeIf(contact -> contact.getContactId() == deleteId);

                        // Again update the file
                        if (removed) {
                            try {
                                for (ContactInfo contact : list) {
                                    bufferedWriter.write(
                                            contact.id + "  " + contact.firstName + " " + contact.lastName + "  "
                                                    + contact.phoneNumber
                                                    + "  "
                                                    + contact.email + "\n");
                                }
                                System.out.println("Contact deleted successfully.");
                            } catch (IOException e) {
                                System.out.println("Error delete contacts to file.");
                                e.printStackTrace();
                            }
                        } else {
                            System.out.println("Contact ID not found.");
                        }
                        break;
                    case 4:
                        // List the file
                        System.out.println("Contact List/Show Log:");
                        try {
                            String line;
                            while ((line = reader.readLine()) != null) {
                                System.out.println(line);
                            }
                        } catch (IOException e) {
                            System.out.println("Error..");
                        }
                        break;
                    case 5:
                        System.out.println("Which contact you want?");
                        int searchId = sc.nextInt();
                        sc.nextLine();
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getContactId() == searchId) {
                                System.out
                                        .println(list.get(i).id + "  " + list.get(i).firstName + list.get(i).lastName
                                                + "  "
                                                + list.get(i).phoneNumber + "  "
                                                + list.get(i).email + "\n");
                                break;
                            }
                        }

                        break;
                    case 6:
                        System.out.println("Exit.");
                        sc.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }

            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing resources: " + e.getMessage());
                e.printStackTrace();
            }
        }

    }

}