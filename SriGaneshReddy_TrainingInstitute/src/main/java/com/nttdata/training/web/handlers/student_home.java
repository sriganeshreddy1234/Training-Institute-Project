package com.nttdata.training.web.handlers;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.nttdata.mvc.HttpRequestHandler;
import com.nttdata.training.dao.StudentDAO;
import com.nttdata.training.domain.Complaint;
import com.nttdata.training.domain.Feedback;
import com.nttdata.training.domain.Student;

public class student_home implements HttpRequestHandler {

	public static Logger log = Logger.getLogger(StudentLogin.class);


	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		List clist=null;
		int ch=0;
		int status=0;
		Scanner sc=new Scanner(System.in);
		
		PrintWriter out = response.getWriter();
		out.print("login sucess....");
		HttpSession app_session=request.getSession(false);
		//app_session.setAttribute("email", request.getAttribute("email"));
		String action=request.getParameter("action");
		
		switch(action) {
		case "viewstudents":
		{
			//View Students
			try {
				clist=StudentDAO.getStudents();  
			
			System.out.println("Details of Students are");
			System.out.println("-------------------------");
			for(Iterator it=clist.iterator();it.hasNext();)
			{
				Student s =(Student) it.next();
				System.out.println(s);
				}
			}catch (Exception e) {
				out.println(e);
				e.printStackTrace();
			}
			break;
		}
		case "updatestudent":
		{
			//Update Student Details //update student_details set Name=?, Password=?, Contact_Number=?, Address=?, Email_id=? where Userid=?
			updateStudent(request,response);
			
			System.out.println("Enter Email");
			String email=sc.next();
			System.out.println("Enter StudentName");
			String sname=sc.next();
			System.out.println("Enter Qualification");
			String qual=sc.next();
			System.out.println("Enter Password");
			String Password=sc.next();
			System.out.println("Enter Contact_Number");
			String cont=sc.next();
			System.out.println("Enter Address");
			String add=sc.next();
			System.out.println("Enter Userid");
			int userid=sc.nextInt();
			
			
			
			Student st1 = new Student(email,sname, qual, Password, cont, add,userid );
			int student=StudentDAO.updateStudent(st1);
			
			if(student!=0)
			{
				System.out.println("Student Details Update successfully");
			}
			else
			{
				System.out.println("Failed to insert");
			}
			
			
			break;
		}
		
		case "insertfeedback":
		{
			//insert Feedback
			int resultfb=0;
			System.out.println("enter Userid");
			int id=sc.nextInt();
			System.out.println("Enter Student Name");
			String stname=sc.next();
			System.out.println("Enter Your Feedback-----");
			String stfb=sc.next();
			
			Feedback fb3 =new Feedback(id, stname, stfb);
			resultfb=StudentDAO.insertFeedback(fb3); // press F3 on your keyboard ..!
			
			if(resultfb!=0)
			{
				System.out.println("Feedback inserted successfully");
			}
			else
			{
				System.out.println("Failed to insert");
			}
			
			break;
		}
		case "insertcomplaint":
		{
			//insert Complaint
			int resultc=0;
			
			System.out.println("Enter Complaint institute Name");
			String ciname=sc.next();
			System.out.println("Enter Your Complaint");
			String craise=sc.next();
			
			Complaint c3 =new Complaint(ciname, craise);
			resultc=StudentDAO.insertComplaint(c3); // press F3 on your keyboard ..!
			
			if(resultc!=0)
			{
				System.out.println("Complaint inserted successfully");
			}
			else
			{
				System.out.println("Failed to insert");
			}
			
			break;
		}
		
		case "logout":
		{
			
		
			response.sendRedirect("index.jsp");
			 HttpSession sessionobj=request.getSession(false);
			 sessionobj.invalidate();
			 out.print("you have logged out");
		}
		
		
		}
	}


	private void updateStudent(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
}
				
