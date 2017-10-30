
package discountstrategyproject;

class NullArgumentException extends IllegalArgumentException {
    public static String errorMsg = "Argument cannot be null.";

    public NullArgumentException() {
        super(errorMsg);
    }

    public NullArgumentException(String s) {
        super(errorMsg);
    }

    public NullArgumentException(String message, Throwable cause) {
        super(errorMsg, cause);
    }

    public NullArgumentException(Throwable cause) {
        super(errorMsg, cause);
    }
    
    
}
