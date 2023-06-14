package com.nttdata.training.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.nttdata.training.domain.Faculty;
import com.nttdata.training.domain.Institute;
import com.nttdata.training.domain.Feedback;
import com.nttdata.mvc.HttpRequestHandler;
import com.nttdata.training.dao.InstituteDAO;
import com.nttdata.training.domain.Article;
import com.nttdata.training.domain.Student;

public class institute_home implements HttpRequestHandler {

	public static Logger log = Logger.getLogger(InstituteLogin.class);


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
				clist=InstituteDAO.getStudents();  
			
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
		case "uploadarticle":
		{
			int result=0;
			System.out.println("enter Institute_Name");
			String name=sc.next();
			System.out.println("Enter Article_Title");
			String title=sc.next();
			System.out.println("Enter Article_Text Here...");
			String text=sc.next();
			Article a =new Article(name, title, text);
			result=InstituteDAO.insertArticle(a); // press F3 on your keyboard ..!
			
			if(result!=0)
			{
				System.out.println("Article inserted successfully");
			}
			else
			{
				System.out.println("Failed to insert");
			}
			break;
		}
		
		case "insertfaculty":
		{
			//insert faculty
			int resultf=0;
			System.out.println("enter Faculty Name");
			String fname=sc.next();
			System.out.println("Enter Qualification");
			String fqual=sc.next();
			System.out.println("Enter Experience");
			String fexp=sc.next();
			System.out.println("Enter Contact Number");
			String fcn=sc.next();
			System.out.println("Enter Salary");
			int fsal=sc.nextInt();
			
			Faculty f =new Faculty(fname, fqual, fexp, fcn, fsal);
			resultf=InstituteDAO.insertFaculty(f); // press F3 on your keyboard ..!
			
			if(resultf!=0)
			{
				System.out.println("Faculty inserted successfully");
			}
			else
			{
				System.out.println("Failed to insert");
			}
			break;
		}
		case "viewfaculty":
		{
			//View Faculty Details
			try {
			clist=InstituteDAO.getFaculty(); //countries...  // F3  
			
			System.out.println("Details of Faculty are");
			System.out.println("-------------------------");
			for(Iterator it=clist.iterator();it.hasNext();)
			{
				Faculty fa =(Faculty) it.next();
				System.out.println(fa);
				}
		}catch (Exception e) {
			out.println(e);
			e.printStackTrace();
		}
			break;
		}
		case "updateinstitute":
		{
			//Update institute
			
			updateInstitute(request,response);
			
			System.out.println("enter Institute_Name");
			String iname=sc.next();
			System.out.println("enter Affiliation_Date");
			String date=sc.next();
			System.out.println("enter Address");
			String address=sc.next();
			System.out.println("Enter No_Of_Seats");
			int seats=sc.nextInt();
			System.out.println("Enter No_Of_Course");
			int course=sc.nextInt();
			System.out.println("Enter Password");
			String password=sc.next();
			
			Institute inst1 = new Institute(iname, date, address, seats, course, password);
			int institute=InstituteDAO.updateInstitute(inst1); // press F3 on your keyboard ..!
			if(institute!=0)
			{
				System.out.println("Institute Details Update successfully");
			}
			else
			{
				System.out.println("Failed to insert");
			}
			//response.sendRedirect("list");
			
			
			break;
		}
		case "viewfeedback":
		{
			//View Feedback By students
			try {
			clist=InstituteDAO.getFeedback(); //countries...  // F3  
			
			System.out.println("Details of Faculty are");
			System.out.println("-------------------------");
			for(Iterator it=clist.iterator();it.hasNext();)
			{
				Feedback f2 =(Feedback) it.next();
				System.out.println(f2);
				}
			}catch (Exception e) {
				out.println(e);
				e.printStackTrace();
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


	private void updateInstitute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	
}
				
