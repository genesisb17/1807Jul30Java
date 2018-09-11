package com.ex.hellospring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		//WRONG! NOT USING SPRING
		//HelloWorld hello = new HelloWorld();
		//System.out.println(hello.getMessage());
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		HelloWorld world = (HelloWorld) context.getBean("Bean1");
		System.out.println(world.getMessage());
		world.setMessage("Message successfully changed!");
		System.out.println(world.getMessage());
		
		DependentBean dbean = (DependentBean) context.getBean("Bean2");
		System.out.println(dbean.getHello().getMessage());
		
		//Every Bean is singleton scoped
	}

}
