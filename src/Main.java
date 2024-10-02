/**
 * Author: Charles Carter
 * Date: 9/30/2024
 * <p>
 * This program simulates a checkout system for a library with a collection of books.
 * Patrons can check out books, browse the collection, or exit the program.
 * The data for books and patrons are read from text files.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    /**
     * The main method is the entry point of the program.
     * It loads the books and patrons from text files, then presents a menu for the user to
     * check out books, browse the collection, or exit the program.
     *
     * @param args Command line arguments (not used in this program)
     * @throws FileNotFoundException If the input files are not found
     */
    public static void main(String[] args) throws FileNotFoundException {
        // Load the list of books from Book_List.txt
        File bookFile = new File("resources//Book_List.txt");
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

        // Load the list of patrons from Patron_List.txt
        File patronFile = new File("resources//Patron_List.txt");
        List<Patron> patronList = new ArrayList<>();
        input = new Scanner(patronFile);

        // Read in Patron_List.txt
        while (input.hasNextLine()) {
            Patron patron = new Patron();
            patron.setName(input.nextLine());
            patron.setPatronId(input.nextLine());
            patron.setItemIdSlot1(Integer.parseInt(input.nextLine()));
            patron.setItemIdSlot2(Integer.parseInt(input.nextLine()));
            patron.setItemIdSlot3(Integer.parseInt(input.nextLine()));

            patronList.add(patron); // Add patron to list
            if (!input.hasNext()) break;
            input.nextLine();
        }
        input.close();

        // Main menu loop
        boolean running = true;
        do {
            input = new Scanner(System.in);
            System.out.println("Welcome to the circulation system.");
            System.out.println("Please make a selection:\n" +
                    "1. Check-out book(s)\n" +
                    "2. Browse the collection.\n" +
                    "3. Exit.");
            System.out.print("Entry:> ");

            try {
                int selection = input.nextInt();
                switch (selection) {
                    case 1:
                        checkOutBook(bookList, patronList); // Check-out books
                        break;
                    case 2:
                        browseCollection(bookList); // Browse the collection
                        break;
                    case 3:
                        running = false; // Exit
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid selection, please try again.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please try again.\n");
            }
        } while (running);
    }

    /**
     * Allows a patron to check out or return books. The user is prompted to select a patron
     * by ID and then either check out a book to one of three slots or clear a slot.
     *
     * @param bookList   The list of books available for checkout
     * @param patronList The list of patrons who can check out books
     */
    public static void checkOutBook(List<Book> bookList, List<Patron> patronList) {
        boolean running = true;

        // Select Patron by ID
        System.out.println("Patron List:");
        System.out.println("Enter Patron ID: (type number after P, example: P-1)\n" +
                "Currently may choose from P1-P" + patronList.size());
        System.out.print("Entry:> P- ");

        Scanner userInput = new Scanner(System.in);
        int patronIndex = -1;
        boolean getValidInput = true;
        while (getValidInput) {
            try {
                patronIndex = userInput.nextInt() - 1;
                if (patronIndex < 0 || patronIndex >= patronList.size()) {
                    System.out.println("Invalid Patron ID, valid input is between 1-"
                            + (patronList.size()));
                } else {
                    getValidInput = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Patron ID must be an integer between 1-"
                        + patronList.size());
                System.out.print("Entry:> P- ");
                userInput.nextLine();
            }
        }

        // Display Patron Information and Checkout Status
        while (running) {
            System.out.println("Patron: " + patronList.get(patronIndex).getName());
            System.out.println("Patron ID: " + patronList.get(patronIndex).getPatronId());

            // Display checkout slots for the patron
            if (patronList.get(patronIndex).getItemIdSlot1() == 0) {
                System.out.println("Checkout 1: No book checked out");
            } else {
                System.out.print("Checkout 1, Item ID: " + patronList.get(patronIndex).getItemIdSlot1());
                for (Book book : bookList) {
                    if (book.getItemId() == patronList.get(patronIndex).getItemIdSlot1()) {
                        System.out.println(": '" + book.getTitle() + "' by " + book.getAuthor());
                    }
                }
            }

            if (patronList.get(patronIndex).getItemIdSlot2() == 0) {
                System.out.println("Checkout 2: No book checked out");
            } else {
                System.out.print("Checkout 2, Item ID: " + patronList.get(patronIndex).getItemIdSlot2());
                for (Book book : bookList) {
                    if (book.getItemId() == patronList.get(patronIndex).getItemIdSlot2()) {
                        System.out.println(": '" + book.getTitle() + "' by " + book.getAuthor());
                    }
                }
            }

            if (patronList.get(patronIndex).getItemIdSlot3() == 0) {
                System.out.println("Checkout 3: No book checked out");
            } else {
                System.out.print("Checkout 3, Item ID: " + patronList.get(patronIndex).getItemIdSlot3());
                for (Book book : bookList) {
                    if (book.getItemId() == patronList.get(patronIndex).getItemIdSlot3()) {
                        System.out.println(": '" + book.getTitle() + "' by " + book.getAuthor());
                    }
                }
            }

            // Select a checkout slot
            getValidInput = true;
            int selection = -1;
            while (getValidInput) {
                System.out.println("Enter a checkout slot or type '4' to Exit:");
                System.out.print("Entry:> ");
                try {
                    selection = userInput.nextInt();
                    if (selection > 4 || selection < 1) {
                        System.out.println("Invalid selection, please try again.\n");
                    } else {
                        getValidInput = false;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input, please try again.\n");
                    userInput.nextLine();
                }
            }

            // Exit to main menu
            if (selection == 4) {
                System.out.println("Returning to main menu.");
                running = false;
                break;
            }

            // Checkout or clear book from the selected slot
            try {
                System.out.printf("Enter an item ID, (1-" + bookList.size() + ") or '0' to clear:\n");
                System.out.print("Entry:> ");
                int itemIdChoice = userInput.nextInt();
                if (itemIdChoice > 0 && itemIdChoice <= bookList.size()) {
                    System.out.println("Checking out to Slot" + selection + " with ID: " + itemIdChoice);
                } else if (itemIdChoice == 0) {
                    System.out.println("Clearing Slot" + selection);
                }

                switch (selection) {
                    case 1:
                        patronList.get(patronIndex).setItemIdSlot1(itemIdChoice);
                        for (Book book : bookList) {
                            if (book.getItemId() == itemIdChoice) {
                                book.setBorrowed(true);
                            }
                        }
                        break;
                    case 2:
                        patronList.get(patronIndex).setItemIdSlot2(itemIdChoice);
                        for (Book book : bookList) {
                            if (book.getItemId() == itemIdChoice) {
                                book.setBorrowed(true);
                            }
                        }
                        break;
                    case 3:
                        patronList.get(patronIndex).setItemIdSlot3(itemIdChoice);
                        for (Book book : bookList) {
                            if (book.getItemId() == itemIdChoice) {
                                book.setBorrowed(true);
                            }
                        }
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please try again.\n");
            }
        }
    }

    /**
     * Allows the user to browse the collection of books.
     * The user can enter an item ID to view the details of a book or exit the browsing menu.
     *
     * @param bookList The list of books available in the library
     */
    public static void browseCollection(List<Book> bookList) {
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
