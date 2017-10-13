
package discountstrategyproject;

public class Product {
    private String prodID; 
    private String prodName;
    private double prodPrice;
    private DiscountStrategy discount;
    private DataAccessStrategy dataAccess;
    
    public Product (DataAccessStrategy dataAccess){
        this.dataAccess = dataAccess;
    }
    
    
    public Product(String prodID, String prodName, double prodPrice, DiscountStrategy discount){
        this.prodID = prodID;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.discount = discount;
    }
    
    public Product findProduct(String prodID){
        return dataAccess.getProductData(prodID);
    }
    
    public String getProdID(){
        return prodID;
    }
    
    public String getProdName(){
        return prodName;
    }
    
    public double getProdPrice(){
        return prodPrice;
    }
    
    public double getDiscount(){
        return discount.getDiscount();
    }
}
