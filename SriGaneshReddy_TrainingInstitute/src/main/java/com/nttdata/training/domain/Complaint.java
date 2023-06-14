package com.nttdata.training.domain;

public class Complaint {
	
	private String Institute_Name;
	private String Complaint_Raise;
	
	public Complaint(String institute_Name) {
		super();
		Institute_Name = institute_Name;
	}
	
	
	public Complaint(String institute_Name, String complaint_Raise) {
		super();
		Institute_Name = institute_Name;
		Complaint_Raise = complaint_Raise;
	}
	
	public String getInstitute_Name() {
		return Institute_Name;
	}
	public void setInstitute_Name(String institute_Name) {
		Institute_Name = institute_Name;
	}
	public String getComplaint_Raise() {
		return Complaint_Raise;
	}
	public void setComplaint_Raise(String complaint_Raise) {
		Complaint_Raise = complaint_Raise;
	}
	@Override
	public String toString() {
		return "Complaint [Institute_Name=" + Institute_Name + ", Complaint_Raise=" + Complaint_Raise + "]";
	}


}
