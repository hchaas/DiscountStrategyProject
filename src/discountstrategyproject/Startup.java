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
        POSRegister register = new POSRegister();

        //enter customer id or 0 if none
        try {
            register.startTransaction("200", screenOutput, consoleOutput, dataAccess, discount);
            register.addItem("A101", 1);
            register.addItem("B205", 2);
            register.addItem("C222", 4);
            register.endTransaction();
        } 
        catch (NullArgumentException nae){
            nae.getMessage();
        }
        catch (EmptyArgumentException eae){
            eae.getMessage();
        }
        catch(QuantityTooLowException qtle){
            qtle.getMessage();
        }
        catch (ProductPriceTooLowException pptl){
            pptl.getMessage();
        }
        catch (IllegalArgumentException iae) {
            iae.getMessage();
        }

        //customerID, productID, quantity
        //customer 2 sales
        try {
        register.startTransaction("300", screenOutput, consoleOutput, dataAccess, discount);
        register.addItem("C222", 1);
        register.addItem("E121", 2);
        register.addItem("D422", 4);
        register.endTransaction();
        }
        catch (IllegalArgumentException iae) {
            iae.getMessage();
        }

    }

}
