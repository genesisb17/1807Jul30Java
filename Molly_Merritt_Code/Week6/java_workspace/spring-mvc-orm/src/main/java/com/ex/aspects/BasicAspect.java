package com.ex.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component	// indicates that this should be managed by the spring container
@Aspect	// MUST ANNOTATE EVERY ASPECT WITH THIS
public class BasicAspect {
	
	// ADVICE - to be applied BEFORE every method indicated in the pointcut
	@Before("execution(* com.ex.controllers.*.* (..))")	// regardless of return type; every class and every method; any type of parameters
	public void helloControllers() {
		System.out.println("HELLO WORLD OF SPRING AOP");
	}
	
	// AFTER - happens regardless of exception being thrown
//	@After("execution(* com.ex.*.*.* (..))")
//	@After("execution(* com.ex..* (..))")	// same thing as above
	@After("execution(* com.ex.controllers..* (..)) && execution(* com.ex.service..* (..))")
	public void afterAdvice(JoinPoint jp) {
		System.out.println("METHOD EXECUTING AFTER " + jp.getSignature());
	}
	
	// AROUND ADVICE -- most powerful type of advice; exposes the proceeding joinpoint
	@Around("everywhere()")
	public Object doAround(ProceedingJoinPoint pjp) {
		System.out.println("IN AROUND ADVICE - BEFORE " + pjp.getSignature());
		Object o = null;
		try {	// need try/catch in case whatever method we're calling throws an exception
			o = pjp.proceed();	// executes the method you're applying the advice to (the joinpoint)
		} catch (Throwable e) {
			e.printStackTrace();
		}	// if you never call this method, the @Around will never execute
		System.out.println("IN AROUND ADVICE - AFTER " + pjp.getSignature());
		return o;
	}
	
	@Around("execution(* com.ex.controllers.AuthorController.* (..))")
	public Object aroundTimer(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.nanoTime();
//		System.out.println("Start time: " + startTime);
		Object o = null;
		try {
			o = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		long endTime = System.nanoTime();
//		System.out.println("End time: " + endTime);
		long duration = (endTime - startTime);
		System.out.println("Duration of method: " + duration + " nanoseconds");
		return o;
	}
	
	// Defining a pointcut
	@Pointcut("execution(* com.ex..* (..))")
	public void everywhere() {}	// this is a pointcut, not a method

}
