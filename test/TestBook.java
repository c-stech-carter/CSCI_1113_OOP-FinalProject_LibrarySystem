import java.util.*;
import java.io.*;

public class TestBook {
    public static void main(String[] args) throws IOException {
        File file = new File("Book_List.txt");
        List<Book> bookList = new ArrayList<>();
        Scanner input = new Scanner(file);

        // Reading the file with hasNext()
        while (input.hasNext()) {
            Book book = new Book();
            book.setAuthor(input.nextLine());
            book.setTitle(input.nextLine());
            String yearString = input.nextLine();
            book.setYearPublished(Integer.parseInt(yearString));
            String itemIDString = input.nextLine();
            book.setItemId(Integer.parseInt(itemIDString));
            String borrowedStatus = input.nextLine();
            book.setBorrowed(Boolean.parseBoolean(borrowedStatus));

            bookList.add(book);  // Add book to the list
            if (!input.hasNext()) break;
            input.nextLine();
        }
        input.close();


        Scanner userInput = new Scanner(System.in);

        boolean running = true;

        do {
            String userChoice;
            System.out.println("Browse the Collection:");
            System.out.println("Enter an item ID (1 to " + (bookList.size()) + "), there are currently " +
                    bookList.size() + " books in the collection, (or type 'exit' to quit):");
            System.out.print("Entry:> ");
            try {
                userChoice = userInput.nextLine();
                if (userChoice.equalsIgnoreCase("exit")) {
                    running = false;
                    break;
                }
                int userInt = Integer.parseInt(userChoice) - 1;
                if (userInt < 0 || userInt >= bookList.size()) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                Book selectedBook = bookList.get(userInt);
                System.out.println("Item ID: " + selectedBook.getItemId() + ":");
                System.out.println("Title: " + selectedBook.getTitle());
                System.out.println("Author: " + selectedBook.getAuthor());
                System.out.println("Year Published: " + selectedBook.getYearPublished());
                System.out.print("Borrowed status: ");
                if (selectedBook.isBorrowed()) {
                    System.out.println("Unavailable");
                } else {
                    System.out.println("Available");
                }

            } catch (InputMismatchException ex) {
                System.out.println("Invalid input, please enter an integer from 1 to " + (bookList.size()));
                userInput.nextLine();  // Clear invalid input
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Invalid input, please enter an integer from 1 to " + (bookList.size()));
            }
        } while (running);
    }
}
