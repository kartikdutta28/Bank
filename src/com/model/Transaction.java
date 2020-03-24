package com.model;

public class Transaction {
	private int transaction_id;
	private int user_id;
	private int account_id;
	private double amount;
	private double post_balance;
	private String transaction_type;
	private String comments;
	
	public Transaction() {
	
	}
	public Transaction(int transaction_id, int user_id, int account_id, double amount, double post_balance,
			String transaction_type, String comments) {
		super();
		this.transaction_id = transaction_id;
		this.user_id = user_id;
		this.account_id = account_id;
		this.amount = amount;
		this.post_balance = post_balance;
		this.transaction_type = transaction_type;
		this.comments = comments;
	}
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getPost_balance() {
		return post_balance;
	}
	public void setPost_balance(double post_balance) {
		this.post_balance = post_balance;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
}
