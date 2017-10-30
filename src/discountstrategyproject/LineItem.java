package discountstrategyproject;

public class LineItem {

    private String prodID;
    private double qty;
    private String prodName;
    private double prodDiscount;
    private final Product product;
    private DataAccessStrategy dataAccess;
    private DiscountStrategy discount;
    

    public LineItem(String prodID, double qty, DataAccessStrategy dataAccess, DiscountStrategy discount) {
        this.setProdID(prodID);
        this.setQuantity(qty);
        this.setDataAccessStrategy(dataAccess);
        this.setDiscountStrategy(discount);
        this.product = new Product(prodID, dataAccess);
    }
    
    public final void setProdID(String prodID) throws IllegalArgumentException{
        if (prodID == null){
            throw new NullArgumentException();
        }
        if (prodID.isEmpty()){
            throw new EmptyArgumentException();
        }
                
        this.prodID = prodID;
    }
    
    public final void setQuantity(double qty) throws QuantityTooLowException{
        if (qty<1){
            throw new QuantityTooLowException();
        }
        this.qty = qty;
    }
    
    public final void setDataAccessStrategy(DataAccessStrategy dataAccess) throws NullArgumentException{
        if (dataAccess == null){
            throw new NullArgumentException();
        }
        this.dataAccess = dataAccess;
    }
    
    public final void setDiscountStrategy(DiscountStrategy discount) throws NullArgumentException{
        if (discount == null){
            throw new NullArgumentException();
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
