package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundHandlerExceptionDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundHandlerExceptionDemoApp.class.getName());
	
	public static void main(String[] args) {
//		read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
//		get bean from the container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("\nMain Program: AroundDemoApp");
		
		myLogger.info("Calling getFortune");
		
		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);
		
		myLogger.info("\nMy fortune is: " + data);
		
		myLogger.info("Finished");
		
//		close the context
		context.close();
	}

}
