package com.ex.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect //MUST ANNOTATE EVERY ASPECT WITH THIS
public class BasicAspect {
	
	//ADVICE - to be applied BEFORE every method indicated in the pointcut
	@Before("execution(* com.ex.controllers.*.* (..))")
	public void helloControllers() {
		System.out.println("HELLO WORLD OF SPRING AOP");
	}

}
