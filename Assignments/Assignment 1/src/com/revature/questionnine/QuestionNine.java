package com.revature.questionnine;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class QuestionNine {

	public static void main(String[] args) {
		List<Integer> zeroToHund = new ArrayList<Integer>();
		for(int i = 0; i <= 100; i++) {
			zeroToHund.add(i);
		}
		
		for(int i = 0; i < zeroToHund.size(); i++) {
			
			BigInteger check = new BigInteger(Integer.toString(
					zeroToHund.get(i)));
			if(check.isProbablePrime(1) == true) {
				System.out.println(zeroToHund.get(i));
			}
		}
	}
}
