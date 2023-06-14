package com.nttdata.training.domain;


public class Student {
	
	private String Name;
	private String Qualification;
	private String Password;
	private String Contact_Number;
	private String Address;
	private String Email_id;
	private int Userid;
	
	public Student(int userid) {
		super();
		Userid = userid;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String qualification, String password, String contact_Number, String address,
			String email_id, int userid) {
		this.Name = name;
		this.Qualification = qualification;
		this.Password = password;
		this.Contact_Number = contact_Number;
		this.Address = address;
		this.Email_id = email_id;
		this.Userid = userid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getQualification() {
		return Qualification;
	}
	public void setQualification(String qualification) {
		this.Qualification = qualification;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		this.Password = password;
	}
	public String getContact_Number() {
		return Contact_Number;
	}
	public void setContact_Number(String contact_Number) {
		this.Contact_Number = contact_Number;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		this.Address = address;
	}
	public String getEmail_id() {
		return Email_id;
	}
	public void setEmail_id(String email_id) {
		this.Email_id = email_id;
	}
	public int getUserid() {
		return Userid;
	}
	public void setUserid(int userid) {
		this.Userid = userid;
	}
	@Override
	public String toString() {
		return "Student [Name=" + Name + ", Qualification=" + Qualification + ", Password=" + Password
				+ ", Contact_Number=" + Contact_Number + ", Address=" + Address + ", Email_id=" + Email_id + ", Userid="
				+ Userid + "]";
	}
	
	

}
