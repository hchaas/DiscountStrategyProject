package discountstrategyproject;

public class LineItem {

    private String prodID;
    private double qty;
    private String prodName;
    private double prodDiscount;
    private Product product;
    private DataAccessStrategy dataAccess;
    private DiscountStrategy discount;
    private LineItem[] lineItems;

    public LineItem() {

    }

    public LineItem(String prodID, double qty, DataAccessStrategy dataAccess, DiscountStrategy discount) {
        this.prodID = prodID;
        this.qty = qty;
        this.dataAccess = dataAccess;
        this.discount = discount;
        Product product = new Product(dataAccess);
        this.product = product;
    }

    public Product findProduct(String prodID) {
        return product.findProduct(prodID);
    }

    public void addToArray(final LineItem item) {
        // needs validation
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = item;
        lineItems = tempItems;
    }

    public LineItem[] getAllItems() {
        return lineItems;
    }

    public String getProdID() {
        return product.getProdID();
    }

    public String getProdName() {
        return product.getProdName();
    }

    public double getQuantity() {
        return qty;
    }

    public double getProdPrice() {
        return this.getProdPrice();
    }
    
    public double getDiscount(){
        return product.getDiscount();
    }
    
    public double getLineItemTotalBeforeDiscount(){
        return (this.getProdPrice() * this.getQuantity());
    }
    
    public double getLineItemDiscount(){
        return(this.getProdPrice()*this.getQuantity()*this.getDiscount());
    }
    
    public double getLinItemTotalAfterDiscount(){
        return (this.getLineItemTotalBeforeDiscount() - this.getLineItemDiscount());
    }
}
