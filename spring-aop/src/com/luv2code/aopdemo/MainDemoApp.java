package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
//		read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
//		get bean from the container
		AccountDAO account = context.getBean("accountDAO", AccountDAO.class);
		
//		call the business method
		account.addAccount();
		
//		close the context
		context.close();
	}

}
