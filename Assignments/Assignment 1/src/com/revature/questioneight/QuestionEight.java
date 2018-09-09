package com.revature.questioneight;

import java.util.ArrayList;
import java.util.List;

public class QuestionEight {
	//ArrayList<Object type> variable name = new ArrayList<ObjectType)>();
	public static void main(String[] args) {
		List<String> ar = new ArrayList<String>();
		List<String> palin = new ArrayList<String>();
		ar.add("karan");
		ar.add("madam");
		ar.add("tom");
		ar.add("civic");
		ar.add("radar");
		ar.add("sexes");
		ar.add("jimmy");
		ar.add("kayak");
		ar.add("john");
		ar.add("refer");
		ar.add("billy");
		ar.add("did");
		
		Reverse reverseStr = new Reverse();

		for(int i = 0; i < ar.size(); i++) {
			if((ar.get(i)).compareTo(reverseStr.Reversed(ar.get(i))) == 0) {
				palin.add(ar.get(i));
			}
		}
		
		for(int i = 0; i < palin.size(); i++) {
			System.out.println(palin.get(i));
		}
	}
	
}
