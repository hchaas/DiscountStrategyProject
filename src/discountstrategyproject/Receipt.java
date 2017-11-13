package discountstrategyproject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Receipt {

    private ReceiptOutputStrategy screenOutput;
    private ReceiptOutputStrategy consoleOutput;
    private DataAccessStrategy dataAccess;
    private DiscountStrategy discount;
    private String custID;
    private final Customer customer;
    private final Date date = new Date();
    private final String storeName = "Kohl's Department Store";
    private List<LineItem> lineItems = new ArrayList<>();

    public Receipt(ReceiptOutputStrategy screenOutput, ReceiptOutputStrategy consoleOutput, 
            DataAccessStrategy dataAccess, DiscountStrategy discount) throws IllegalArgumentException{
        this.setScreenOutputStrategy(screenOutput);
        this.setConsoleOutputStrategy(consoleOutput);
        this.setDataAccessStrategy(dataAccess);
        this.setDiscountStrategy(discount);
        this.customer = new Customer(dataAccess);
        
    }

    public final void setScreenOutputStrategy(ReceiptOutputStrategy screenOutput) throws NullArgumentException {
        if (screenOutput == null) {
            throw new IllegalArgumentException();
        }
        this.screenOutput = screenOutput;
    }

    public final void setConsoleOutputStrategy(ReceiptOutputStrategy consoleOutput) throws NullArgumentException {
        if (consoleOutput == null) {
            throw new IllegalArgumentException();
        }
        this.consoleOutput = consoleOutput;
    }

    public final void setDataAccessStrategy(DataAccessStrategy dataAccess) throws NullArgumentException{
        if (dataAccess == null) {
            throw new IllegalArgumentException();
        }
        this.dataAccess = dataAccess;
    }

    public final void setDiscountStrategy(DiscountStrategy discount) throws NullArgumentException {
        if (discount == null) {
            throw new IllegalArgumentException();
        }
        this.discount = discount;
    }

    public final void setCustID(String custID) throws IllegalArgumentException {
        if (custID == null){
            throw new NullArgumentException();
        }
        if (custID.isEmpty()){
            throw new EmptyArgumentException();
        }
               
        this.custID = custID;
    }

    public final void newLineItem(String prodID, double qty) throws IllegalArgumentException{
        if (prodID == null){
            throw new NullArgumentException();
        }
        if (prodID.isEmpty()){
            throw new EmptyArgumentException();
        }
        if (qty < 1){
            throw new QuantityTooLowException();
        }
        LineItem lineItem = new LineItem(prodID, qty, dataAccess, discount);
        this.addToArray(lineItem);
    }

    public final Customer findCustomer() {
        return customer.findCustomer(custID);
    }

    public final Date getTodaysDate() {
        return date;
    }

    public final String getStoreName() {
        return storeName;
    }

    public final String getCustID() {
        return custID;
    }

    public final void addToArray(final LineItem item) {
        lineItems.add(item);
        
//        LineItem[] tempItems = new LineItem[lineItems.length + 1];
//        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
//        tempItems[lineItems.length] = item;
//        lineItems = tempItems;
    }

    public final List<LineItem> getAllItems() {
        return lineItems;
    }

    public final void initiateOutput() {
        screenOutput.output(this);
        consoleOutput.output(this);
    }
    
    public final double getGrandTotal(){
        double total = 0;
        for(int i=0; i<lineItems.size(); i++){
            total += lineItems.get(i).getLineItemTotalAfterDiscount();
        }
        return total;
    }

}
