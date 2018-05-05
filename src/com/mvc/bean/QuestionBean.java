package com.mvc.bean;

public class QuestionBean {
	
	private int ques_id;
	private String ques_name;
	private String ch1,ch2,ch3,ch4;
	private String answer;
	private String hint,status,feedback;
	
	public QuestionBean(int ques_id, String ques_name, String ch1, String ch2, String ch3, String ch4, String answer,
			String hint,String status) {
		super();
		this.ques_id = ques_id;
		this.ques_name = ques_name;
		this.ch1 = ch1;
		this.ch2 = ch2;
		this.ch3 = ch3;
		this.ch4 = ch4;
		this.answer = answer;
		this.hint = hint;
		this.status=status;
	}
	
	
	
	public QuestionBean() {
		super();
	}



	public String getFeedback() {
		return feedback;
	}



	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}



	public int getQues_id() {
		return ques_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setQues_id(int ques_id) {
		this.ques_id = ques_id;
	}
	public String getQues_name() {
		return ques_name;
	}
	public void setQues_name(String ques_name) {
		this.ques_name = ques_name;
	}
	public String getCh1() {
		return ch1;
	}
	public void setCh1(String ch1) {
		this.ch1 = ch1;
	}
	public String getCh2() {
		return ch2;
	}
	public void setCh2(String ch2) {
		this.ch2 = ch2;
	}
	public String getCh3() {
		return ch3;
	}
	public void setCh3(String ch3) {
		this.ch3 = ch3;
	}
	public String getCh4() {
		return ch4;
	}
	public void setCh4(String ch4) {
		this.ch4 = ch4;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}
	
}
