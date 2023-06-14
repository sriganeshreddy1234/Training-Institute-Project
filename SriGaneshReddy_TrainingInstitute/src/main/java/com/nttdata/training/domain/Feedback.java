package com.nttdata.training.domain;

public class Feedback {
	private int Userid;
	private String Name;
	private String Feedback;
	
	public Feedback(int userid, String name, String feedback) {
		super();
		Userid = userid;
		Name = name;
		Feedback = feedback;
	}
	public int getUserid() {
		return Userid;
	}
	public void setUserid(int userid) {
		Userid = userid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getFeedback() {
		return Feedback;
	}
	public void setFeedback(String feedback) {
		Feedback = feedback;
	}
	@Override
	public String toString() {
		return "Feedback [Userid=" + Userid + ", Name=" + Name + ", Feedback=" + Feedback + "]";
	}
	

}
