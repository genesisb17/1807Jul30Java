package com.ex.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.beans.Author;
import com.ex.service.AuthorService;

public class App 
{
	public static void main(String[] args) 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		AuthorService service = context.getBean("authorService", AuthorService.class);
		
		Author a = new Author("Stephen", "King", "This guy writes books");
		service.addAuthor(a);
	}
}
