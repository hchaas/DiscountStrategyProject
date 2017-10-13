
package discountstrategyproject;

public class NoDiscount implements DiscountStrategy{
    
    @Override
    public double getDiscount(){
        return 0;
    }
}
