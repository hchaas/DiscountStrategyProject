package discountstrategyproject;

import java.util.Date;

public class Receipt {

    private ReceiptOutputStrategy screenOutput;
    private ReceiptOutputStrategy consoleOutput;
    private DataAccessStrategy dataAccess;
    private DiscountStrategy discount;
    private String custName;
    private String custID;
    private Date date = new Date();
    private String storeName = "Kohl's Department Store";

    //things needed in a receipt: 
    // date, store name, customer name, prod line items
    public Receipt(ReceiptOutputStrategy screenOutput, ReceiptOutputStrategy consoleOutput, DataAccessStrategy dataAccess, DiscountStrategy discount) {
        this.setScreenOutputStrategy(screenOutput);
        this.setConsoleOutputStrategy(consoleOutput);
        this.setDataAccessStrategy(dataAccess);
        this.setDiscountStrategy(discount);
    }

    public void setScreenOutputStrategy(ReceiptOutputStrategy screenOutput) {
        if (screenOutput == null) {
            throw new IllegalArgumentException("Screen output strategy cannot be null.");
        }
    }

    public void setConsoleOutputStrategy(ReceiptOutputStrategy consoleOutput) {
        if (consoleOutput == null) {
            throw new IllegalArgumentException("Console output strategy cannot be null.");
        }
    }

    public void setDataAccessStrategy(DataAccessStrategy dataAccess) {
        if (dataAccess == null) {
            throw new IllegalArgumentException("Data access strategy cannot be null.");
        }
    }

    public void setDiscountStrategy(DiscountStrategy discount) {
        if (discount == null) {
            throw new IllegalArgumentException("Default discount strategy cannot be null.");
        }
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public void newLineItem(String custId, String prodID, double qty) {
        this.setCustID(custId);
        LineItem lineItem = new LineItem(prodID, qty, dataAccess, discount);
        lineItem.addToArray(lineItem);
    }

    public Customer findCustomer(DataAccessStrategy dataAccess, String custID) {
        Customer customer = new Customer(dataAccess);
        return customer.findCustomer(custID);
    }

    public Date getTodaysDate() {
        return date;
    }

    public LineItem[] getLineItems() {
        LineItem lineItem = new LineItem();
        return lineItem.getAllItems();
    }

    public String getStoreName() {
        return storeName;
    }

    public String getCustID() {
        return custID;
    }

    public void initiateOutput() {
        screenOutput.output(this);
        consoleOutput.output(this);
    }

}
