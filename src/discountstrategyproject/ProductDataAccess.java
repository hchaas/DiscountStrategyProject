package discountstrategyproject;

public class ProductDataAccess {

    private Product[] products = {
        new Product("A101", "MLB Brewer's Hat ", 19.95, new PercentOffDiscount(0.15)),
        new Product("B205", "Men's Dress Shirt", 35.50, new PercentOffDiscount(0.15)),
        new Product("C222", "Women's Socks    ", 9.50, new NoDiscount())
    };

    public final Product findProduct(final String prodId) {
        // validation is needed for method parameter
        if (prodId == null || prodId.length() == 0) {
            System.out.println("Sorry, FakeDatabase.findProduct method has "
                    + "illegal argument");
            return null;  // end method prematurely after log to console
        }

        Product product = null;
        for (Product p : products) {
            if (prodId.equals(p.getProdId())) {
                product = p;
                break;
            }
        }

        return product;
    }
}
