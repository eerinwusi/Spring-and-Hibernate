package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

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
	
	
//	add a new advice for @AfterReturning
	
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//		print out method we are advising on
		String method = proceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n======>>> Executing @AfterReturning on method: " + method);
		
//		get begin timestamp
		long begin = System.currentTimeMillis();
		
//		execute method
		Object result = proceedingJoinPoint.proceed();
		
//		get end timestamp
		long end = System.currentTimeMillis();
		
//		compute duration and display
		long duration = end - begin;
		System.out.println("\n======>>>> Duration: " + duration / 1000.0 + " seconds");
		
		return result;
	}
	
	
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		
//		print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n======>>> Executing @AfterReturning on method: " + method);
		
//		print out the results of the method call
		System.out.println("\n=======>>> result is " + result);
		
//		post-process the data
		
//		convert account name to uppercase
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n=======>>> result is " + result);
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
//		loop through accounts
		
		for (Account tempAccount : result) {
//			get uppercase version of name
			String upperName = tempAccount.getName().toUpperCase();
			
//			update name on account
			tempAccount.setName(upperName);
		}
	
}

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n====> Executing @Before advice on method");
		
//		display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: " + methodSig);
		
//		display method arguments
		
//		get args
		Object[] args = theJoinPoint.getArgs();
		
//		loop thru args
		for (Object tempArg : args) {
			System.out.println(tempArg);
			
			if (tempArg instanceof Account) {
//				downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				
				System.out.println("account name: " + theAccount.getName());
				System.out.println("account level " + theAccount.getLevel());
			}
		}
	}
	
	
	@AfterThrowing(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="exc")
	public void afterThrowingFindAccountsService(JoinPoint joinPoint, Throwable exc) {
//		print out method we're advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("======>>> Executing @AfterThrowing on method: " + method);
		
//		log the exception
		System.out.println("\n=====>>> The exception is " + exc);
	}
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
//		print out method we're advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("======>>> Executing @After (finally) on method: " + method);
	}
	
	
}
