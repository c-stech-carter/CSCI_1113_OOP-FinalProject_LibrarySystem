public class Book {
    private String author = "none";
    private String title = "none";
    private int yearPublished = 1999;
    private int itemId = 1;
    private boolean borrowed = false;

    Book() {
    }

    Book(String author, String title, int yearPublished, int itemId, boolean borrowed) {
        this.author = author;
        this.title = title;
        this.yearPublished = yearPublished;
        this.itemId = itemId;
        this.borrowed = borrowed;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
}
