
package discountstrategyproject;

import javax.swing.JOptionPane;

public class ScreenOutput implements ReceiptOutputStrategy {
    
    @Override
    public final void output(Receipt receipt){
        String receiptTop;
        
        String custID = receipt.getCustID();
        String custName;
        if ("0".equals(custID)){
            custID = "n/a";
            custName = "n/a";
        }
        else {
            custID = custID;
            custName = receipt.findCustomer().getCustomerName();
        }

        
        receiptTop = ("Thank you for shopping at " + receipt.getStoreName() + "!" + "\t" + receipt.getTodaysDate() + "\n\n" + 
                    "Customer ID: " + custID + "\t" + "Customer Name: " + custName + "\n" +
                    "ProdID" + "\t" + "ProdName" + "\t" + "Qty" + "\t" + "UnitCost" + "\t"
                    + "Total" + "\t" + "Discount" + "\t" + "Line Total" + "\n\n");
        
        LineItem[] items = receipt.getAllItems();
        
        String receiptMiddle = "";
        
        for (int i = 0; i < items.length; i++) {
            String receiptVar = "";
            receiptVar = items[i].getProdID() + "\t";
            receiptVar += items[i].getProdName() + "\t";
            receiptVar += items[i].getQuantity() + "\t";
            receiptVar += items[i].getProdPrice() + "\t";
            receiptVar += items[i].getLineItemTotalBeforeDiscount() + "\t";
            receiptVar += items[i].getDiscount() + "\t";
            receiptVar += items[i].getLineItemTotalAfterDiscount() + "\n";
            receiptMiddle += receiptVar;
        }
        
        String receiptBottom = "Grand Total: $" + receipt.getGrandTotal();
        
        String message = receiptTop + receiptMiddle + receiptBottom;
        
        JOptionPane.showMessageDialog(null, message);
    }
    
}
