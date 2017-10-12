
package discountstrategyproject;

public class LineItem {

    private String custID;
    private String prodID;
    private double qty;
    private String prodName;
    private double prodDiscount;
    private Product product;
    
    private LineItem[] lineItems;

    //ProdId*  ProdName*     Qty+ UnitCost*  ExtCost^ Discount*
    
    public LineItem(String custID, String prodID, double qty) {
        this.custID = custID;
        this.prodID = prodID;
        this.qty = qty;
        Product product = new Product();
        this.product = this.findProduct(prodID);
        
    }
    
    
    public Product findProduct(String prodID){
        
        return product;
    }

    public void addToArray(final LineItem item) {
        // needs validation
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = item;
        lineItems = tempItems;
    }

}
