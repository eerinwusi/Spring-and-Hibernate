package com.springndhibernate.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	private String email;
	private String team;

	public CricketCoach() {
		System.out.println("This is an empty constructor");
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setTeam(String team) {
		this.team = team;
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("This is the setter dependency injector");
		this.fortuneService = fortuneService;
	}
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Pratice fast bowling for 30 minutes";
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
