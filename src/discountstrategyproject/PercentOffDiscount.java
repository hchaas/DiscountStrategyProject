
package discountstrategyproject;

public class PercentOffDiscount implements DiscountStrategy{
    private final double discountPercent;
    
    public PercentOffDiscount(double discountPercent){
        this.discountPercent = discountPercent;
    }
    
    @Override
    public final double getDiscount(){
        return discountPercent;
    }
}
