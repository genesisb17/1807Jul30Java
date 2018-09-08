package com.ex.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new 
				ClassPathXmlApplicationContext("beans.xml");
		Employee e1 = (Employee) context.getBean("employee");
		e1.getDepartment().setName("Training Team");
		
		Employee e2 = (Employee) context.getBean("employee");
		e2.setName("Palmer");
		e2.getDepartment().setName("HR");
		
		Employee e3 = (Employee) context.getBean("employee");
		e3.setName("Rob");
		e3.getDepartment().setName("Sales");
		
		
		
//		Department dept = (Department) context.getBean("dept");
//		
//		System.out.println(dept.getName());
		
		getInfo(e1);
		getInfo(e2);
		getInfo(e3);
	
	}
	
	static void getInfo(Employee e) {
		System.out.println("Hi my name is " + e.getName()
		+ " and I'm in the " + e.getDepartment().getName() + " department");
	}

}
