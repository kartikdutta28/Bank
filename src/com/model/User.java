package com.model;

public class User {
	private int user_id;
	private String first_name;
	private String last_name;
	private String address;
	private String user_name;
	private String phone_number;
	private String password;
	private String transaction_password;
	private String email;
	public User(int user_id, String first_name, String last_name, String address, String user_name, String phone_number,
			String password, String transaction_password, String email) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.user_name = user_name;
		this.phone_number = phone_number;
		this.password = password;
		this.transaction_password = transaction_password;
		this.email = email;
	}
	

	public User() {
	
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getPhone_number() {
		return phone_number;
	}


	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getTransaction_password() {
		return transaction_password;
	}


	public void setTransaction_password(String transaction_password) {
		this.transaction_password = transaction_password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
