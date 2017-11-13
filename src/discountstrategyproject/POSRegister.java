package discountstrategyproject;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.receipt);
        hash = 71 * hash + Objects.hashCode(this.custID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final POSRegister other = (POSRegister) obj;
        if (!Objects.equals(this.custID, other.custID)) {
            return false;
        }
        if (!Objects.equals(this.receipt, other.receipt)) {
            return false;
        }
        return true;
    }
    
    @Override
    public final String toString(){
        return "POSRegister object with these properties: \nReceipt: " + this.receipt.toString() + 
                "\nCustomer ID: " + this.custID;
    }
    
}
