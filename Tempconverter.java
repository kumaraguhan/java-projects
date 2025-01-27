package com.prodigy.tempconverter;

import java.util.*;

class temperature{
    
public void temp(double input, char input2){ 
    
    switch(input2){
        
        case 'K':
            
            double out = (input - 273.15) * 1.8 + 32;
            System.out.println("Equivalent Farenheit is" + out + "F");
            double out2 = input - 273.15;
            System.out.println("Equivalent Celsius is" + out2 + "C");
            
            break;
            
        case 'k':
            
            double out1 = (input - 273.15) * 1.8 + 32;
            System.out.println("Equivalent Farenheit is" + out1 + "F");
            double out22 = input - 273.15;
            System.out.println("Equivalent Celsius is" + out22 + "C");
            
            break;
            
        case 'c':
            
            double out11 = (input * 1.8) + 32;
            System.out.println("Equivalent Farenheit is" + out11 + "F");
            double out222 = input + 273.15;
            System.out.println("Equivalent Kelvin is" + out222 + "K");
            
            break;
            
        case 'C':
            
            double out111 = (input * 1.8) + 32;
            System.out.println("Equivalent Farenheit is" + out111 + "F");
            double out2222 = input + 273.15;
            System.out.println("Equivalent Kelvin is" + out2222 + "K");
            
            break;
            
        case 'f':
            
            double out1111 = (input - 32) / 1.8;
            System.out.println("Equivalent Celsius is" + out1111 + "C");
            double out22222 = (input - 32) / 1.8 + 273.15;
            System.out.println("Equivalent Kelvin is" + out22222 + "K");
            
            break;
            
        case 'F':
            
            double out11111 = (input - 32) / 1.8;
            System.out.println("Equivalent Celsius is" + out11111 + "C");
            double out222222 = (input - 32) / 1.8 + 273.15;
            System.out.println("Equivalent Kelvin is" + out222222 + "K");
            
            break;
        
    }
    
}

}


public class Tempconverter {

    public static void main(String[] args) {
        System.out.println("Enter the Temperature value alone");
        Scanner Sc = new Scanner(System.in);
        double tempValue = Sc.nextDouble();
        
        
       
        System.out.println("Enter the Unit - F for Farenheit, K for Kelvin, C for Celsius");
        char tempUnit = Sc.next().charAt(0);
        
        temperature Obj = new temperature();
        Obj.temp(tempValue,tempUnit);
    }
}
