package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 * STATE of the object, meaning its instance variables
 * transient - means that instance variables wont get serialized
 * 
 * 
 */
//		Student s = new Student("Tiff","tiff@tiff.com", 100);
//		serializeObject(s);
		
		Student fromFile = (Student)deserializeObject();
		System.out.println(fromFile);
	}
	
	static void serializeObject(Object o) {
		try(ObjectOutputStream os = new ObjectOutputStream(
				new FileOutputStream("src/files/serial.txt"))){
			os.writeObject(o);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static Object deserializeObject() {
		Object obj = null;
		try(ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("src/files/serial.txt"))){
			obj = ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
