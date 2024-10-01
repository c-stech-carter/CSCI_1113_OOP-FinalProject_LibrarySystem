/**
 * The Book class represents a book in the library.
 * Each book has an author, a title, a publication year, a unique item ID,
 * and a status indicating whether it is currently borrowed.
 */
public class Book {
    /**
     * The author of the book. Default is "none".
     */
    private String author = "none";

    /**
     * The title of the book. Default is "none".
     */
    private String title = "none";

    /**
     * The year the book was published. Default is 1999.
     */
    private int yearPublished = 1999;

    /**
     * The unique item ID of the book. Default is 1.
     */
    private int itemId = 1;

    /**
     * The borrowing status of the book. 'true' if borrowed, 'false' otherwise. Default is false.
     */
    private boolean borrowed = false;

    /**
     * Default constructor for the Book class.
     * Initializes a book with default values for author, title, yearPublished, itemId, and borrowed status.
     */
    public Book() {
        // No-argument constructor
    }

    /**
     * Constructor that initializes a book with specified values for all fields.
     *
     * @param author        The author of the book.
     * @param title         The title of the book.
     * @param yearPublished The year the book was published.
     * @param itemId        The unique item ID of the book.
     * @param borrowed      The borrowing status of the book.
     */
    public Book(String author, String title, int yearPublished, int itemId, boolean borrowed) {
        this.author = author;
        this.title = title;
        this.yearPublished = yearPublished;
        this.itemId = itemId;
        this.borrowed = borrowed;
    }

    /**
     * Gets the author of the book.
     *
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the book.
     *
     * @param author The author of the book.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the title of the book.
     *
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     *
     * @param title The title of the book.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the year the book was published.
     *
     * @return The year the book was published.
     */
    public int getYearPublished() {
        return yearPublished;
    }

    /**
     * Sets the year the book was published.
     *
     * @param yearPublished The year to set for the book's publication.
     */
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    /**
     * Gets the unique item ID of the book.
     *
     * @return The item ID of the book.
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * Sets the unique item ID of the book.
     *
     * @param itemId The item ID to set for the book.
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * Checks whether the book is currently borrowed.
     *
     * @return 'true' if the book is borrowed, 'false' otherwise.
     */
    public boolean isBorrowed() {
        return borrowed;
    }

    /**
     * Sets the borrowing status of the book.
     *
     * @param borrowed The status to set. 'true' if the book is borrowed, 'false' otherwise.
     */
    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
}
