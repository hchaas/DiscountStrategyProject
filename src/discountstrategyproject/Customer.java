
package discountstrategyproject;

public class Customer {
    private CustomerDataAccess customerData;
    private String custID;
    private String custName;
    
    public Customer(){
        CustomerDataAccess customerDataAccess = new CustomerDataAccess();
        customerDataAccess = customerData;
    }
    
    public Customer(String custID, String custName){
        this.custID = custID;
        this.custName = custName;
    }
    
    public String getCustID(){
        return custID;
    }
    
    public String getCustomerName(){
        return custName;
    }
    
    public Customer findCustomer(String custID){
        return customerData.getData(custID);
    }
}
