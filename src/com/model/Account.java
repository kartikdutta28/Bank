package com.model;

import java.util.Date;

public class Account {
	private int account_id;
	private int user_id;
	private String account_type;
	private double amount;
	private Date creation_date;
	private int counter;
	public Account(int account_id, int user_id, String account_type, double amount, Date creation_date, int counter) {
		super();
		this.account_id = account_id;
		this.user_id = user_id;
		this.account_type = account_type;
		this.amount = amount;
		this.creation_date = creation_date;
		this.counter = counter;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public Account() {
		// TODO Auto-generated constructor stub
	}
}
