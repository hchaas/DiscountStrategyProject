
package discountstrategyproject;

import java.util.Scanner;

public class Startup {

    public static void main(String[] args) {
        // Configuration ...
        ReceiptOutputStrategy screenOutput = new ScreenOutput();
        ReceiptOutputStrategy consoleOutput = new PrintedOutput();
        POSRegister register = new POSRegister(screenOutput, consoleOutput);
        //add database strategy abstraction here
        //add discount strategy abstraction here
        
        //customer 1 sales
        //register.startTransaction();
        //customerID, productID, quantity
        register.addItem("100", "1156", 1);
        register.addItem("100", "1289", 2);
        register.addItem("100", "4525", 4);
        register.endTransaction();
        
        //customer 2 sales
        
        
    
    }
    
}
