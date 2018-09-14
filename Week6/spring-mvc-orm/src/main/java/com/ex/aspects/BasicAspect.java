package com.ex.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect //must annotate every aspect this this
public class BasicAspect {
	
	//advice - to  be applied before every method indicated in the pointcut(set of methods you want advice to apply to)
	//					.. for not caring about paramters. can have >= 0 params	
	@Before("execution(* com.ex.controllers.*.* (..)")
	public void helloAOP() {
		System.out.println("hello world of spring AOP");
	}
	
	@After("execution(* com.ex..* (..))")
	public void afterAdvice(JoinPoint jp) {
		System.out.println("method executing after " + jp.getSignature());
	}
	
	@Around("everywhere()")
	public void doAround(ProceedingJoinPoint pjp) {
		System.out.println("In around advice - before");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("In around advice - after");
	}
	
	@Pointcut("execution(* com.ex..* (..))")
	public void everywhere() {}
}
