package discountstrategyproject;

import java.util.Date;

public class Receipt {

    private ReceiptOutputStrategy screenOutput;
    private ReceiptOutputStrategy consoleOutput;
    private DataAccessStrategy dataAccess;
    private DiscountStrategy discount;
    private String custID;
    private final Customer customer;
    private final Date date = new Date();
    private final String storeName = "Kohl's Department Store";
    private LineItem[] lineItems = new LineItem[0];

    public Receipt(ReceiptOutputStrategy screenOutput, ReceiptOutputStrategy consoleOutput, 
            DataAccessStrategy dataAccess, DiscountStrategy discount) throws IllegalArgumentException{
        this.setScreenOutputStrategy(screenOutput);
        this.setConsoleOutputStrategy(consoleOutput);
        this.setDataAccessStrategy(dataAccess);
        this.setDiscountStrategy(discount);
        this.customer = new Customer(dataAccess);
        
    }

    public final void setScreenOutputStrategy(ReceiptOutputStrategy screenOutput) {
        if (screenOutput == null) {
            throw new IllegalArgumentException("Screen output strategy cannot be null.");
        }
        this.screenOutput = screenOutput;
    }

    public final void setConsoleOutputStrategy(ReceiptOutputStrategy consoleOutput) {
        if (consoleOutput == null) {
            throw new IllegalArgumentException("Console output strategy cannot be null.");
        }
        this.consoleOutput = consoleOutput;
    }

    public final void setDataAccessStrategy(DataAccessStrategy dataAccess) {
        if (dataAccess == null) {
            throw new IllegalArgumentException("Data access strategy cannot be null.");
        }
        this.dataAccess = dataAccess;
    }

    public final void setDiscountStrategy(DiscountStrategy discount) {
        if (discount == null) {
            throw new IllegalArgumentException("Default discount strategy cannot be null.");
        }
        this.discount = discount;
    }

    public final void setCustID(String custID) {
        if (custID == null || custID.isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be blank.");
        }
        this.custID = custID;
    }

    public final void newLineItem(String prodID, double qty) {
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
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = item;
        lineItems = tempItems;
    }

    public final LineItem[] getAllItems() {
        return lineItems;
    }

    public final void initiateOutput() {
        screenOutput.output(this);
        consoleOutput.output(this);
    }
    
    public final double getGrandTotal(){
        double total = 0;
        for(int i=0; i<lineItems.length; i++){
            total += lineItems[i].getLineItemTotalAfterDiscount();
        }
        return total;
    }

}
