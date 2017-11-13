
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.discountPercent) ^ (Double.doubleToLongBits(this.discountPercent) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PercentOffDiscount other = (PercentOffDiscount) obj;
        if (Double.doubleToLongBits(this.discountPercent) != Double.doubleToLongBits(other.discountPercent)) {
            return false;
        }
        return true;
    }
    
    @Override
    public final String toString(){
        return "Percent off discount in the amount of " + this.discountPercent;
    }
}
