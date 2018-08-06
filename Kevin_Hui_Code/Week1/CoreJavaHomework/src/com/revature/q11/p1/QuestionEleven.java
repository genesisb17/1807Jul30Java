package com.revature.q11.p1;

import com.revature.q11.p2.ElevenDoppelganger;

public class QuestionEleven {
	
	/**
	 * Two ways to access the public static final float variables from
	 * the ElevenDoppelganger class
	 * 
	 * @param args N/A
	 */
	public static void main(String[] args) {
		
		// Option 1: create a new object, and invoke the get methods.
		ElevenDoppelganger ed = new ElevenDoppelganger();
		
		System.out.println("getFloat1() => " + ed.getFloat1());
		System.out.println("getFloat2() => " + ed.getFloat2());
		
		// Option 2: access the static final variables
		System.out.println("ElevenDoppelganger.float1 => " + ElevenDoppelganger.float1);
		System.out.println("ElevenDoppelganger.float2 => " + ElevenDoppelganger.float2);

	}

}
