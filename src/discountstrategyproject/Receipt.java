
package discountstrategyproject;

public class Receipt {
    private ReceiptOutputStrategy screenOutput;
    private ReceiptOutputStrategy consoleOutput;
    private String custName;
    private String custID;
     
    //things needed in a receipt: 
    // date, store name, customer name, prod line items
    
    public Receipt(ReceiptOutputStrategy screenOutput, ReceiptOutputStrategy consoleOutput) {
        this.screenOutput = screenOutput;
        this.consoleOutput = consoleOutput;
    }
    
    public void newLineItem(String custID, String prodID, double qty){
        LineItem lineItem = new LineItem(custID, prodID, qty);
        lineItem.addToArray(lineItem);
    }
    
    public Customer findCustomer(String custID){
        Customer customer = new Customer();
        return customer.findCustomer(custID);   
    }

    public void initiateOutput(){
        screenOutput.output(this);
        consoleOutput.output(this);
    }

}
