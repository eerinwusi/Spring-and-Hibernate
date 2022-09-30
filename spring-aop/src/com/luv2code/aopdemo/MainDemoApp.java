package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
//		read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
//		get bean from the container
		AccountDAO account = context.getBean("accountDAO", AccountDAO.class);
		
//		get bean from the container
		MembershipDAO member = context.getBean("membershipDAO", MembershipDAO.class);
		
//		call the business method
		Account theAccount = new Account();
		account.addAccount(theAccount, true);
		account.doWork();
		
//		call the accountDAO setter/getter methods
		account.setName("foobar");
		account.setServiceCode("silver");
		
		String name = account.getName();
		String code = account.getServiceCode();
		
//		call the business method
		member.addSillyMember();
		member.Sleep();
		
//		close the context
		context.close();
	}

}
