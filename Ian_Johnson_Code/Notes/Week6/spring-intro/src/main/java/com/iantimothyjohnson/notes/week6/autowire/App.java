package com.iantimothyjohnson.notes.week6.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		Employee emp = context.getBean("employee", Employee.class);
		emp.getDepartment().setName("Training Team");
		System.out.println(emp.getDepartment().getName());
		
		Employee emp2 = context.getBean("employee", Employee.class);
		System.out.println(emp2.getDepartment().getName());

		Department dept = context.getBean("department", Department.class);
		System.out.println(dept.getName());
	}
}
