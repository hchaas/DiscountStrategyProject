package discountstrategyproject;

public class Customer {

    private DataAccessStrategy dataAccess;
    private String custID;
    private String custName;

    public Customer(DataAccessStrategy dataAccess) {
        this.setDataAccessStrategy(dataAccess);
    }

    public Customer(String custID, String custName) {
        this.setCustID(custID);
        this.setCustName(custName);
    }

    public final void setDataAccessStrategy(DataAccessStrategy dataAccess) throws IllegalArgumentException{
        if (dataAccess == null) {
            throw new IllegalArgumentException("Data access strategy cannot be null.");
        }
        this.dataAccess = dataAccess;
    }

    public final void setCustID(String custID) throws IllegalArgumentException{
        if (custID == null || custID.isEmpty()){
            throw new IllegalArgumentException("Customer ID cannot be null.");
        }
        this.custID = custID;
    }
    
    public final void setCustName(String custName) throws IllegalArgumentException{
        if (custName == null || custName.isEmpty()){
            throw new IllegalArgumentException("Customer name cannot be null.");
        }
        this.custName = custName;
    }
    
    
    public final String getCustID() {
        return custID;
    }

    public final String getCustomerName() {
        return custName;
    }

    public final Customer findCustomer(String custID) {
        return dataAccess.getCustomerData(custID);
    }
}
