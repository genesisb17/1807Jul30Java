package com.ex.hellospring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		//wrong. not using spring. regular object
//		HelloWorld hello = new HelloWorld();
//		System.out.println(hello.getMessage());
		
		//to use spring bean
		ApplicationContext context = new 
				ClassPathXmlApplicationContext("beans.xml");
		
		HelloWorld world = (HelloWorld) context.getBean("thisIsABean");
		
		System.out.println(world.getMessage());
		
		//get instance of dependent bean class			//id in beans.xml
		DependentBean d = (DependentBean) context.getBean("dependent");
		System.out.println(d.getHello().getMessage());
	}

}
