package com.nttdata.training.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nttdata.mvc.HttpRequestHandler;

public class AdminLogin implements HttpRequestHandler {


	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		String Admin_id = request.getParameter("admin");
		String Password = request.getParameter("Password");
		
	

				int flag = -1;
				if (Admin_id.equals("admin1234") && Password.equals("1234")) {
					flag = 0;
				}
			if (flag == 0) {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("admin_home.jsp");
				request.setAttribute("Name", Admin_id);
				dispatcher.forward(request, response);

			} else {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("AdminLogin.jsp");
				request.setAttribute("Err",
						"Admin id are password is incorrect");
				dispatcher.forward(request, response);
			}

	}

	
}

