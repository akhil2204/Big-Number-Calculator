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
public class BigNumber {
    private SLLNode firsttoback = null;
    SLL number = new SLL();

    public BigNumber(String input) {
        if (firsttoback != null) {          //if first value not null assign as null
            firsttoback = null;
        }
        for (int i = input.length(); i > 0; i--) {
            firsttoback = number.addToList(firsttoback, input.substring(i - 1, i));
        }
    }

    public SLLNode getfirstToback() {
        return firsttoback;
    }
    
} 
