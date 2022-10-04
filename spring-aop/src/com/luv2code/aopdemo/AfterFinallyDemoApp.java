package com.luv2code.aopdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
//		read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
//		get bean from the container
		AccountDAO account = context.getBean("accountDAO", AccountDAO.class);
		
//		call method to find the accounts
		List<Account> accounts = null;
		
		try {
//			add a boolean
			boolean tripWire = false;
			accounts = account.findAccounts(tripWire);
			
		} catch (Exception e) {
			System.out.println("Main program caught exception: " + e);
		}
		
//		display accounts
		System.out.println("Main Program: AfterReturningDemoApp");
		System.out.println("---");
		
		System.out.println(accounts);
		
		System.out.println("\n");
		
//		close the context
		context.close();
	}

}
