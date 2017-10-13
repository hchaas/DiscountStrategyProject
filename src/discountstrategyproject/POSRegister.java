package discountstrategyproject;

public class POSRegister {
    private Receipt receipt;
    private String custID;
    
    public POSRegister(ReceiptOutputStrategy screenOutput, ReceiptOutputStrategy consoleOutput, DataAccessStrategy dataAccess, DiscountStrategy discount){
        this.receipt = new Receipt(screenOutput, consoleOutput, dataAccess, discount);
    }
    
    public void startTransaction(String custID) {
        this.setCustID(custID);
        receipt.setCustID(custID);
    }

    public void addItem(String prodID, double qty) {
        receipt.newLineItem(prodID, qty);
    }
    
    public void setCustID (String custID){
        if (custID == null || custID.isEmpty()){
            throw new IllegalArgumentException("Customer ID cannot be blank.");
        }
        this.custID = custID;
    }
    
    public void endTransaction(){
      receipt.initiateOutput();
    }
    
    
}
