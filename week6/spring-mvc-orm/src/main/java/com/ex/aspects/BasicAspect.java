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
@Aspect
public class BasicAspect {

	@Before("execution(* com.ex.controller..*(..))")
	public void helloAOP() {
		
		System.out.println("hello");
	}
	
	@After("execution(* com.ex..*(..))")
	public void afterAdvice(JoinPoint jp) {
		System.out.println("method executing ater" + jp.getSignature());
	}
	@Around("everywhere()")
	public Object around(ProceedingJoinPoint pjp) {
		StopWatch time = new StopWatch();
		Object o= null;
		System.out.println("around");
		try {
			o = pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("around 2" + time.getTotalTimeSeconds());
		return o;
	}
	@Pointcut("execution(* com.ex..*(..))")
	public void everywhere() {
		
	}
}
