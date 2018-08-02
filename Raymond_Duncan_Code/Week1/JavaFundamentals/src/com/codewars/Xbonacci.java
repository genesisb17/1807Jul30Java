package com.codewars;

public class Xbonacci {
	public double[] tribonacci(double[] s, int n) {
	      //TODO: Check that the signature (s) has a length of 3
	      
	      //TODO: Check that the number of elements requested (n) is greater than or equal to 0
	      
	      double[] sequence = s;
	      for(int i = 3; i < n; i++){
	          sequence[i] = sequence[i-1] + sequence[i-2] + sequence[i-3];
	      }
	      return sequence;
	  }

}
