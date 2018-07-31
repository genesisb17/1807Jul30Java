package com.revature.war;

public class GrassHopper {
	public static void main(String[] args) {
		int n = 36;
		int count = n;
		int total = 0;
		
		while (count > 0) {
			total += count;
			count -= 1;
		}
		
		System.out.println(total);
	}
}