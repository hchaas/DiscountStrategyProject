
package discountstrategyproject;

public class Customer {
    private DataAccessStrategy dataAccess;
    private String custID;
    private String custName;
    
    public Customer(DataAccessStrategy dataAccess){
        this.dataAccess = dataAccess;
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
        return dataAccess.getCustomerData(custID);
    }
}
