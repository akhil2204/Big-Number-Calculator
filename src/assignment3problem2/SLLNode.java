/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3problem2;

/**
 *
 * @author akhil
 */
public class SLLNode {
    private SLLNode succ;
    private String data;
    
    public SLLNode(String data){
        this.data=data;
    }
    
    public void setNext(SLLNode succ) {
        this.succ = succ;
    }

    public SLLNode getNext() {
        return succ;
    }

    public String getData() {
        return data;
    }
    
}
