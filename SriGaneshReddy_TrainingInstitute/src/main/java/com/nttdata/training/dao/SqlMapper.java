package com.nttdata.training.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.nttdata.training.domain.Admin;
import com.nttdata.training.domain.Complaint;
import com.nttdata.training.domain.Faculty;
import com.nttdata.training.domain.Feedback;
import com.nttdata.dbfw.ResultMapper;
import com.nttdata.training.domain.Institute;
import com.nttdata.training.domain.Student;

public class SqlMapper {
 
	
	public static final String FETCH_INSTITUTE = "select Password,Affiliation_Date,Address,Number_Of_Seats,Number_Of_Course from institute_details where Institute_Name=?";
	public static final String ADD_INSTITUTE = "insert into institute_details values(?,?,?,?,?,?)";
	public static final String DELETE_INSTITUTE="delete from institute_details where Institute_Name=?";
	public static final String FETCH_ALL_INSTITUTES="select * from institute_details";
	
	
	public static final String FETCH_STUDENT = "select Name,Qualification,Password,Contact_Number,Address,Email_id from student_details where Userid=?";
	public static final String ADD_STUDENT = "insert into student_details values(?,?,?,?,?,?,?)"; 
	
	
	public static final String FETCHADMIN = "select * from admin";
	
	public static final String FETCHADMINID ="select Userid,Password from admin where Userid=? and Password=?";
	
	public static final String FETCHINSTITUTEAD ="select Institute_Name from institute_details where Institute_Name=?";
	
	
	public static final String FETCHINSTITUTEID = "select * from institute_details where Institute_Name=? and Password=?"; 
	
	public static final String FETCHSTUDENT = "select * from student_details";
	
	public static final String FETCHSTUDENTID = "select Userid,Password from student_details where Userid=? and Password=?";
	
	//INSERT INSTITUTE AND STUDENT
	public static final String INSERTINSTITUTE = "insert into institute_details values(?,?,?,?,?,?)";
	
	public static final String INSERTSTUDENT = "insert into student_details values(?,?,?,?,?,?,?)";
		
	//DELETE
	public static final String DELETEINSTITUTE = "delete from institute_details where Institute_Name=?";
	
	//UPDATE
	public static final String UPDATEINSTITUTE = "update institute_details set Affiliation_Date=?, Address=?, Number_Of_Seats=?, Number_Of_Course=?,Password=? where Institute_Name=?";
	
	public static final String UPDATESTUDENT = "update student_details set  Name=?, Qualification=?, Password=?, Contact_Number=?, Address=?, Userid=? where Email_id=?";
	
	//COMPLAINT
	public static final String INSERTCOMPLAINT = "insert into complaints values(?,?)";
	
	public static final String FETCHCOMPLAINT = "select * from complaints";
	
	//ARTICLE	
	public static final String INSERTARTICLE = "insert into upload_article values(?,?,?)";
	
	public static final String FETCHARTICLE = "select * from upload_article";
	
	//FACULTYDATA
	public static final String INSERTFACULTY = "insert into faculty_details values(?,?,?,?,?)";
	
	public static final String FETCHFACULTY = "select * from faculty_details";
	
	//FEEDBACK
	public static final String INSERTFEEDBACK = "insert into feedback values(?,?,?)";
	
	public static final String FETCHFEEDBACK = "select * from feedback";
	
	
	
	

	
//================================================================================
	public static final ResultMapper MAP_INSTITUTE = new ResultMapper() {
		
		
		public Object mapRows(ResultSet rs) throws SQLException {
			Institute institute = new Institute();
			institute.setPassword(rs.getString("Password"));
			institute.setAddress(rs.getString("Address"));
			return institute;
		}
	};
	
//====================================================================================
	
	public static final ResultMapper MAP_STUDENT = new ResultMapper() {
		
		
		public Object mapRows(ResultSet rs) throws SQLException {
			Student student = new Student();
			student.setPassword(rs.getString("Password"));
			student.setEmail_id(rs.getString("Email_id"));
			return student;
		}
	};
	
//================================================================================================
//	public static final ResultMapper MAP_ALL_INSTITUTES = new ResultMapper() {
//		
//		
//		public Object mapRows(ResultSet rs) throws SQLException {
//			
//			Institute institute = new Institute();
//			institute.setInstitute_Name(rs.getString("Institute_Name"));
//			institute.setAffiliation_Date(rs.getString("Affiliation_Date"));
//			institute.setAddress(rs.getString("Address"));
//			institute.setNumber_Of_Seats(rs.getInt("Number_Of_Seats"));
//			institute.setNumber_Of_Course(rs.getInt("Number_Of_Course"));
//			institute.setPassword(rs.getString("Password"));
//			return institute;
//		}
//		
//	};
//	
//================================================================================================================
	//=========================================================================================================================================================
	
		public static final ResultMapper ADMINMAPPER = new ResultMapper() {
			
			
			public Object mapRows(ResultSet rs) throws SQLException {
				String Role = rs.getString(1);
				String Userid  = rs.getString(2);
				String Password =rs.getString(3);
				
				Admin a = new Admin(Role,Userid,Password);
				
				return a;
			}
		};
	//==============================================================================================================================================================
		public static final ResultMapper INSTITUTEMAPPER = new ResultMapper() {
			
			
			public Object mapRows(ResultSet rs) throws SQLException {
				String Institute_Name = rs.getString(1);
				String Affiliation_Date =rs.getString(2);
				String Address = rs.getString(3);
				int Number_Of_Seats  = rs.getInt(4);
				int Number_Of_Course =rs.getInt(5);
				String Password  = rs.getString(6);
				
				Institute i = new Institute(Institute_Name, Affiliation_Date, Address, Number_Of_Seats, Number_Of_Course,Password);
				
					return i;
			}
		};
	//==============================================================================================================================================================
		
		public static final ResultMapper STUDENTMAPPER = new ResultMapper() {
			
			@Override
			public Object mapRows(ResultSet rs) throws SQLException {
				String Name = rs.getString(1);
				String Qualification = rs.getString(2);
				String Password = rs.getString(3);
				String Contact_Number = rs.getString(4);
				String Address = rs.getString(5);
				String Email_id = rs.getString(6);
				int Userid =rs.getInt(7);
				
				Student s = new Student(Name,Qualification,Password,Contact_Number,Address,Email_id,Userid);  
				
				
					return s;
			}
		};
	//=============================================================================================================================================================	
		
		public static final ResultMapper COMPLAINTMAPPER = new ResultMapper() {
			
		
			public Object mapRows(ResultSet rs) throws SQLException {
				String Institute_Name = rs.getString(1);
				String Complaint_Raise = rs.getString(2);
				
				Complaint c = new Complaint(Institute_Name, Complaint_Raise) ;  
				
				
					return c;
				
			}
		};
	//==============================================================================================================================================================
		public static final ResultMapper FACULTYMAPPER = new ResultMapper() {
			
			public Object mapRows(ResultSet rs) throws SQLException {
				String Name = rs.getString(1);
				String Qualification = rs.getString(2);
				String Experience = rs.getString(3);
				String Contact_Number = rs.getString(4);
				int Salary = rs.getInt(5);
				
				Faculty f = new Faculty(Name,Qualification,Experience,Contact_Number,Salary);  
				
				
					return f;
				
			}
		};
	//================================================================================================================================================================
		public static final ResultMapper FEEDBACKMAPPER = new ResultMapper() {
			
			
			public Object mapRows(ResultSet rs) throws SQLException {
				int Userid = rs.getInt(1);
				String Name = rs.getString(2);
				String Feedback = rs.getString(3);
				
				Feedback fb = new Feedback(Userid, Name, Feedback) ;
				
				
					return fb;
			
			}
		};
	//===================================================================================================================================================
	}
