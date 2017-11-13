
package discountstrategyproject;

public class NoDiscount implements DiscountStrategy{
    
    @Override
    public final double getDiscount(){
        return 0;
    }

    @Override
    public String toString() {
        return "NoDiscount";
    }
    
    
}
