package com.ex.hellospring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		
		/* 	WRONG! NOT USING SPRING
		HelloWorld hello = new HelloWorld();	// nothing to do w/ spring b/c we use the "new" keyword
		System.out.println(hello.getMessage());
		*/
		
		// Setter injection
		ApplicationContext context =
				new ClassPathXmlApplicationContext("beans.xml");
		// from here we can get an instance of every bean that's been registered as a bean
		// whenever we want a new instance, use spring and get it from application context
		HelloWorld world = (HelloWorld) context.getBean("thisIsABean");
		System.out.println(world.getMessage());
		world.setMessage("hi i changed my message");
		System.out.println(world.getMessage());
		
		DependentBean d = (DependentBean) context.getBean("dependent");
		System.out.println(d.getHello().getMessage());
		// by default, every bean is a singleton
	}

}
