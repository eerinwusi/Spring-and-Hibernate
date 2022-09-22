package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void addAccount() {
//		getClass gives us the class name for display
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
}
