package discountstrategyproject;

public class InMemoryDataAccess implements DataAccessStrategy{

    private Customer[] customers = {
        new Customer("100", "John Smith"),
        new Customer("200", "Sally Jones"),
        new Customer("300", "Bob Clementi")
    };

    private Product[] products = {
        new Product("A101", "MLB Brewer's Hat ", 19.95, new PercentOffDiscount(0.15)),
        new Product("B205", "Men's Dress Shirt", 35.50, new PercentOffDiscount(0.15)),
        new Product("C222", "Women's Socks", 9.50, new NoDiscount()),
    };

    @Override
    public Customer getCustomerData(String custID) {
        //validation needed for parameter
        if (custID == null || custID.length() == 0) {
            System.out.println("Sorry, InMemoryDataAccess.getCustomerData method has "
                    + "illegal argument");
            return null;  // end method prematurely after log to console
        }

        Customer customer = null;
        for (Customer c : customers) {
            if (custID.equals(c.getCustID())) {
                customer = c;
                break;
            }
        }

        return customer;

    }

    @Override
    public final Product getProductData(final String prodId) {
        // validation is needed for method parameter
        if (prodId == null || prodId.length() == 0) {
            System.out.println("Sorry, InMemoryDataAccess.getProductData method has "
                    + "illegal argument");
            return null;  // end method prematurely after log to console
        }

        Product product = null;
        for (Product p : products) {
            if (prodId.equals(p.getProdID())) {
                product = p;
                break;
            }
        }

        return product;
    }
}
