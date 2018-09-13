package com.ex.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect //MUST ANNOTATE EVERY ASPECT WITH THIS
public class BasicAspect {
	
	//ADVICE - to be applied BEFORE every method indicated in the pointcut
	//@Before("everywhere()")
	public void helloControllers() {
		System.out.println("HELLO WORLD OF SPRING AOP");
	}

	//AFTER - happens regardless of exception being thrown
	//@After("everywhere()")
	public void afterAdvice(JoinPoint jp) {
		System.out.println("METHOD EXECUTING AFTER " + jp.getSignature());
	}
	
	//AROUND ADVICE -- most powerful type of advice
		public Object doAround(ProceedingJoinPoint pjp) {
		Object o = null;
		System.out.println("IN AROUND ADVICE - BEFORE " + pjp.getSignature());
		try {
			 o = pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("IN AROUND ADVICE - AFTER " + pjp.getSignature());
		return o;
	}

	@Around("everywhere()")
	public Object timer(ProceedingJoinPoint pjp) throws Throwable{
		StopWatch time = new StopWatch();
		Object o = null;
		time.start();
		o = pjp.proceed();
		time.stop();
		
		String print = "EXECUTION of " + pjp.getSignature() + " took " 
		+ time.getTotalTimeSeconds()  + "s";
		System.out.println(print);
		
		return o;
	}
	
	
	
	@Pointcut("execution(* com.ex..* (..))")
	public void everywhere() {}
}
