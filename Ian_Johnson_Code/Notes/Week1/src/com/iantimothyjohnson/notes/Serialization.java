package com.iantimothyjohnson.notes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("unused")
public class Serialization {
	// Serializing an object means to convert its state to a byte stream so
	// that the byte stream can be reverted back into a copy of the object.
	// A Java object is serializable if its class or any of its superclasses
	// implements either Serializable or its subinterface Externalizable.

	// Only instance variables are serialized (the object's state),
	// excluding any marked transient.

	// Serializable is a marker interface; it has no methods, but it needs to be
	// explicitly marked as implemented to be able to (de)serialize a class.
	private static class Student implements Serializable {
		// We should have this value to ensure that there are no conflicts
		// between different versions of this class.
		private static final long serialVersionUID = 1L;

		private String name;
		private String email;
		// Transient members will not be serialized.
		private transient double grade;

		public Student(String name, String email, double grade) {
			super();
			this.name = name;
			this.email = email;
			this.grade = grade;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public double getGrade() {
			return grade;
		}

		public void setGrade(double grade) {
			this.grade = grade;
		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", email=" + email + ", grade=" + grade + "]";
		}
	}

	public static void main(String[] args) {
		Student student = new Student("Ian", "ij6fd@virginia.edu", 3.9);
		serializeObject(student);
		System.out.println(deserializeObject());
	}

	private static void serializeObject(Object o) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serial.txt"))) {
			oos.writeObject(o);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Object deserializeObject() {
		Object obj = null;

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serial.txt"))) {
			obj = ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return obj;
	}
}
