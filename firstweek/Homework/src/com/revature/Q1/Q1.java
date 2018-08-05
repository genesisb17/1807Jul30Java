package com.revature.Q1;

import java.util.Arrays;

public class Q1 {
	
	public static void bubbleSort(int[] n) {
		
		for(int i=0; i < n.length; i++) {
			for(int j = i+1; j<n.length; j++) {
				int temp = n[i];
				if(n[i] > n[j]) {
					
				
				n[i] = n[j];
				n[j] = temp;
			}	
		}
	}System.out.println(Arrays.toString(n));
			
		
}
	public static void main(String[] args) {
	
		int[] num = {1,0,5,6,3,2,3,7,9,8,4};
		Q1.bubbleSort(num);
	}
}
	

