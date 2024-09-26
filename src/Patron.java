public class Patron {
    private String name = "Blank";
    private int itemIdSlot1 = 0;
    private int itemIdSlot2 = 0;
    private int itemIdSlot3 = 0;
    //Add more slots for book ID's here to increase borrower limit.
    //'0' signifies an empty slot, (no book should have the item ID set at zero)

    Patron(){

    }

    Patron(String name){
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
