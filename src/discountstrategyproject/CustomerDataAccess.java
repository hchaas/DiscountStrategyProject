package discountstrategyproject;

public class CustomerDataAccess {
    
    private Customer[] customers = {
        new Customer("100", "John Smith"),
        new Customer("200", "Sally Jones"),
        new Customer("300", "Bob Clementi")
    };

    public Customer getData(String custID){
        //validation needed for parameter
                if(custID == null || custID.length() == 0) {
            System.out.println("Sorry, FakeDatabase.findCustomer method has "
                    + "illegal argument");
            return null;  // end method prematurely after log to console
        }
        
        Customer customer = null;
        for(Customer c : customers) {
            if(custID.equals(c.getCustID())) {
                customer = c;
                break;
            }
        }
        
        return customer;
    
    }
    
}