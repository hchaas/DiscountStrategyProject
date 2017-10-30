
package discountstrategyproject;

class QuantityTooLowException extends IllegalArgumentException {
    public static String errorMsg = "Error: qunatity provided is too small.";

    public QuantityTooLowException() {
        super(errorMsg);
    }

    public QuantityTooLowException(String s) {
        super(errorMsg);
    }

    public QuantityTooLowException(String message, Throwable cause) {
        super(errorMsg, cause);
    }

    public QuantityTooLowException(Throwable cause) {
        super(errorMsg, cause);
    }
    
    
}
