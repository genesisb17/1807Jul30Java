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
@Aspect
public class BasicAspect {
	// ADVICE to be applied BEFORE every method indicated in the pointcut
	@Before("execution(* com.ex.controllers..* (..))")
	public void helloControllers() {
		System.out.println("Hello world of spring AOP");
	}

	// AFTER happens regardless of exception being thrown
	@After("execution(* com.ex..* (..))")
	public void afterAdvice(JoinPoint jp) {
		System.out.println("Method executing after " + jp.getSignature());
	}
 
	// AROUND ADVICE most powerful tpye of advice
	@Around("everywhere()")
	public void doAround(ProceedingJoinPoint pjp) {
		try {
			pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Pointcut("execution(* com.ex..* (..))")
	public void everywhere() {

	}
}
