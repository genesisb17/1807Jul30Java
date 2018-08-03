package com.revature.substring;

import java.util.*;

public class Substring {
	
	public static String getString(String s, String sub, int x) {
		s = s.toLowerCase();
		sub = sub.toLowerCase();
		String checkString = "";
		String newString = "";
		int indexOf = 0;
		
		if (x > 0) {
			for (int i = 0 ; i < x ; i++)
				newString = newString + s.charAt(i);
		}
		
		for (int i = x ; i < s.length() ; i++ ) {
			char a = s.charAt(i);
			if (a == sub.charAt(indexOf)) {
				checkString = checkString + a;
				indexOf++;
				if (indexOf >= sub.length())
					indexOf = 0;
			}
			else {
				if (indexOf != 0)
					newString = newString + checkString;
				indexOf = 0;
				newString = newString + a;
			}
		}
		return newString;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        String s = sc.next();,
        String sub = sc.next();
        int x = sc.nextInt();
		String newString = getString(s, sub, x);
		System.out.println(newString);
		sc.close();
	}
}