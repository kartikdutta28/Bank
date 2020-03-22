package com.model;

public class User {
	private int user_id;
	private int account_id;
	private String first_name;
	private String last_name;
	private String address;
	private String user_name;
	private String phone_number;
	private String password;
	private String email;
		
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public User(int user_id, int account_id, String first_name, String last_name, String address, String user_name,
			String phone_number, String password, String email) {
		super();
		this.user_id = user_id;
		this.account_id = account_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.user_name = user_name;
		this.phone_number = phone_number;
		this.password = password;
		this.email = email;
	}

	public User() {
	
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", account_id=" + account_id + ", first_name=" + first_name + ", last_name="
				+ last_name + ", address=" + address + ", phone_number=" + phone_number + ", password=" + password
				+ ", email=" + email + "]";
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
