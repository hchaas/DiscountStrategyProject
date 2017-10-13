
package discountstrategyproject;

import java.util.Scanner;

public class Startup {

    public static void main(String[] args) {
        // Configuration ...
        ReceiptOutputStrategy screenOutput = new ScreenOutput();
        ReceiptOutputStrategy consoleOutput = new PrintedOutput();
        DataAccessStrategy dataAccess = new InMemoryDataAccess();
        //the default discount is no discount; this can get overridden later
        DiscountStrategy discount = new NoDiscount();
        POSRegister register = new POSRegister(screenOutput, consoleOutput, dataAccess, discount);
        
        
        //customer 1 sales
//        System.out.println("Enter customer ID or hit enter if none: ");
//        Scanner input = new Scanner(System.in);
//        String custID = input.nextLine();
//        input.nextLine();
        
        register.startTransaction("100");
        //customerID, productID, quantity
        register.addItem("A101", 1);
        register.addItem("B205", 2);
        register.addItem("C222", 4);
        register.endTransaction();
        
        //customer 2 sales
        
        
    
    }
    
}
