package com.springndhibernate.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.springndhibernate.springdemo")
public class SportConfig {

//	define bean for greatFortuneService
	@Bean
	public FortuneService greatFortuneService() {
		return new GreatFortuneService();
	}
	
//	define bean for swim coach and inject dependency 
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(greatFortuneService());
	}
}
