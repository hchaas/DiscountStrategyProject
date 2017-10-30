package discountstrategyproject;

public class POSRegister {
    private Receipt receipt;
    private String custID;
    
    
    public final void startTransaction(String custID, ReceiptOutputStrategy screenOutput, ReceiptOutputStrategy consoleOutput, DataAccessStrategy dataAccess, DiscountStrategy discount) {
        this.receipt = new Receipt(screenOutput, consoleOutput, dataAccess, discount);
        this.setCustID(custID);
        receipt.setCustID(custID);
        
    }

    public final void addItem(String prodID, double qty) throws IllegalArgumentException {
        if (prodID == null){
            throw new NullArgumentException();
        }
        if (prodID.isEmpty()){
            throw new EmptyArgumentException();
        }
        if (qty<1){
            throw new QuantityTooLowException();
        }
        receipt.newLineItem(prodID, qty);
    }
    
    public final void setCustID (String custID) throws IllegalArgumentException{
        if (custID == null){
            throw new NullArgumentException();
        }
        if (custID.isEmpty()){
            throw new EmptyArgumentException();
        }
                
        this.custID = custID;
    }
    
    public final void endTransaction(){
      receipt.initiateOutput();
    }
    
    
}
