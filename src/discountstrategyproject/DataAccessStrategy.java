
package discountstrategyproject;

public interface DataAccessStrategy {
    
    public abstract Customer getCustomerData(String custId);
    public abstract Product getProductData(String prodID);
}
