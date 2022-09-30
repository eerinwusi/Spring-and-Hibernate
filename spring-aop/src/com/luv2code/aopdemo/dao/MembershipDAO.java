package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public boolean addSillyMember() {
		System.out.println(getClass() + "MembershipDAO class here");
		
		return true;
	}
	
	public void Sleep() {
		System.out.println("I'm going to sleep now.....");
	}

}
