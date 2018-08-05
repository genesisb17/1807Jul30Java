package com.revature.hw;

import java.util.ArrayList;

public class ArrayListManipulation {
	
	public static ArrayList<Integer> fillArray() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i < 11; i++) {
			list.add(i);
		}
		return list;
	}
	
	public static int addThem(ArrayList<Integer> inbound){
		int tempInt = 0;
		for(int i = 0;i < inbound.size(); i++) {
			if(inbound.get(i) % 2 == 0) {
				tempInt += inbound.get(i);
			}
		}
		
		return tempInt;
	}
	
	public static ArrayList<Integer> rtPrime(ArrayList<Integer> list){
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		int num;
		Boolean check;
		for(int i = 2; i < list.size(); i++) {
			check = true;
			num = (Integer) list.get(i);
			for(int j = 2; j < i; j++) {
				if(num % j == 0) {
					check = false;
					break;
				}
			}
			if(check == true && num != 1 && num != 0) {
				tempList.add(num);

			}
		}
		return tempList;
	}

	public static void main(String[] args) {
		ArrayList<Integer> myList1 = new ArrayList<Integer>();
		ArrayList<Integer> myList2 = new ArrayList<Integer>();

		myList1 = ArrayListManipulation.fillArray();
		System.out.println(myList1);
		
		int evenTotal = ArrayListManipulation.addThem(myList1);
		System.out.println(evenTotal);
		
		myList2 = ArrayListManipulation.rtPrime(myList1);
		System.out.println(myList2);
		
		
	}

}
