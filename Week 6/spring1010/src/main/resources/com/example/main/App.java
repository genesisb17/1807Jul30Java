package com.example.main;

import com.ex.hellospring.DependentBean;
import com.ex.hellospring.HelloWorld;

public class App {
	public static void main(String[] args) {
		HelloWorld hello = new HelloWorld();
		System.out.println(hello.getMessage());
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("beans.xml");
		
		HelloWorld world = (HelloWorld) context.getBean("thisIsABean");
		System.out.println(world.getMessage());
		
		DependentBean d = (DependentBean) context.getBean("dependent");
		System.out.println(d.getHello().getMessage());
	}
}
