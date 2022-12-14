package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
//		simulate a delay
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
//		return a fortune
		return "Expect heavy traffic this morning";
	}

	public String getFortune(boolean tripWire) {
		if (tripWire) {
			throw new RuntimeException("Ongoing Construction. Highway is blocked!!");
		}
		
		return "Expect heavy traffic this morning";
	}
}
