package com.model;

import java.util.Date;

public class CheckBook {
	private int request_id;
	private int account_id;
	private Date req_date;
	private Date delivery_date;
	private String address;
	private String request_status;
	public CheckBook(int request_id, int account_id, Date req_date, Date delivery_date, String address,
			String request_status) {
		super();
		this.request_id = request_id;
		this.account_id = account_id;
		this.req_date = req_date;
		this.delivery_date = delivery_date;
		this.address = address;
		this.request_status = request_status;
	}
	public int getRequest_id() {
		return request_id;
	}
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public Date getReq_date() {
		return req_date;
	}
	public void setReq_date(Date req_date) {
		this.req_date = req_date;
	}
	public Date getDelivery_date() {
		return delivery_date;
	}
	public void setDelivery_date(Date delivery_date) {
		this.delivery_date = delivery_date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRequest_status() {
		return request_status;
	}
	public void setRequest_status(String request_status) {
		this.request_status = request_status;
	}
	
	
	
}
