package com.nttdata.training.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.nttdata.mvc.HttpRequestHandler;
import com.nttdata.training.dao.DAOAppException;
import com.nttdata.training.dao.LoginDAO;
import com.nttdata.training.domain.Student;

public class StudentLogin implements HttpRequestHandler {

	public static Logger log = Logger.getLogger(StudentLogin.class);

	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		int uid = Integer.parseInt(request.getParameter("userid"));
		String Password = request.getParameter("Password");
		
		
		int flag = -1;
		List students = null;
		LoginDAO dao = new LoginDAO();
		try {
			students = dao.validateStudent(uid);
			log.info(students);
			for (Object object : students) {

				Student student = (Student) object;
				if (student.getPassword().equals(Password)) {
					flag = 0;
					break;
				}
			}
			
			
			
			log.info("Flag in login " + flag);
			if (flag == 0) {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("student_home.jsp");
				request.setAttribute("Name", uid);
				dispatcher.forward(request, response);

			} else {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("StudentLogin.jsp");
				request.setAttribute("Err",
						"userid are password is incorrect");
				dispatcher.forward(request, response);
			}

		} catch (DAOAppException e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);

		}

	}

	
}

