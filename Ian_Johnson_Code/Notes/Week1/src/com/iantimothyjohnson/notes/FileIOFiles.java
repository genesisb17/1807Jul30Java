package com.iantimothyjohnson.notes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class FileIOFiles {
	static IODAO dao = new IODAO();

	/**
	 * This is a POJO student class.
	 */
	private static class Student {
		private String name;
		private String email;
		private double grade;

		public static Student parseStudent(String str) {
			String[] studentInfo = str.split(";");
			return new Student(studentInfo[0], studentInfo[1], Double.parseDouble(studentInfo[2]));
		}

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
			return name + ";" + email + ";" + grade;
		}
	}

	/**
	 * This is a DAO (data access object). It holds no business logic; it is only
	 * used to provide communication with the filesystem (or a database, or
	 * whatever). In this case, it just reads from/writes to a text file.
	 */
	private static class IODAO {
		public void addStudent(Student student) {
			// Let's use this format for serialization:
			// name;email;grade

			// Try with resources: the BufferedWriter will automatically be
			// closed, regardless of whether we encounter an exception or not.
			try (BufferedWriter bw = new BufferedWriter(new FileWriter("students.txt", true))) {
				bw.write(student + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public List<Student> readStudents() {
			List<Student> students = new ArrayList<>();

			try (BufferedReader br = new BufferedReader(new FileReader("students.txt"))) {
				String line;
				while ((line = br.readLine()) != null) {
					students.add(Student.parseStudent(line));
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return students;
		}
	}

	public static void main(String[] args) {
		viewStudents();
	}
	
	private static void viewStudents() {
		List<Student> students = dao.readStudents();
		for (Student s : students) {
			System.out.println(s.getName());
		}
	}
}
