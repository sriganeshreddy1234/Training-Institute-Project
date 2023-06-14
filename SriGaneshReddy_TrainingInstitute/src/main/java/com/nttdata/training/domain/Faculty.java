package com.nttdata.training.domain;

public class Faculty {
	
	private String Name;
	private String Qualification;
	private String Experience;
	private String Contact_Number;
	private int Salary;
	
	public Faculty(String name, String qualification, String experience, String contact_Number, int salary) {
		super();
		Name = name;
		Qualification = qualification;
		Experience = experience;
		Contact_Number = contact_Number;
		Salary = salary;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getQualification() {
		return Qualification;
	}
	public void setQualification(String qualification) {
		Qualification = qualification;
	}
	public String getExperience() {
		return Experience;
	}
	public void setExperience(String experience) {
		Experience = experience;
	}
	public String getContact_Number() {
		return Contact_Number;
	}
	public void setContact_Number(String contact_Number) {
		Contact_Number = contact_Number;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	@Override
	public String toString() {
		return "Faculty [Name=" + Name + ", Qualification=" + Qualification + ", Experience=" + Experience
				+ ", Contact_Number=" + Contact_Number + ", Salary=" + Salary + "]";
	}

}
