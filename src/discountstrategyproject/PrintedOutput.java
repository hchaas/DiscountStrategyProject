/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategyproject;

/**
 *
 * @author User
 */
public class PrintedOutput implements ReceiptOutputStrategy {
//    private Receipt receipt;
    
//    public ReceiptOutput(Receipt receipt){
//        this.receipt = receipt;
//    }
    
    @Override
    public void output(Receipt receipt){
        System.out.println("Printed receipt.");
    }
}
