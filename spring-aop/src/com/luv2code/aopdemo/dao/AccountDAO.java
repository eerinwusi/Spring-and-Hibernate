package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	
	private String serviceCode;
	
//	add a new method: findAccounts()

	public List<Account> findAccounts() {
		List<Account> accounts = new ArrayList<>();
		
//		create sample accounts
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Madhu", "Platinum");
		Account temp3 = new Account("Luca", "Gold");
		
//		add them our account list
		accounts.add(temp1);
		accounts.add(temp2);
		accounts.add(temp3);
		
		return accounts;
	}
	
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
