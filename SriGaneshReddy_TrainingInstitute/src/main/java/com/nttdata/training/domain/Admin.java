package com.nttdata.training.domain;

public class Admin {

	private String Role;
	private String Userid;
	private String Password;
	
	public Admin(String role, String userid, String password) {
		this.Role = role;
		this.Userid = userid;
		this.Password = password;
	}
	
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		this.Role = role;
	}
	public String getUserid() {
		return Userid;
	}
	public void setUserid(String userid) {
		this.Userid = userid;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		this.Password = password;
	}
	@Override
	public String toString() {
		return "Admin [Role=" + Role + ", Userid=" + Userid + ", Password=" + Password + "]";
	}


}
