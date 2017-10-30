
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
    
    public final void setProdID(String prodID) throws IllegalArgumentException{
        if (prodID == null){
            throw new NullArgumentException();
        }
        if (prodID.isEmpty()){
            throw new EmptyArgumentException();
        }
                
        this.prodID = prodID;
    }
    
    public final void setProdName(String prodName) throws IllegalArgumentException{
        if (prodName == null){
            throw new NullArgumentException();
        }
        if (prodName.isEmpty()){
            throw new EmptyArgumentException();
        }
                
        this.prodName = prodName;
    }
    
    public final void setProdPrice(double prodPrice) throws ProductPriceTooLowException{
        if (prodPrice<0){
            throw new ProductPriceTooLowException();
        }
        this.prodPrice = prodPrice;
    }
    
    public final void setDiscountStrategy(DiscountStrategy discount) throws NullArgumentException{
        if (discount == null){
            throw new NullArgumentException();
        }
        this.discount = discount;
    }
    
    public final void setDataAccessStrategy(DataAccessStrategy dataAccess) throws NullArgumentException{
        if (dataAccess == null){
            throw new NullArgumentException();
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
