package com.nttdata.training.web.handlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.nttdata.mvc.HttpRequestHandler;
import com.nttdata.training.dao.DAOAppException;
import com.nttdata.training.dao.RegisterDAO;
import com.nttdata.training.domain.Student;

public class RegisterStudent implements HttpRequestHandler 
{
	
	static Logger log = Logger.getLogger(RegisterStudent.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		RegisterDAO dao = new RegisterDAO();
		Student student = new Student();
		
		student.setName(request.getParameter("name"));
		student.setQualification(request.getParameter("qual"));
		student.setContact_Number(request.getParameter("cont_num"));
		student.setAddress(request.getParameter("address"));
		student.setEmail_id(request.getParameter("email"));
		student.setUserid(Integer.parseInt(request.getParameter("userid")));
		
		boolean isExists;
		try {
			isExists = dao.validateStudent(student.getUserid()); // is this user already existed ? / not 

			if (isExists) {
				log.info("User already registered");
				RequestDispatcher dispatcher = request.getRequestDispatcher("..\\pages1\\StudentRegister.jsp");
				request.setAttribute("Err",	"User already registered with the system");
				dispatcher.forward(request, response);
			} else 
			{
				
				student.setPassword("NttData@"+ Integer.toString(student.getUserid()));
				int finalRes = dao.registerStudent(student);
				
				if (finalRes > 0) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("..\\pages1\\StudentLoginSuccess.jsp");
					request.setAttribute("success","User succesfully registered with the system");
					request.setAttribute("details", student);
					dispatcher.forward(request, response);
					
				}
			}
		} catch (DAOAppException e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);
		}
	}

}
