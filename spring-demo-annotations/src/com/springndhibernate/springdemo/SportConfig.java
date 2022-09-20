package com.springndhibernate.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.springndhibernate.springdemo")
@PropertySource("classpath:sport.properties")
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
