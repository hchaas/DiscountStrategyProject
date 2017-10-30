
package discountstrategyproject;

public class ProductPriceTooLowException extends IllegalArgumentException {
    public static String errorMsg = "Product price is too low.";
    
    public ProductPriceTooLowException() {
        super(errorMsg);
    }

    public ProductPriceTooLowException(String s) {
        super(errorMsg);
    }

    public ProductPriceTooLowException(String message, Throwable cause) {
        super(errorMsg, cause);
    }

    public ProductPriceTooLowException(Throwable cause) {
        super(errorMsg, cause);
    }
    
}
