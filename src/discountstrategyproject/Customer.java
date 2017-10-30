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

    public final void setDataAccessStrategy(DataAccessStrategy dataAccess) throws NullArgumentException{
        if (dataAccess == null) {
            throw new NullArgumentException();
        }
        this.dataAccess = dataAccess;
    }

    public final void setCustID(String custID) throws IllegalArgumentException{
        if (custID == null){
            throw new NullArgumentException();
        }
        if (custID.isEmpty()) {
            throw new EmptyArgumentException();
                }

        this.custID = custID;
    }
    
    public final void setCustName(String custName) throws IllegalArgumentException{
        if (custName == null){
            throw new NullArgumentException();
        }
        if (custName.isEmpty()){
            throw new EmptyArgumentException();
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
