import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class DuplicateItemException extends Exception {
    public DuplicateItemException(String message) {
        super(message);
    }
}

class LibraryItem {
    private String title;
    private String author;

    public LibraryItem(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

    public String getTitle() {
        return title;
    }
}

class Book extends LibraryItem {
    private int year;
    private String isbn;
    private int chapterCount;

    public Book(String title, String author, int year, String isbn, int chapterCount) {
        super(title, author);
        this.year = year;
        this.isbn = isbn;
        this.chapterCount = chapterCount;
    }

    public void displayInfo() {
        System.out.println("Book Details:");
        super.displayInfo();
        System.out.println("Year: " + year);
        System.out.println("ISBN: " + isbn);
        System.out.println("Chapter Count: " + chapterCount);
    }
}

class Magazine extends LibraryItem {
    private String issueDate;

    public Magazine(String title, String author, String issueDate) {
        super(title, author);
        this.issueDate = issueDate;
    }

    public void displayInfo() {
        System.out.println("Magazine Details:");
        super.displayInfo();
        System.out.println("Issue Date: " + issueDate);
    }
}

class Library {
    private List<LibraryItem> items = new ArrayList<>();

    public void addItem(LibraryItem newItem) throws DuplicateItemException {
        for (LibraryItem existingItem : items) {
            if (existingItem.getTitle().equals(newItem.getTitle())) {
                throw new DuplicateItemException("Duplicate item found");
            }
        }
        items.add(newItem);
        System.out.println("Item added to the library.");

    }

    public void removeItem(LibraryItem item) {

        if (items.remove(item)) {
            System.out.println("Item removed from the library.");
        } else {
            System.out.println("Item not found in the library.");
        }
    }

    public List<LibraryItem> getItems() {
        return items;
    }

    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("Library is empty.");
        } else {
            for (LibraryItem item : items) {
                item.displayInfo();
            }
        }
    }
}

public class LibrarySystemException {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Library Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. Remove Item");
            System.out.println("4. Display Items");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book Title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String bookAuthor = scanner.nextLine();
                    System.out.print("Enter Publication Year: ");
                    int bookYear = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String bookISBN = scanner.nextLine();
                    System.out.print("Enter Chapter Count: ");
                    int bookChapterCount = scanner.nextInt();
                    Book newBook = new Book(bookTitle, bookAuthor, bookYear, bookISBN, bookChapterCount);
                    try {
                        library.addItem(newBook);
                    } catch (DuplicateItemException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter Magazine Title: ");
                    String magTitle = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String magAuthor = scanner.nextLine();
                    System.out.print("Enter Issue Date: ");
                    String magIssueDate = scanner.nextLine();
                    Magazine newMagazine = new Magazine(magTitle, magAuthor, magIssueDate);
                    try {
                        library.addItem(newMagazine);
                    } catch (DuplicateItemException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    List<LibraryItem> items = library.getItems();
                    if (!items.isEmpty()) {
                        System.out.print("Enter the title of the item to remove: ");
                        String itemTitleToRemove = scanner.nextLine();
                        for (LibraryItem item : items) {
                            if (itemTitleToRemove.equals(item.getTitle())) {

                                library.removeItem(item);
                                break;
                            }
                        }
                    } else {
                        System.out.println("Library is empty.");
                    }
                    break;

                case 4:
                    library.displayItems();
                    break;

                case 5:
                    System.out.println("Exiting the library.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
