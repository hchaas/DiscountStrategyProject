
package discountstrategyproject;

import javax.swing.JOptionPane;

public class ScreenOutput implements ReceiptOutputStrategy {
    
    @Override
    public final void output(Receipt receipt){
        String receiptTop;
        String pad = "     ";
        
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

        
        receiptTop = ("Thank you for shopping at " + receipt.getStoreName() + "!" + pad + receipt.getTodaysDate() + "\n" + 
                    "Customer ID: " + custID + pad + "Customer Name: " + custName + "\n\n" +
                    "ProdID" + pad + "ProdName" + pad + "Qty" + pad + "UnitCost" + pad
                    + "Total" + pad + "Discount" + pad + "Line Total" + "\n");
        
        LineItem[] items = receipt.getAllItems();
        
        String receiptMiddle = "";
        
        for (int i = 0; i < items.length; i++) {
            String receiptVar = "";
            receiptVar = items[i].getProdID() + pad;
            receiptVar += items[i].getProdName() + pad;
            receiptVar += items[i].getQuantity() + pad;
            receiptVar += items[i].getProdPrice() + pad;
            receiptVar += items[i].getLineItemTotalBeforeDiscount() + pad;
            receiptVar += items[i].getDiscount() + pad;
            receiptVar += items[i].getLineItemTotalAfterDiscount() + "\n";
            receiptMiddle += receiptVar;
        }
        
        String receiptBottom = "Grand Total: $" + receipt.getGrandTotal();
        
        String message = String.format("%-20s %-20s %20s", receiptTop, receiptMiddle, receiptBottom);
        
        JOptionPane.showMessageDialog(null, message);
    }
    
}
