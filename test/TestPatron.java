import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TestPatron {
    public static void main(String[] args) throws IOException {
        File file = new File("Patron_List.txt");
        List<Patron> patronList = new ArrayList<>();
        Scanner input = new Scanner(file);


        //Read in Patron_List.txt
        while (input.hasNextLine()) {
            Patron patron = new Patron();
            patron.setName(input.nextLine());
            patron.setPatronId(input.nextLine());
            patron.setItemIdSlot1(Integer.parseInt(input.nextLine()));
            patron.setItemIdSlot2(Integer.parseInt(input.nextLine()));
            patron.setItemIdSlot3(Integer.parseInt(input.nextLine()));
            patronList.add(patron);
            if (!input.hasNext()) break;
            input.nextLine();
        }
        input.close();


        //Testing displaying the patron objects
        boolean running = true;
        do {
            System.out.println("Patron List:");
            System.out.println("Enter Patron ID: (type number after P, example: P-1)" +
                    "Currently may choose from P1-P" + patronList.size());
            System.out.print("Entry:> P- ");

            Scanner userInput = new Scanner(System.in);
            int patronIndex = -1;
            boolean getValidInput = true;
            while (getValidInput) {
                try {
                    patronIndex = userInput.nextInt() -1;
                    if (patronIndex < 0 || patronIndex >= patronList.size()) {
                        System.out.println("Invalid Patron ID, valid input is between 1-"
                                + (patronList.size()));
                    }
                    else {
                        getValidInput = false;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Patron ID must be an integer between 1-"
                            + patronList.size());
                }
            }
            System.out.println("Patron: " + patronList.get(patronIndex).getName());
            System.out.println("Patron ID: " + patronList.get(patronIndex).getPatronId());
            if (patronList.get(patronIndex).getItemIdSlot1() == 0) {
                System.out.println("Checkout 1: No book checked out");
            } else {
                System.out.println("Checkout 1: Item ID: " + patronList.get(patronIndex).getItemIdSlot1());
            }
            if (patronList.get(patronIndex).getItemIdSlot2() == 0) {
                System.out.println("Checkout 2: No book checked out");
            } else {
                System.out.println("Checkout 2: Item ID: " + patronList.get(patronIndex).getItemIdSlot2());
            }
            if (patronList.get(patronIndex).getItemIdSlot3() == 0) {
                System.out.println("Checkout 3: No book checked out");
            } else {
                System.out.println("Checkout 3: Item ID: " + patronList.get(patronIndex).getItemIdSlot3());
            }

        }while(running);
    }
}
