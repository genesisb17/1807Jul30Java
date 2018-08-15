package com.revature.intro;

public class NthEvenNumber {

	public static int nthEven(int n) {
        if (n == 1) {
           return 0;
        }
        
        int x = (n-1);
        int y= x*2;
        
        
        return y;
     }
	
public static void main(String[] args) {
	NthEvenNumber.nthEven(6);
}

    
    

  
}
