/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategyproject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class CustomerTest {
    private Customer c;
    
    public CustomerTest() {
    }
    
    @Before
    public void setUp() {
        c = new Customer(dataAccessStrategy dataAccess);
    }
    
    @After
    public void tearDown() {
    }
    
    //setCustID should not be null or empty, and it should throw an exception if it is
    @Test (expected = NullArgumentException.class)
    public void dataAccessStrategyShouldNotBeNull(){
        
    }

}