package guessinggame;

import java.util.*;
import java.lang.Math.*;

class randomnumgen{
    
   int max = 50;
   int min = 0;
   int a = (int)(Math.random()*(max-min+1)+min);
   
   public void numbercheck(){
       
      Scanner sobj = new Scanner(System.in);
      
      int num =  sobj.nextInt();
      int i=1;
      
      while(num != a){
          i++;
          num =  sobj.nextInt();
          if(num > (a+10)){
              System.out.println("The number is too large");
          }
          else if(num < (a-10)){
              System.out.println("The number is too low");
          }
      }
      
      System.out.println("You have guuessed the correct Number");
      System.out.println("Number of attempts - " + i);
   }
    
}


public class guessing {
    
    public static void main(String[] args){
        
        System.out.println("Welcome to Number guessing game");
        System.out.println("Enter a Number");
        
        /*Scanner sobj = new Scanner(System.in);
        int num =  sobj.nextInt();*/
        
        randomnumgen obj = new randomnumgen();
        obj.numbercheck();
        
    }
    
    
}
