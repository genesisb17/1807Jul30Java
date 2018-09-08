package com.iantimothyjohnson.notes.week6.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BasicAspect {
	// This is advice, to be applied before every method indicated in the point
	// cut. Note the syntax to specify the pointcut; here, we want to accept
	// any method in any class of the controllers package, with any return type
	// and parameter list.
	@Before("execution(* com.iantimothyjohnson.notes.week6.controllers.*.* (..))")
	public void helloControllers() {
		System.out.println("Hello world of Spring AOP!");
	}

	// Note the syntax for arbitrary nested paths ('..') and combining expressions
	// (&&).
	@After("execution(* com.iantimothyjohnson.notes.week6.controllers..* (..)) && "
			+ "execution(* com.iantimothyjohnson.notes.week6.service..* (..))")
	public void afterAdvice(JoinPoint jp) {
		System.out.println("Method executing after " + jp.getSignature());
		System.out.println("Object: " + jp.getThis());
	}

	// We can also define our own reusable pointcuts:
	@Pointcut("execution(* com.iantimothyjohnson.notes.week6..* (..))")
	public void everywhere() {
	}

	// Around advice is the most powerful type of advice:
	@Around("everywhere()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("In around advice - before " + pjp.getSignature());
		// We must explicitly tell our join point to proceed:
		Object ret = pjp.proceed();
		System.out.println("Random number: " + Math.random());
		System.out.println("In around advice - after " + pjp.getSignature());
		return ret;
	}

	@Around("everywhere()")
	public Object timer(ProceedingJoinPoint pjp) throws Throwable {
		Object ret = null;
		// Alternatively, use Spring's StopWatch.
		long start = System.currentTimeMillis();
		try {
			ret = pjp.proceed();
			return ret;
		} finally {
			long end = System.currentTimeMillis();
			System.out.println("Call to " + pjp.getSignature() + " took " + (end - start) + " ms");
		}
	}
}
