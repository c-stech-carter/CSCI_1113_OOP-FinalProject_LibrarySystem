/**
 * The Patron class represents a library patron who can check out books.
 * Each patron has a name, a unique patron ID, and three slots for checking out books.
 * The slots are represented by the item ID of the books, and a value of '0' signifies an empty slot.
 */
public class Patron {
    /**
     * The name of the patron. Default is "Blank".
     */
    private String name = "Blank";

    /**
     * The unique ID of the patron. Default is "Blank".
     */
    private String patronId = "Blank";

    /**
     * The ID of the book checked out in slot 1. '0' signifies no book is checked out.
     */
    private int itemIdSlot1 = 0;

    /**
     * The ID of the book checked out in slot 2. '0' signifies no book is checked out.
     */
    private int itemIdSlot2 = 0;

    /**
     * The ID of the book checked out in slot 3. '0' signifies no book is checked out.
     */
    private int itemIdSlot3 = 0;

    /**
     * Default constructor for the Patron class.
     * Initializes a patron with default values for name and patron ID.
     */
    public Patron() {
        // No-argument constructor
    }

    /**
     * Constructor that creates a Patron with a specified name.
     *
     * @param name The name of the patron.
     */
    public Patron(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the patron.
     *
     * @return The name of the patron.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the patron.
     *
     * @param name The name to set for the patron.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the unique ID of the patron.
     *
     * @return The patron ID.
     */
    public String getPatronId() {
        return patronId;
    }

    /**
     * Sets the unique ID of the patron.
     *
     * @param patronId The ID to set for the patron.
     */
    public void setPatronId(String patronId) {
        this.patronId = patronId;
    }

    /**
     * Gets the item ID of the book checked out in slot 1.
     *
     * @return The item ID for slot 1, or '0' if no book is checked out.
     */
    public int getItemIdSlot1() {
        return itemIdSlot1;
    }

    /**
     * Sets the item ID for the book in slot 1.
     *
     * @param itemIdSlot1 The item ID of the book to set in slot 1.
     */
    public void setItemIdSlot1(int itemIdSlot1) {
        this.itemIdSlot1 = itemIdSlot1;
    }

    /**
     * Gets the item ID of the book checked out in slot 2.
     *
     * @return The item ID for slot 2, or '0' if no book is checked out.
     */
    public int getItemIdSlot2() {
        return itemIdSlot2;
    }

    /**
     * Sets the item ID for the book in slot 2.
     *
     * @param itemIdSlot2 The item ID of the book to set in slot 2.
     */
    public void setItemIdSlot2(int itemIdSlot2) {
        this.itemIdSlot2 = itemIdSlot2;
    }

    /**
     * Gets the item ID of the book checked out in slot 3.
     *
     * @return The item ID for slot 3, or '0' if no book is checked out.
     */
    public int getItemIdSlot3() {
        return itemIdSlot3;
    }

    /**
     * Sets the item ID for the book in slot 3.
     *
     * @param itemIdSlot3 The item ID of the book to set in slot 3.
     */
    public void setItemIdSlot3(int itemIdSlot3) {
        this.itemIdSlot3 = itemIdSlot3;
    }
}
