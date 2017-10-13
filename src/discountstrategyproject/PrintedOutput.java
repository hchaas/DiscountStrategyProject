
package discountstrategyproject;

public class PrintedOutput implements ReceiptOutputStrategy {

        //ProdId*  ProdName*     Qty+   UnitCost*  Total^    Discount*  Linetotal
    
    @Override
    public void output(Receipt receipt){
        System.out.println("Thank you for shopping at " + receipt.getStoreName() + "!" + "\t" + receipt.getTodaysDate() + "\n\n");
        System.out.println("ProdID" + "\t\t" + "ProdName" + "\t\t" + "Qty" + "\t\t" + "UnitCost" + "\t\t" +
                "Total" + "\t\t" + "Discount" + "\t\t" + "Line Total" + "\n\n");
        LineItem[] lineItems = receipt.getLineItems();
        
        for(int i=0; i<lineItems.length; i++){
        System.out.println(lineItems[i].getProdID() + "\t\t" + 
                           lineItems[i].getProdName() + "\t\t" + 
                           lineItems[i].getQuantity() + "\t\t" + 
                           lineItems[i].getProdPrice() + "\t\t" +
                           lineItems[i].getLineItemTotalBeforeDiscount() + "\t\t" +
                           lineItems[i].getDiscount() + "\t\t" +
                           lineItems[i].getLinItemTotalAfterDiscount()+"\n");
        }
        
        System.out.println("Grand Total: ");
    }
}
