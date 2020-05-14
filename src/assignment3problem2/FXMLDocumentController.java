/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3problem2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

/**
 *
 * @author akhil
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Label number1;
    @FXML
    private Label number2;
    @FXML
    private Label result;
    @FXML
    private TextField input1;
    @FXML
    private TextField input2;
    @FXML
    private TextField res;
    @FXML
    private Button compute;
    @FXML
    private Button quit;
    @FXML
    private Button plus;
    @FXML
    private Button minus;
    @FXML
    private Button mul;
    @FXML
    private Button greater_than;
    @FXML
    private Button less_than;
    @FXML
    private Button equals;
    
    int counter = -1;
    String functon;
    String replace;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        boolean plus_B = false;
        boolean minus_B = false;
        boolean mul_B = false;
        boolean greater_than_B = false;
        boolean less_than_B = false;
        boolean equals_B = false;
        boolean rescompare=false;
        
        int flag=0;
        int sign=0;
        
        try{
            if (event.getSource() == compute) {
                SLL number = new SLL();
                String inp;
                if (counter > 0) {
                    inp = replace;
                } else {
                    inp = input1.getText();//getting first number
                }
                inp =input1.getText(); 
                String inp2 = input2.getText();

                
                
                double input11=Double.parseDouble(inp);
                double input22=Double.parseDouble(inp2);
                
                if(input11<0 && input22 >0 && functon == "+"){
                    //System.out.println("We are inside case1:");
                    flag=2;
                    input11=-1*input11;
                    double temp=input11;
                    input11=input22;
                    input22=temp;
                    
                    inp=Double.toString(input11);
                    inp2=Double.toString(input22);
                    
                  //  System.out.println("inp is:"+inp);
                  //  System.out.println("inp2 is:"+inp2);
                  //  System.out.println("Flag is;"+flag);
                }
                else if(input11<0 && input22<0 && functon == "+"){
                flag=1;
                sign=1;
                input11=-1*input11;
                input22=-1*input22;
                inp=Double.toString(input11);
                inp2=Double.toString(input22);
                
                }
                else if(input11>0 && input22 <0 && functon == "+"){
                    flag=2;
                    input22=-1*input22;
                    inp2=Double.toString(input22);
                }
                else if(input11>0 && input22 >0 && functon == "+"){
                    flag=1;
                }
               
                
                else if(input11>0 && input22 <0 && functon == "-"){
                    flag=1;
                    input22=-1*input22;
                    inp2=Double.toString(input22);
                }
                else if(input11<0 && input22<0 && functon == "-"){
                    flag=2;
                    input11=-1*input11;
                    input22=-1*input22;
                    Double temp=input11;
                    input11=input22;
                    input22=temp;
                    inp=Double.toString(input11);
                    inp2=Double.toString(input22);
                
                }
                else if(input11<0 && input22 >0 && functon == "-"){
                    flag=1;
                    sign=1;
                    input11=-1*input11;
                    inp=Double.toString(input11);
                }
                else if(input11>0 && input22 >0 && functon == "-"){
                    flag=2;
                }
                
                else if(input11<0 && input22 <0 && functon == "*"){
                    input11=-1*input11;
                    input22=-1*input22;
                    inp=Double.toString(input11);
                    inp2=Double.toString(input22);
                    sign=1;
                }
                
                if(input11>input22 && functon == ">"){
                    rescompare=true;
                    //System.out.println("We are inside >:");
                }
                else if(input11<input22 && functon == ">"){
                    rescompare=false;
                    //System.out.println("We are inside > else:");
                }
                else if(input11<input22 && functon == "<"){
                    rescompare=true;
                    //System.out.println("We are inside <:");
                }
                else if(input11>input22 && functon == "<"){
                    rescompare=false;
                    //System.out.println("We are inside < else:");
                }
                else if(input11==input22 && functon == "=="){
                    rescompare=true;
                    //System.out.println("We are inside ==:");
                }
                else if(input11!=input22 && functon == "=="){
                    rescompare=false;
                    //System.out.println("We are inside == else:");
                }

                
                StringBuilder ninput1 = new StringBuilder(inp);
                StringBuilder ninput2 = new StringBuilder(inp2);
                
                if (!inp.contains(".")) {
                    ninput1.append(".0");
                }

                if (!inp2.contains(".")) {
                    ninput2.append(".0");
                }

                String num[] = number.lengthEqual(ninput1.toString(), ninput2.toString()).split("@");
                SLLNode slist1 = new BigNumber(num[0]).getfirstToback();
                SLLNode slist2 = new BigNumber(num[1]).getfirstToback();

                if (functon == "*") {
                    if(input1.getText().equals("0") || input2.getText().equals("0") || input1.getText().equals("0.0") || 
                       input2.getText().equals("0.0") || input1.getText().equals("0.00") || input2.getText().equals("0.00")){
                        System.out.println("we are inside multi");
                        res.setText("0");
                        return;
                    }
                    String resmul = number.multiplication(slist1, slist2);
                    res.setText(resmul);
                    replace = resmul;
                }
                if (flag==1 ) {
                    System.out.println("We are inside addition:");
                    String resadd = number.addition(slist1, slist2);
                    if(sign==1){
                        resadd="-"+resadd;
                    }
                    
                    res.setText(resadd);
                    replace = resadd;
                }

                if (flag==2) {
                    System.out.println("We are inside subtract:");
                    String ressub = number.substraction(slist1, slist2);
                    
                    if(sign==1){
                        ressub="-"+ressub;
                    }
                    
                    res.setText(ressub);
                    replace = ressub;
                }

                if (functon == ">" || functon == "<" || functon == "==") {
                    //boolean rescompare = number.compare(slist1, slist2, functon);

                    res.setText(String.valueOf(rescompare));
                }

                if (functon == "") {
                    res.setText("Please select the functon");
                }
            }
        }catch(Exception err){
            System.out.println("invalid input");
            res.setText("invalid input");
        }
        
        if (event.getSource() == plus) {
            label.setVisible(true);
            label.setText("+");
            label.setFont(new Font("Arial", 65));
            plus_B = true;
            functon = "+";
            counter++;
            if (counter > 0) {
                input1.setText(replace);
                input2.setText("");
                res.setText("");
            }
        }

        if (event.getSource() == minus) {
            label.setVisible(true);
            label.setText("-");
            label.setFont(new Font("Arial", 65));
            minus_B = true;
            functon = "-";
            counter++;
            if (counter > 0) {
                input1.setText(replace);
                input2.setText("");
                res.setText("");
            }
        }

        if (event.getSource() == mul) {
            label.setVisible(true);
            label.setText("*");
            label.setFont(new Font("Arial", 65));
            mul_B = true;
            functon = "*";
            counter++;
            if (counter > 0) {
                input1.setText(replace);
                input2.setText("");
                res.setText("");
            }
        }

        if (event.getSource() == greater_than) {
            label.setVisible(true);
            label.setText(">");
            label.setFont(new Font("Arial", 65));
            greater_than_B = true;
            functon = ">";
            if (counter > 0) {
                input1.setText(replace);
                input2.setText("");
                res.setText("");

            }
        }

        if (event.getSource() == less_than) {
            label.setVisible(true);
            label.setText("<");
            label.setFont(new Font("Arial", 65));
            less_than_B = true;
            functon = "<";
            if (counter > 0) {
                input1.setText(replace);
                input2.setText("");
                res.setText("");
                res.setText(functon);
            }
        }
        
        if (event.getSource() == equals) {
            label.setVisible(true);
            label.setText("==");
            label.setFont(new Font("Arial", 35));
            equals_B = true;
            functon = "==";
            if (counter > 0) {
                input1.setText(replace);
                input2.setText("");
                res.setText("");
                res.setText(functon);
            }
        }
        
        if (event.getSource() == quit) {
            System.exit(0);
        }    
    }
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
