
package discountstrategyproject;

public class PercentOffDiscount implements DiscountStrategy{
    private double discountPercent;
    
    public PercentOffDiscount(double discountPercent){
        this.discountPercent = discountPercent;
    }
    
    @Override
    public double getDiscount(){
        return discountPercent;
    }
}
