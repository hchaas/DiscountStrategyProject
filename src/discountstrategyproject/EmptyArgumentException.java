
package discountstrategyproject;

public class EmptyArgumentException extends IllegalArgumentException {
    public static String errorMsg = "String cannot be empty";
   
    public EmptyArgumentException() {
        super(errorMsg);
    }
    
    public EmptyArgumentException(String s) {
        super(errorMsg);
    }

    public EmptyArgumentException(String message, Throwable cause) {
        super(errorMsg, cause);
    }

    public EmptyArgumentException(Throwable cause) {
        super(errorMsg, cause);
    }
    
}
