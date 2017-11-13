
package discountstrategyproject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class POSRegisterTest {
    private POSRegister register;
    
    public POSRegisterTest() {
    }
    
    @Before
    public void setUp() {
        register = new POSRegister();
    }
    
    @After
    public void tearDown() {
    }

    @Test (expected = NullArgumentException.class)
    public void custIDShouldNotBeNull(){
        register.setCustID(null);
    }
    
    @Test (expected = EmptyArgumentException.class)
    public void custIDShouldNotBeEmpty(){
        register.setCustID("");
    }
    
}
