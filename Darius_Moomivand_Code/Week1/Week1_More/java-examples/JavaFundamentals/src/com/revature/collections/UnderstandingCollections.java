package com.revature.collections;

import java.util.ArrayList;

public class UnderstandingCollections {
	
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		a.add(null);
		a.add(new Integer(5));
		a.add("ahoiajoj");
		
		for(Object o : a) {
			System.out.println(o);
		}

	}

}
