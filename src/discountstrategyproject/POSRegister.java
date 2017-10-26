package discountstrategyproject;

public class POSRegister {
    private Receipt receipt;
    private String custID;
    
    
    public final void startTransaction(String custID, ReceiptOutputStrategy screenOutput, ReceiptOutputStrategy consoleOutput, DataAccessStrategy dataAccess, DiscountStrategy discount) {
        this.receipt = new Receipt(screenOutput, consoleOutput, dataAccess, discount);
        this.setCustID(custID);
        receipt.setCustID(custID);
        
    }

    public final void addItem(String prodID, double qty) {
        receipt.newLineItem(prodID, qty);
    }
    
    public final void setCustID (String custID) throws IllegalArgumentException{
        if (custID == null || custID.isEmpty()){
            throw new IllegalArgumentException("Customer ID cannot be blank.");
        }
        this.custID = custID;
    }
    
    public final void endTransaction(){
      receipt.initiateOutput();
    }
    
    
}
