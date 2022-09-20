package com.springndhibernate.springdemo;

public class SoccerCoach implements Coach {
	
//	define private field for the dependency
	private FortuneService fortuneService;
	
//	define constructor for the dependency injection
	public SoccerCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Joggle the ball 30 times a day";
	}

	@Override
	public String getDailyFortune() {
		// use fortuneService to get a fortune
		return fortuneService.getFortune();
	}
	
	public void startup() {
		System.out.println("Starting.....");
	}
	
	public void destroy() {
		System.out.println("Destroying...");
	}

}
