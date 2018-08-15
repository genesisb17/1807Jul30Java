package com.revature.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IODAO {
	
	
	void addStudent(Student student) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/files/student.txt",true));) {
			bw.write(student.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	List <Student> readStudents() {
		List <Student> students = new ArrayList<Student>();
		try(BufferedReader br = new BufferedReader(new FileReader("src/files/student.txt"))){
			String line = null;
			while((line = br.readLine())!=null) {
				if (line!=null) {
					String[] studentInfo = line.split(";");
					Student temp = new Student();
					temp.setName(studentInfo[0]);
					temp.setEmail(studentInfo[1]);
					temp.setGrade(Double.parseDouble(studentInfo[2]));
					students.add(temp);
					
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return students;
	}
	
}
