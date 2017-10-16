package discountstrategyproject;

public class PrintedOutput implements ReceiptOutputStrategy {

    //ProdId*  ProdName*     Qty+   UnitCost*  Total^    Discount*  Linetotal
    @Override
    public final void output(Receipt receipt) {

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
// 
//        System.out.println("ProdID" + "\t" + "ProdName" + "\t" + "Qty" + "\t" + "UnitCost" + "\t"
//                + "Total" + "\t" + "Discount" + "\t" + "Line Total" + "\n");

        
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s", 
                "Prod ID", "Prod Name", "Qty","Unit Cost", "Total", "Discount", "Line Total" + "\n");

        
        LineItem[] items = receipt.getAllItems();
        
        for (int i = 0; i< items.length; i++){
            System.out.println("");
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s", items[i].getProdID(),
                    items[i].getProdName(), items[i].getQuantity(), items[i].getProdPrice(),
                     items[i].getLineItemTotalBeforeDiscount(), items[i].getDiscount(),
                     items[i].getLineItemTotalAfterDiscount());
            
        
        }
        
        
//        for (int i = 0; i < items.length; i++) {
//            System.out.println(items[i].getProdID() + "\t"
//                    + items[i].getProdName() + "\t"
//                    + items[i].getQuantity() + "\t"
//                    + items[i].getProdPrice() + "\t"
//                    + items[i].getLineItemTotalBeforeDiscount() + "\t"
//                    + items[i].getDiscount() + "\t"
//                    + items[i].getLineItemTotalAfterDiscount() + "\n");
//        }

        System.out.println("\n\nGrand Total: $" + receipt.getGrandTotal()+"\n");
    }
}
