
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
        
        //enter customer id or 0 if none
        register.startTransaction("200");
        //customerID, productID, quantity
        register.addItem("A101", 1);
        register.addItem("B205", 2);
        register.addItem("C222", 4);
        register.endTransaction();
        
        //customer 2 sales
        
        
    
    }
    
}
