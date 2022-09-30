package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
//	this is where we add all of our related advices for logging
	
//	let's start with an @Before advice
	
//	@Before("forDaoPackage()")
//	public void beforeAddAccountAdvice1() {
//		System.out.println("\n=======>>> Executing @Before advice on addAccount()");
//	}
//	
//	@Before("forDaoPackage()")
//	public void performApiAnalytics1() {
//		System.out.println("\n=====> Performing API analytics");
//	}

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n====> Executing @Before advice on method");
	}
	
	
}
