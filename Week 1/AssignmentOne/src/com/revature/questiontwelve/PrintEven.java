package com.revature.questiontwelve;

import java.util.ArrayList;
import java.util.List;

public class PrintEven {
	
	public static void main(String[] args) {
		List<Integer> n = new ArrayList<Integer>();
		for(int i = 0; i <= 100; i++) {
			n.add(i);
		}
		
		for(int even:n) {
			if(even%2 == 0) {
				System.out.println(even);
			}
		}
	}
}
