package com.ex.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Employee me = (Employee) ac.getBean("employee");
		me.getDepartment().setName("training Team");
		
		Department dept = (Department) ac.getBean("department");
		System.out.println(dept.getName());
		
	}
}
