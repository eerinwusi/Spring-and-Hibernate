package com.springndhibernate.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService; 
	
//	@Autowired
//	public TennisCoach(FortuneService theFortuneService) {
//		fortuneService = theFortuneService;
//	}

	public TennisCoach() {
		System.out.println("Empty constructor");
	}
	
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}
	
//	@Autowired
//	public void anyMethod(FortuneService fortuneService) {
//		System.out.println("You can use any method for autowiring");
//		this.fortuneService = fortuneService;
//	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
