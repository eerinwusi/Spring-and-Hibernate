package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	
	private String serviceCode;

	public void addAccount(Account account, boolean vipFlag) {
//		getClass gives us the class name for display
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return false;
	}

	public String getName() {
		System.out.println(getClass() + "in get name");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + "in set name");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + "in get service code");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + "in set service code");
		this.serviceCode = serviceCode;
	}
	
}
