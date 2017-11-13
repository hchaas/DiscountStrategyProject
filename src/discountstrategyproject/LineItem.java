package discountstrategyproject;

import java.util.Objects;

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

    public final double getProdPrice() throws ProductPriceTooLowException{
        if (product.getProdPrice() < 0){
            throw new ProductPriceTooLowException();
        }
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.prodID);
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.qty) ^ (Double.doubleToLongBits(this.qty) >>> 32));
        hash = 61 * hash + Objects.hashCode(this.prodName);
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.prodDiscount) ^ (Double.doubleToLongBits(this.prodDiscount) >>> 32));
        hash = 61 * hash + Objects.hashCode(this.product);
        hash = 61 * hash + Objects.hashCode(this.dataAccess);
        hash = 61 * hash + Objects.hashCode(this.discount);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LineItem other = (LineItem) obj;
        if (Double.doubleToLongBits(this.qty) != Double.doubleToLongBits(other.qty)) {
            return false;
        }
        if (Double.doubleToLongBits(this.prodDiscount) != Double.doubleToLongBits(other.prodDiscount)) {
            return false;
        }
        if (!Objects.equals(this.prodID, other.prodID)) {
            return false;
        }
        if (!Objects.equals(this.prodName, other.prodName)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        if (!Objects.equals(this.dataAccess, other.dataAccess)) {
            return false;
        }
        if (!Objects.equals(this.discount, other.discount)) {
            return false;
        }
        return true;
    }
    
    @Override
    public final String toString(){
        return ("This Line item object contains the following values: \n " + "Product ID: " +
                this.prodID + "\nQuantity: " + this.qty + "\nProduct Name: " + this.prodName + 
                "\nProduct Discount: " + this.prodDiscount + "\nProduct: " + this.product.toString() + 
                "\nData Access Strategy: " + this.dataAccess.toString() + "\nDiscount Strategy: " + 
                this.discount.toString());
                
                
    }
    
}
