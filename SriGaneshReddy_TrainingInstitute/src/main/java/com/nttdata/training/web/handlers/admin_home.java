package com.nttdata.training.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.nttdata.mvc.HttpRequestHandler;
import com.nttdata.training.dao.AdminDAO;
import com.nttdata.training.domain.Complaint;
import com.nttdata.training.domain.Institute;
import com.nttdata.training.domain.Student;

public class admin_home implements HttpRequestHandler {

	public static Logger log = Logger.getLogger(AdminLogin.class);


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
		case "viewinstitutes":
		{
			try {
				clist=AdminDAO.getInstitutes(); //countries...  // F3  
				
				System.out.println("Details of Institute are");
				System.out.println("-------------------------");
				for(Iterator it=clist.iterator();it.hasNext();)
				{
					Institute i1 =(Institute) it.next();
					System.out.println(i1);
					
//					if(institutes.size()>0)
//					{
//					String url = "admin_institutedetails.jsp";
//					
//					request.setAttribute("InstituteDetails", institutes);
//					RequestDispatcher rd = request.getRequestDispatcher(url);
//					rd.forward(request, response);
//					}else
//					{
//						out.print("no data to print.. ");
//					}
//					
					
				}
				
			}catch (Exception e) {
				out.println(e);
				e.printStackTrace();
			}
			break;
		}
		case "deleteinstitute":
		{
			//Delete institute
			int result=0;
			System.out.println("enter delete institute name");
			String Institute_Name=sc.next();
			Institute d =new Institute(Institute_Name);
			result=AdminDAO.deleteInstitute(d); // press F3 on your keyboard ..!
			
			if(result!=0)
			{
				System.out.println("Institute deleted successfully");
			}
			else
			{
				System.out.println("Failed to delete");
			}
			break;
		}
		case "viewstudents":
		{
			//View Students
			try {
				clist=AdminDAO.getStudents();  
			
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
		case "viewcomplaints":
		{
			//view complaints
			try {
			clist=AdminDAO.getComplaints(); //countries...  // F3  
			
			System.out.println("View Complaints");
			System.out.println("-------------------------");
			for(Iterator it=clist.iterator();it.hasNext();)
			{
				Complaint c =(Complaint) it.next();
				System.out.println(c);
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
}
				
