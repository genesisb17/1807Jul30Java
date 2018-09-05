package com.ex.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	
	public static void main(String[] args) {
		
		ApplicationContext context = new 
				ClassPathXmlApplicationContext("beans.xml");
		
		Employee me = (Employee) context.getBean("employee");

		me.getDepartment().setName("Associate");
		
	}
	
	
}
