package com.revature.listexercise;

import java.util.ArrayList;
import java.util.List;

public class Exercises {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList();
		for(int i = 0; i < 10; i++) {
			list.add(i);
		}
		list.add(4,20);
		
		System.out.println(list);
	}

}
