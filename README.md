# CSCI_1113_OOP-FinalProject_LibrarySystem
Final project for CSCI_1113_OOP for STECH, which covers up to chapter 13 of Intro to Java, by Daniel Liang
# Library Checkout System (School Project)

## Overview

This is a **Java-based program** designed for a school project. It simulates a basic checkout system for a library with a collection of books. Patrons can check out, browse, or return books using the system.

**Note:** This program is for educational purposes and is not intended to function as a fully operational circulation system.

## Features

- **Check Out Books:** Patrons can check out books to one of their available slots.
- **Browse Collection:** Users can browse the available books in the library collection.
- **Return Books:** Patrons can return books by clearing a slot.

## How It Works

- The program reads book and patron data from two text files:
  - `Book_List.txt` - Contains details about each book (author, title, year, item ID, and borrowing status).
  - `Patron_List.txt` - Contains information about each patron (name, patron ID, and checked-out book slots).

- Users interact with the system via a menu:
  1. **Check-out book(s)**
  2. **Browse the collection**
  3. **Exit the program**

- **Check-out Process:**
  - Select a patron by ID.
  - Choose a slot to check out or return a book.
  - Books can be checked out by entering the book's item ID.

- **Browse Collection:**
  - View details about books, including title, author, year published, and borrowing status.

## Installation and Usage

1. **Compile the Program:**
   - Make sure you have Java installed on your system.
   - Compile the `Main.java` file using the command: 
     ```bash
     javac Main.java
     ```

2. **Run the Program:**
   - Run the compiled program:
     ```bash
     java Main
     ```

3. **Text Files:**
   - Ensure that the `Book_List.txt` and `Patron_List.txt` files are in the same directory as the compiled program, as they are used to load the library's book and patron data.

## Example Text Files

### `Book_List.txt`:
```plaintext
J.K. Rowling
Harry Potter and the Sorcerer's Stone
1997
1
false

George Orwell
1984
1949
2
true
```

### `Patron_List.txt`:
```plaintext
John Deere
P1
1
6
11

Jane Doe
P2
0
0
0
```
