package com.model;

import java.util.Date;

public class Transfer {
	private int transfer_id;
	private int from_account;
	private int target_account;
	private Double amount;
	private String comments;
	private Date tdate;
	public Transfer(int transfer_id, int from_account, int target_account, Double amount, String comments, Date tdate) {
		super();
		this.transfer_id = transfer_id;
		this.from_account = from_account;
		this.target_account = target_account;
		this.amount = amount;
		this.comments = comments;
		this.tdate = tdate;
	}
	public int getTransfer_id() {
		return transfer_id;
	}
	public void setTransfer_id(int transfer_id) {
		this.transfer_id = transfer_id;
	}
	public int getFrom_account() {
		return from_account;
	}
	public void setFrom_account(int from_account) {
		this.from_account = from_account;
	}
	public int getTarget_account() {
		return target_account;
	}
	public void setTarget_account(int target_account) {
		this.target_account = target_account;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getTdate() {
		return tdate;
	}
	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}
	public Transfer() {
	
	}
}
