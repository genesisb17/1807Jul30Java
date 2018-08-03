package com.revature.io;

public class SerializationExample {
	
	/*
	 * To serialization an object means to convert its state to a byte stream
	 * so that the byte stream can be reverted back into a copy of the object.
	 * A Java object is serializable if its class or any of its superclasses
	 * implements either Serializable or its subinterface Externalizable
	 * 
	 * STATE of the object, meaning its instance variables
	 * transient - means that instance var will not get serialized
	 * 
	 * Deserializing objects with transients or static vars will hold the
	 * default value for that data type
	 * 
	 * In order to serialize something, the class itself or a parent class
	 * must implemennt Serializable
	 */

	public static void main(String[] args) {
		
	}
	
	static void serializeObject(Object o) {
		
	}

}
