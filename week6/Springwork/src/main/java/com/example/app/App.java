package com.example.app;

import com.example.beans.Author;
import com.example.service.AuthorService;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		AuthorService service = context.getBean(AuthorService.class);
		Author a = new Author ();
	}
}
