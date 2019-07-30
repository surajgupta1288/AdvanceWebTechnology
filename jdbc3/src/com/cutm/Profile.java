package com.cutm;

public class Profile {

	private String userid;
	private String name;
	private String Email;
	private long mobile;
	
	public Profile() {
	
	}
	public Profile(String userid, String name, String email, long mobile) {
		
		this.userid = userid;
		this.name = name;
		Email = email;
		this.mobile = mobile;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
}
