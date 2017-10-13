package discountstrategyproject;

public class LineItem {

    private String prodID;
    private double qty;
    private String prodName;
    private double prodDiscount;
    private Product product;
    private DataAccessStrategy dataAccess;
    private DiscountStrategy discount;
    

//    public LineItem(DataAccessStrategy dataAccess, DiscountStrategy discount) {
//        this.setDataAccessStrategy(dataAccess);
//        this.setDiscountStrategy(discount);
//    }

    public LineItem(String prodID, double qty, DataAccessStrategy dataAccess, DiscountStrategy discount) {
        this.setProdID(prodID);
        this.setQuantity(qty);
        this.setDataAccessStrategy(dataAccess);
        this.setDiscountStrategy(discount);
        this.product = new Product(prodID, dataAccess);
    }
    
    public final void setProdID(String prodID){
        if (prodID == null || prodID.isEmpty()){
            throw new IllegalArgumentException("Product ID cannot be null or blank.");
        }
        this.prodID = prodID;
    }
    
    public final void setQuantity(double qty){
        if (qty<1){
            throw new IllegalArgumentException("Quantity cannot be less than one.");
        }
        this.qty = qty;
    }
    
    public final void setDataAccessStrategy(DataAccessStrategy dataAccess){
        if (dataAccess == null){
            throw new IllegalArgumentException("Data access strategy cannot be blank.");
        }
        this.dataAccess = dataAccess;
    }
    
    public final void setDiscountStrategy(DiscountStrategy discount){
        if (discount == null){
            throw new IllegalArgumentException("Discount strategy cannot be null.");
        }
        this.discount = discount;
    }

    public final Product findProduct(String prodID) {
        return product.findProduct(prodID);
    }

    public final String getProdID() {
        return product.getProdID();
    }

    public final String getProdName() {
        return product.getProdName();
    }

    public final double getQuantity() {
        return qty;
    }

    public final double getProdPrice() {
        return product.getProdPrice();
    }
    
    public final double getDiscount(){
        return product.getDiscount();
    }
    
    public final double getLineItemTotalBeforeDiscount(){
        return (this.getProdPrice() * this.getQuantity());
    }
    
    public final double getLineItemDiscount(){
        return(this.getProdPrice()*this.getQuantity()*this.getDiscount());
    }
    
    public final double getLineItemTotalAfterDiscount(){
        return (this.getLineItemTotalBeforeDiscount() - this.getLineItemDiscount());
    }
    
}
