package com.mvc.bean;

public class RegisterBean {
	
	private int user_id;
	private String fname;
	private String lname;
	private String uname;
	private String passwd;
	private String cpasswd;
	
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getCpasswd() {
		return cpasswd;
	}
	public void setCpasswd(String cpasswd) {
		this.cpasswd = cpasswd;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public String getCPasswd() {
		return cpasswd;
	}
	public void setCPasswd(String cpasswd) {
		this.cpasswd = cpasswd;
	}
	
}
