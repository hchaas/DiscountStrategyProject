
package discountstrategyproject;

import javax.swing.JOptionPane;


public class ScreenOutput implements ReceiptOutputStrategy {
    
    @Override
    public void output(Receipt receipt){
        String receiptTop;
        
        receiptTop = ("Thank you for shopping at " + receipt.getStoreName() + "!" + "\t" + receipt.getTodaysDate() + "\n\n" + 
                "ProdID" + "\t" + "ProdName" + "\t" + "Qty" + "\t" + "UnitCost" + "\t"
                + "Total" + "\t" + "Discount" + "\t" + "Line Total" + "\n\n");
        
        LineItem[] items = receipt.getAllItems();
        
        String receiptVar = "";
        
        for (int i = 0; i < items.length; i++) {
            receiptVar = items[i].getProdID() + "\t";
            receiptVar += items[i].getProdName() + "\t";
            receiptVar += items[i].getQuantity() + "\t";
            receiptVar += items[i].getProdPrice() + "\t";
            receiptVar += items[i].getLineItemTotalBeforeDiscount() + "\t";
            receiptVar += items[i].getDiscount() + "\t";
            receiptVar += items[i].getLineItemTotalAfterDiscount() + "\n";
        }
        
        String receiptBottom = "Grand Total: $" + receipt.getGrandTotal();
        
        String message = receiptTop + receiptVar + receiptBottom;
        
        JOptionPane.showMessageDialog(null, message);
    }
    
}
