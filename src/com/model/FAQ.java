package com.model;

public class FAQ {
	private int question_id;
	private String question;
	private String answer;
	private String user_name;
	public FAQ(int question_id, String question, String answer, String user_name) {
		super();
		this.question_id = question_id;
		this.question = question;
		this.answer = answer;
		this.user_name = user_name;
	}
	public FAQ() {
	
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	
}
