package q1;
import java.util.*;
import java.io.*;

public class bubSort {
	
	static int[] b=new int[] {1,0,5,6,3,2,3,7,9,8,4};
	
	public static int[] bubSor() {
	for (int i=0; i<b.length-1; i++) {	
		int temp;
		if(b[i]>b[i+1]) {
			temp=b[i];			
			b[i]=b[i+1];
			b[i+1]=temp;		
		}	
	}
	
	return b;
	
	}
	/*
	 * throws goes after the method and calling method must handle exception 
	 */

	public static void main(String[] args) {
		int[] a=bubSor();
		
		for(int t:a) {
			System.out.println(t);
		}
	
		//System.out.println();
	
	}



}
