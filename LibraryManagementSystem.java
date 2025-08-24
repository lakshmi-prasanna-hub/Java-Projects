import java.io.*;
import java.util.*;

class Book implements Serializable {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You borrowed: " + title);
        } else {
            System.out.println("Sorry, this book is not available.");
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println("You returned: " + title);
    }

    @Override
    public String toString() {
        return title + " by " + author + (isAvailable ? " (Available)" : " (Borrowed)");
    }
}

class Library {
    private HashMap<String, Book> books = new HashMap<>();
    private static final String FILE_NAME = "library_data.ser";

    public Library() {
        loadBooks();
    }

    public void addBook(String title, String author) {
        Book b=new Book(title, author);
        books.put(title, b );
        saveBooks();
        System.out.println("The book was added successfully!");
    }

    public void borrowBook(String title) {
        Book book = books.get(title);
        if (book != null && book.isAvailable()) {
            book.borrowBook();
            saveBooks();
        } else {
            System.out.println("Book not available or doesn't exist.");
        }
    }

    public void returnBook(String title) {
        Book book = books.get(title);
        if (book != null && !book.isAvailable()) {
            book.returnBook();
            saveBooks();
        } else {
            System.out.println("Book not found or already returned.");
        }
    }

    public void viewAvailableBooks() {
        boolean found = false;
        for (Book book : books.values()) {
            if (book.isAvailable()) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available books.");
        }
    }

    private void saveBooks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(books);
        } catch (IOException e) {
            System.out.println("Error saving books.");
        }
    }

    @SuppressWarnings("unchecked")
    private void loadBooks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            books = (HashMap<String, Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            books = new HashMap<>();
        } 
    }
}

public class LibraryManagementSystem{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        String title;
 
            System.out.println("\n Welcome to the Library System!");
            System.out.println("1. Add Book"); 
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book"); 
            System.out.println("4. View Available Books");
            System.out.println("5. Exit");
            while (true) {
            try {
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                     title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    if (title == null || title.trim().isEmpty() || author == null || author.trim().isEmpty()) 
                        System.out.println("Book title and author cannot be empty.");
                    else
                    library.addBook(title, author);
                    break;
                case 2:
                    System.out.print("Enter book title to borrow: ");
                    title=scanner.nextLine();
                    if(!(title.trim().isEmpty()))
                    library.borrowBook(title);
                    else
                    System.out.println("Book title cannot be empty.");
                    break;
                case 3:
                    System.out.print("Enter book title to return: ");
                    title=scanner.nextLine();
                    if(!(title.trim().isEmpty()))
                    library.returnBook(title);
                    else
                    System.out.println("Book title cannot be empty.");
                    break;
                case 4:
                    library.viewAvailableBooks();
                    break;
                case 5:
                    System.out.println("Saving changes and exiting.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); 
        }
        }
    }
}
