
package discountstrategyproject;

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
        //register.startTransaction();
        //customerID, productID, quantity
        register.addItem("100", "A101", 1);
//        register.addItem("100", "B205", 2);
//        register.addItem("100", "C222", 4);
        register.endTransaction();
        
        //customer 2 sales
        
        
    
    }
    
}
