
package discountstrategyproject;

import javax.swing.JOptionPane;


public class ScreenOutput implements ReceiptOutputStrategy {
//    private Receipt receipt;
    
//    public ScreenOutput(Receipt receipt){
//        this.receipt = receipt;
//    }
    
    public void output(Receipt receipt){
        JOptionPane.showMessageDialog(null, "Printed receipt");
    }
}
