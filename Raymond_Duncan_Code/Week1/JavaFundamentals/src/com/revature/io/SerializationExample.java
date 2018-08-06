package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationExample {
	/*
	 * To serialize an object means to convert its state
	 * to a byte stream so that the byte stream can be reverted
	 * back into a copy of the object. A Java object is
	 * serializable if its class or any of its superclasses
	 * implements either Serializable or its subinterface
	 * Externalizable
	 * 
	 * STATE of the object, meaning its instance variables
	 * transient - means that instance var will not get serialized
	 * 
	 * deserializing objects w/ transient or static vars will
	 * hold the default value for that data type
	 */
	public static void main(String[] args) {
		Student s = new Student("Raymond","raymond.duncan@colorado.edu",99.99,(Object) "Test");
		serializeObject(s);
		
		Student fromFile = (Student) deserializeObject();
		System.out.println(fromFile.toString());
	}
	
	static void serializeObject(Object o){
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/files/serial.txt"))){
			oos.writeObject(o);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static Object deserializeObject() {
		Object obj = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/files/serial.txt"))){
			obj = ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

}
