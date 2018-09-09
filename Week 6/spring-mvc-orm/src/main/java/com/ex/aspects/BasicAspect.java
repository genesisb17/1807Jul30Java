package com.ex.aspects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import oracle.net.aso.s;

@Component
@Aspect
//the stars means we don't care about which methods, accepts all
//the .. means we don't care about the parameters, accepts all
public class BasicAspect {
/*	@Before("execution(* com.ex.controller.*.*(..))")
	public void helloControllers() {
		System.out.println("Hello World of Spring");
	}
	
	//AFTER - happens regardless of exception being thrown
	@After("execution(* com.ex..* (..)) && "
			+ "execution(* com.ex.service..* (..))")
	public void afterAdvice(JoinPoint jp) {
		System.out.println("METHOD EXECUTING AFTER " + jp.getSignature());
	}
	
	*/
	public PerformanceMonitorInterceptor performanceMonitorInterceptor() {
		int counter = 0;
		counter++;
        return new PerformanceMonitorInterceptor(true);
    }
	//AROUND ADVICE -- most powerful type of advice
	@Around("everywhere()")
	public Object doAround(ProceedingJoinPoint pjp) {
		
		Object o = null;
		try {
			StopWatch stopWatch = new StopWatch();
		    stopWatch.start();
		    o = pjp.proceed();
		    stopWatch.stop();
		    String print = "EXECUTION of " + pjp.getSignature() + " took "
		    		+ stopWatch.getTotalTimeSeconds() + "s";
		    System.out.println(print);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return o;
	}
	
	@Pointcut("execution(* com.ex..* (..))")
	public void everywhere() {}

	}
