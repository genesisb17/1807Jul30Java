package com.revature.q11.p2;

/**
 * A simple class that houses the two Math constants as float types
 * 
 * get methods and a toString() method provided.
 * 
 * @author Kevin Hui
 *
 */
public class ElevenDoppelganger {
	public static final float float1 = (float) Math.PI;
	public static final float float2 = (float) Math.E;
	
	public float getFloat1() {
		return float1;
	}
	public float getFloat2() {
		return float2;
	}
	
	@Override
	public String toString() {
		return "ElevenDoppelganger [getFloat1()=" + getFloat1() + ", getFloat2()=" + getFloat2() + "]";
	}
	
	
}
