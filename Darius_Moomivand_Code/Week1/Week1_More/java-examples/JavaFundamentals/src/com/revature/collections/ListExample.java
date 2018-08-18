package com.revature.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExample {
	
	public static void linkedListExample() {
		List<Integer> myLinkedList = new LinkedList<>();
		myLinkedList.add(25);
		myLinkedList.add(50);
		myLinkedList.add(75);
		myLinkedList.add(100);
		
		// Use the set(int index, E element) method to replace the element at the specified index
		myLinkedList.set(2, 125);
		
		// Use the size() method to get the number of elements in the List
		for (int i = 0; i < myLinkedList.size(); i++) {
			System.out.println(myLinkedList.get(i));
		}
	}
	
	public static void arrayListExample() {
		List<String> myStrings = new ArrayList<>();
		// Insert into elements into an ArrayList with the add() method
		myStrings.add("Charizard");
		myStrings.add("Aerodactyl");
		myStrings.add("Mr. Mime");
		myStrings.add("Dragonite");
		myStrings.add("Pikachu");
		
		// Index Driven => can be accessed using the get() method
		System.out.println(myStrings.get(3));	
		
		
		// Can be removed using the remove() method
		myStrings.remove(0);
		
		// They maintain the order of insertion
		for (String s : myStrings) {
			System.out.println(s);
		}
	}


}
