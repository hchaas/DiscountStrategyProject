
package discountstrategyproject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class POSRegisterTest {
    POSRegister register;
    
    public POSRegisterTest() {
        register = new POSRegister();
    }
    
    @Before
    public void setUp() {
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
