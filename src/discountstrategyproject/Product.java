
package discountstrategyproject;

public class Product {
    private String prodID; 
    private String prodName;
    private double prodPrice;
    private DiscountStrategy discount;
    private double discountAmount;
    private DataAccessStrategy dataAccess;
    
    public Product (String prodID, DataAccessStrategy dataAccess){
        this.setProdID(prodID);
        this.setDataAccessStrategy(dataAccess);
        prodName = this.findProduct(prodID).getProdName();
        prodPrice = this.findProduct(prodID).getProdPrice();
        discountAmount = this.findProduct(prodID).getDiscount();
    }
    
    public Product(String prodID, String prodName, double prodPrice, DiscountStrategy discount){
        this.setProdID(prodID);
        this.setProdName(prodName);
        this.setProdPrice(prodPrice);
        this.setDiscountStrategy(discount);
        this.setDiscountAmount();
        
    }
    
    public final void setProdID(String prodID){
        if (prodID == null || prodID.isEmpty()){
            throw new IllegalArgumentException("Product ID cannot be null.");
        }
        this.prodID = prodID;
    }
    
    public final void setProdName(String prodName){
        if (prodName == null || prodName.isEmpty()){
            throw new IllegalArgumentException("Product name cannot be null.");
        }
        this.prodName = prodName;
    }
    
    public final void setProdPrice(double prodPrice){
        if (prodPrice<0){
            throw new IllegalArgumentException("Product price cannot be less than zero.");
        }
        this.prodPrice = prodPrice;
    }
    
    public final void setDiscountStrategy(DiscountStrategy discount){
        if (discount == null){
            throw new IllegalArgumentException("Discount strategy cannot be null.");
        }
        this.discount = discount;
    }
    
    public final void setDataAccessStrategy(DataAccessStrategy dataAccess){
        if (dataAccess == null){
            throw new IllegalArgumentException("Data access strategy cannot be null.");
        }
        this.dataAccess = dataAccess;
    }
    
    public final Product findProduct(String prodID){
        return dataAccess.getProductData(prodID);
    }
    
    public final String getProdID(){
        return prodID;
    }
    
    public final String getProdName(){
        return prodName;
    }
    
    public final double getProdPrice(){
        return prodPrice;
    }
    
    public final double getDiscount(){
        return discountAmount;
    }
    
    public final void setDiscountAmount(){
        discountAmount = this.discount.getDiscount();
    }
}
