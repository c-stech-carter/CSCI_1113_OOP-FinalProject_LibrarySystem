import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File bookFile = new File("Book_List.txt");
        List<Book> bookList = new ArrayList<>();
        Scanner input = new Scanner(bookFile);

        // Read in Book_List.txt
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

        File patronFile = new File("Patron_List.txt");
        List<Patron> patronList = new ArrayList<>();
        input = new Scanner(patronFile);


        //Read in Patron_List.txt
        while (input.hasNextLine()) {
            Patron patron = new Patron();
            patron.setName(input.nextLine());
            patron.setPatronId(input.nextLine());
            patron.setItemIdSlot1(Integer.parseInt(input.nextLine()));
            patron.setItemIdSlot2(Integer.parseInt(input.nextLine()));
            patron.setItemIdSlot3(Integer.parseInt(input.nextLine()));

            patronList.add(patron); //Add patron to list
            if (!input.hasNext()) break;
            input.nextLine();
        }
        input.close();
    }

    public static List<Book> getBookList(List<Book> bookList) {
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
        return bookList;
    }
}
