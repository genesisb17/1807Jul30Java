package com.revature.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
		Student s = new Student("Gen", "gab12@duke.edu", 100);
		serializeObject(s);
	}
	
	static void serializeObject(Object o) {
		try(ObjectOutputStream oos =
				new ObjectOutputStream(new FileOutputStream("src/files/serial.txt"))){
			oos.writeObject(o);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
