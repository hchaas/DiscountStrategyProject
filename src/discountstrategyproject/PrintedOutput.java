package discountstrategyproject;

public class PrintedOutput implements ReceiptOutputStrategy {

    //ProdId*  ProdName*     Qty+   UnitCost*  Total^    Discount*  Linetotal
    @Override
    public void output(Receipt receipt) {

        System.out.println("Thank you for shopping at " + receipt.getStoreName() + "!" + "\t" + receipt.getTodaysDate() );
        
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
        
        
        System.out.println("Customer ID: " + custID + "\t" + "Customer Name: " + custName + "\n");
 
        System.out.println("ProdID" + "\t" + "ProdName" + "\t" + "Qty" + "\t" + "UnitCost" + "\t"
                + "Total" + "\t" + "Discount" + "\t" + "Line Total" + "\n");
        
        LineItem[] items = receipt.getAllItems();
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i].getProdID() + "\t"
                    + items[i].getProdName() + "\t"
                    + items[i].getQuantity() + "\t"
                    + items[i].getProdPrice() + "\t"
                    + items[i].getLineItemTotalBeforeDiscount() + "\t"
                    + items[i].getDiscount() + "\t"
                    + items[i].getLineItemTotalAfterDiscount() + "\n");
        }

        System.out.println("Grand Total: $" + receipt.getGrandTotal());
    }
}
