package com.ex.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class BasicAspect {

//	@Before("everywhere()")
//	public void helloAOP() {
//		System.out.println("Hello World of Spring AOP!");
//	}
//
//	@After("everywhere()")
//	public void afterAdvice(JoinPoint jp) {
//		System.out.println("Method Executing after " + jp.getSignature());
//	}

	@Around("everywhere()")
	public Object doAround(ProceedingJoinPoint pjp) {
		Object o = null;
		StopWatch timer = new StopWatch();
		
		timer.start();
		
		try {
			o = pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		timer.stop();
		
		System.out.println("Execution time of " + pjp.getSignature() +": " + timer.getTotalTimeSeconds() + " seconds.");
		
		return o;
	}

	@Pointcut("execution(* com.ex..* (..))")
	public void everywhere() {
	}

}
