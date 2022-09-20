package com.springndhibernate.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeansScopeDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
//		check if they are the same
		boolean result = (theCoach == alphaCoach);
		
//		print results
		System.out.println("\n Pointing to the same object " + result);
		
		System.out.println("\n Memory location for theCoach " + theCoach);
		
		System.out.println("\n Memory location for alphaCoach " + alphaCoach);

	}

}
