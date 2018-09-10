package com.ex.hellospring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
//		HelloWord hw = new HelloWord();
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		HelloWord word = (HelloWord) ac.getBean("thisIsABean");
		System.out.println(word.getMessage());
		word.setMessage("I changed my message to be like this");
		System.out.println(word.getMessage());
		
		DependentBean db = (DependentBean) ac.getBean("dependent");
		System.out.println(db.getHello().getMessage());
	}
}
