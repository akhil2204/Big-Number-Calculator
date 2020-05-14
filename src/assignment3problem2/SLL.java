/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3problem2;

import java.math.BigInteger;

/**
 *
 * @author akhil
 */
public class SLL {
    
    public SLLNode addToList(SLLNode head,String data){
        if(head==null){
            head=new SLLNode(data);
            head.setNext(null);
            return head;
        }
        SLLNode curr=head;
        while(curr.getNext()!=null){
            curr=curr.getNext();
        }
        SLLNode temp=new SLLNode(data);
        curr.setNext(temp);
        temp.setNext(null);
        return head;
    }
    
    public String lengthEqual(String s,String s1){
  
        StringBuilder builder1=new StringBuilder("");
        StringBuilder builder2=new StringBuilder("");
        StringBuilder finalinput= new StringBuilder("");
        
        if(s.length()==s1.length()){
            finalinput.append(s);
            finalinput.append("@");
            finalinput.append(s1);
            return finalinput.toString();
        }
        else{
            String arr1[] = s.split("\\.");
            String arr2[] = s1.split("\\.");
            boolean flag0=false;
            boolean flag1=false;
            if((arr1[0].length() < arr2[0].length()) || (arr1[0].length() > arr2[0].length())){ 
                if(arr1[0].length()<arr2[0].length()){
                    int diff=arr2[0].length()-arr1[0].length();
                 
                    for(int i=0;i<diff;i++){
                        builder1.append("0");
                    }
                    flag0=true;
                    builder1.append(arr1[0]);
             
                }else if(arr1[0].length()>arr2[0].length()){
                     int diff=arr1[0].length()-arr2[0].length();
             
                    for(int i=0;i<diff;i++){
                        builder2.append("0");
                    }
                    builder2.append(arr2[0]);
                
                }
                if(flag0){
                    builder2.append(arr2[0]);
                }else{
                    builder1.append(arr1[0]);
                }
            }else{
                builder1.append(arr1[0]);
                builder2.append(arr2[0]);
            }
            
            StringBuilder builder3=new StringBuilder("");
            StringBuilder builder4=new StringBuilder("");
             if((arr1[1].length() < arr2[1].length()) || (arr1[1].length() > arr2[1].length())){ 
                if(arr1[1].length() < arr2[1].length()){
                    int diff=arr2[1].length()-arr1[1].length();
                 
                     builder3.append(arr1[1]);
                    for(int i=0;i<diff;i++){
                        builder3.append("0");
                    }
                   flag1=true;
                 
                }else if(arr1[1].length() > arr2[1].length()){
                    int diff=arr1[1].length()-arr2[1].length();
                 
                     builder4.append(arr2[1]);
                    for(int i=0;i<diff;i++){
                        builder4.append("0");
                    }
                 
                } if(flag1){
                    builder4.append(arr2[1]);
                }else{
                    builder3.append(arr1[1]);
                }
             }else{
                 builder3.append(arr1[1]);
                 builder4.append(arr2[1]);
             }
             builder1.append(".");
             builder1.append(builder3.toString());
             builder2.append(".");
             builder2.append(builder4.toString());
         
            finalinput.append(builder1.toString());
            finalinput.append("@");
            finalinput.append(builder2.toString());
            return finalinput.toString();     
        }
    }
    
    public void printFirstToLast(SLLNode head){
        if(head==null){
            System.out.println("null");
        }else{
            SLLNode curr=head;
            while(curr!=null){
                System.out.print(curr.getData());
                curr=curr.getNext();
            }
             System.out.println();
        }
    }
    
    public boolean compare(SLLNode head,SLLNode head1,String operator){
        SLLNode curr=reverse(head);
        SLLNode currreverse=reverse(head1);
            
        if(operator=="<"){
            while(curr!=null  && currreverse!=null )
            {
                if(curr.getData() != "." && currreverse.getData()!="."){
                    int value1= Integer.parseInt(curr.getData());
                    int value2= Integer.parseInt(currreverse.getData());
                    
                    if(value1<value2){
                        return true;
                    }else{
                        return false;
                    }
                }
                curr=curr.getNext();
                currreverse=currreverse.getNext();
            }
        }
        
        else if(operator=="=="){
            while(curr!=null && currreverse!=null)
            {
                if(curr.getData() != "." && currreverse.getData()!="."){
                    int value1= Integer.parseInt(curr.getData());
                    int value2= Integer.parseInt(currreverse.getData());
                    if(value1 != value2){
                        return false;
                    }
                    return true;
                }
                curr=curr.getNext();
                currreverse=currreverse.getNext();
            }
        }
        
        else if(operator==">"){
            while(curr!=null && currreverse!=null){
                if(curr.getData() != "." && currreverse.getData()!="."){
                    int value1= Integer.parseInt(curr.getData());
                    int value2= Integer.parseInt(currreverse.getData());
                    if(value1>value2){
                        return true;
                    }else{
                        return false;
                    }
                }
                curr=curr.getNext();
                currreverse=currreverse.getNext();  
            }
        }   
        return true;
    }
    
    public String addition(SLLNode head1,SLLNode first2){
        SLLNode sum;
        SLLNode curr1=head1;
        SLLNode curr2=first2;
        StringBuilder sb=new StringBuilder("");
        int carry=0;
        while(curr1!=null){
            String number1=curr1.getData();
            String number2=curr2.getData();
            
            System.out.println("NUmber1 is:"+number1);
            System.out.println("Number2 is:"+number2);
            
            if(!(number1.trim().equals(".")) && !(number2.trim().equals(".")) ){
                int a1=Integer.parseInt(number1);
                int a2=Integer.parseInt(number2);
                
                System.out.println("NUmber1 is:"+a1);
                System.out.println("Number2 is:"+a2);
                int sum1=a1+a2+carry;
                if(sum1>9){
                    carry=1;                    
                }else{
                    carry=0;
                }
                
                if(Integer.toString(sum1).length()>1){
                    sb.append(Integer.toString(sum1).charAt(1));
                }else{
                     sb.append(Integer.toString(sum1).charAt(0));
                }
            }else{ 
                sb.append(".");
            }
            curr1=curr1.getNext();
            curr2=curr2.getNext();
        }
        
        if(carry==1){
            sb.append("1");
        }
      return sb.reverse().toString();     
    }
    
    public String substraction(SLLNode head1,SLLNode head2){
        SLLNode curr1=head1;
        SLLNode curr2=head2;
        
        SLLNode before1=null;
        SLLNode before2=null;
        
        StringBuilder sb=new StringBuilder("");
        int borrow=0;
      
        while(curr1.getNext()!=null){
            curr1=curr1.getNext();
            curr2=curr2.getNext();
             
        }
         
        if((Integer.parseInt(curr1.getData())-Integer.parseInt(curr2.getData()))<=0){
            curr1=head1;
            curr2=head2;
            while(curr1!=null){
              String number1=curr1.getData();
              String number2=curr2.getData();
              
             if(!(number1.trim().equals(".")) && !(number2.trim().equals(".")))
             {
           
                int a1=Integer.parseInt(number1);
                int a2=Integer.parseInt(number2);
                  a2 = a2 - borrow;
                  
                if(a1>a2){
                    sb.append((a2+10)-a1);
                    borrow =1;
                }
                
                else if (a1<a2)
                { 
                    borrow =0;
                    sb.append(Math.abs((a2) - a1));
                } 
                else if(a1 == a2){
                    sb.append("0");
                    borrow=0;
                }
                }else{
                    sb.append(".");
                }
                 curr1=curr1.getNext();
                 curr2=curr2.getNext(); 
                }
                sb.append("-");
                return sb.reverse().toString();
        }else
        {
            curr1=head1;
            curr2=head2;
            borrow =0;
            while(curr2!=null){
            String num1=curr1.getData();
            String num2=curr2.getData();
            if(!(num1.trim().equals(".")) && !(num2.trim().equals(".")))
            {
                int nb1=Integer.parseInt(num1);
                int nb2=Integer.parseInt(num2);
                nb1 = nb1 - borrow;
                if(nb1>= nb2){
                    sb.append(nb1-nb2);
                    borrow =0;
                }else if (nb1<nb2){
                    borrow =1;
                    sb.append((nb1+10) - nb2);
                } else if(nb1 == nb2){
                    sb.append("0");
                    borrow =0;
                }           
            }else{
                sb.append(".");
            }
            before1=curr1;
            curr1=curr1.getNext();
            before2=curr2;
            curr2=curr2.getNext();
        }
          if(borrow==1){
            String f1=before1.getData();
            String f2=before2.getData();
            int f=Math.abs(Integer.parseInt(f1)-Integer.parseInt(f2));
            sb.deleteCharAt(sb.length()-1);
            sb.append(f);
            sb.append("-");
        }
        return sb.reverse().toString();
        }
    } 
     
    public String multiplication(SLLNode first1, SLLNode head2){
        SLLNode curr1= first1;
        SLLNode curr2=head2;
        StringBuilder s1= new StringBuilder("");
        StringBuilder s2=new StringBuilder("");
        boolean flag=true;
        int succdot=0;
        while(curr1!=null){
            if(!(curr1.getData().equals(".")) && !(curr2.getData().equals("."))){
                s1.append(curr1.getData());
                s2.append(curr2.getData());
                if(flag){
                    succdot++;
                }
            }else{
                flag=false;
            }
            curr1=curr1.getNext();
            curr2=curr2.getNext();
        }
  
             BigInteger largenum = new BigInteger(s1.reverse().toString());
        
                largenum=largenum.multiply(new BigInteger(s2.reverse().toString()));
        
               StringBuilder muloutput=new StringBuilder(largenum.toString());
        String ss1=muloutput.substring(0,muloutput.length()-succdot*2);
        String ss2=muloutput.substring(muloutput.length()-succdot*2, muloutput.length());
        muloutput=new StringBuilder("");
        muloutput.append(ss1);
        muloutput.append(".");
        muloutput.append(ss2);
        
        return muloutput.toString();
        
    }
    
    public SLLNode reverse(SLLNode head) {  
        if(head==null){
            return null;
        }
        if(head.getNext()==null){
            return head;
        }
 
    SLLNode nextnode=null;
    SLLNode currentnode=head;
    SLLNode previousnode=null;
    
        while(currentnode!=null){
            nextnode=currentnode.getNext();
            currentnode.setNext(previousnode);
            previousnode=currentnode;
            currentnode=nextnode;
        }
    head = previousnode;
    return head;
    }
    
}
