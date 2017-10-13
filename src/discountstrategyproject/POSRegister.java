package discountstrategyproject;

public class POSRegister {
    private Receipt receipt;
    
    public POSRegister(ReceiptOutputStrategy screenOutput, ReceiptOutputStrategy consoleOutput, DataAccessStrategy dataAccess, DiscountStrategy discount){
        this.receipt = new Receipt(screenOutput, consoleOutput, dataAccess, discount);
    }
    
    public void startTransaction() {

    }

    public void addItem(String custID, String prodID, double qty) {
        
        receipt.newLineItem(custID, prodID, qty);
    }
    
    public void endTransaction(){
      receipt.initiateOutput();
    }
    
    
}
