package com.nttdata.training.domain;


public class Institute {
		public Institute(String institute_Name) {
			super();
			Institute_Name = institute_Name;
		}
		public Institute() {
			// TODO Auto-generated constructor stub
		}

		private String Institute_Name;
		private String Affiliation_Date;
		private String Address;
		private int Number_Of_Seats;
		private int Number_Of_Course;
		private String Password;
		
		public Institute(String institute_Name, String affiliation_Date, String address,
				int number_Of_Seats, int number_Of_Course, String password) {
			this.Institute_Name = institute_Name;
			this.Affiliation_Date = affiliation_Date;
			this.Address = address;
			this.Number_Of_Seats = number_Of_Seats;
			this.Number_Of_Course = number_Of_Course;
			this.Password = password;
		}
		public String getInstitute_Name() {
			return Institute_Name;
		}
		public void setInstitute_Name(String institute_Name) {
			this.Institute_Name = institute_Name;
		}
		
		public String getAffiliation_Date() {
			return Affiliation_Date;
		}
		public void setAffiliation_Date(String affiliation_Date) {
			this.Affiliation_Date = affiliation_Date;
		}
		public String getAddress() {
			return Address;
		}
		public void setAddress(String address) {
			this.Address = address;
		}
		public int getNumber_Of_Seats() {
			return Number_Of_Seats;
		}
		public void setNumber_Of_Seats(int number_Of_Seats) {
			this.Number_Of_Seats = number_Of_Seats;
		}
		public int getNumber_Of_Course() {
			return Number_Of_Course;
		}
		public void setNumber_Of_Course(int number_Of_Course) {
			this.Number_Of_Course = number_Of_Course;
		}
		public String getPassword() {
			return Password;
		}
		public void setPassword(String password) {
			this.Password = password;
		}
		@Override
		public String toString() {
			
			return "Institute [Institute_Name=" + Institute_Name + ", Affiliation_Date="
					+ Affiliation_Date + ", Address=" + Address + ", Number_Of_Seats=" + Number_Of_Seats
					+ ", Number_Of_Course=" + Number_Of_Course + ", Password=" + Password + "]";
		}


	}
