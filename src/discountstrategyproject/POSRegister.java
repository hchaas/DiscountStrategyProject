package discountstrategyproject;

public class POSRegister {
    private Receipt receipt;
//    private ReceiptOutputStrategy screenOutput;
//    private ReceiptOutputStrategy consoleOutput;
    
    public POSRegister(ReceiptOutputStrategy screenOutput, ReceiptOutputStrategy consoleOutput){
        Receipt newReceipt = new Receipt(screenOutput, consoleOutput);
        newReceipt = receipt;
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
