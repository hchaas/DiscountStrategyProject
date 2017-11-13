package discountstrategyproject;

import java.util.Objects;

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
    
    @Override
    public final String toString(){
        return ("This customer object represents " + this.custName + " associated with " + this.custID + " customer ID." +
                "\nData Access Strategy: " + this.dataAccess.toString());
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
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.custName, other.custName)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.dataAccess);
        hash = 43 * hash + Objects.hashCode(this.custID);
        hash = 43 * hash + Objects.hashCode(this.custName);
        return hash;
    }
    
}
