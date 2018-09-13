package com.ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
The @SpringBootApplication annotation enables auto-configuration of your application. This single annotation can enable 
features that would otherwise need to be configured either via XML or the following annotations:
- @EnableAutoConfiguration: enable Spring Boot's autoconfiguration mechanism 
- @ComponentScan: enable @Components to be found via a scan of the package where the annotation is located (base-package)
- @Configuration: allow Spring to register extra beans in the context or import additional configuration classes
--> the SBA is equivalent to using the aforementioned annotatinos with their default attributes 	
*/

@SpringBootApplication
public class App {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}


}
