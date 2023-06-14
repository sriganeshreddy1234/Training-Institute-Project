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
import com.nttdata.training.domain.Institute;

public class RegisterInstitute implements HttpRequestHandler 
{
	
	static Logger log = Logger.getLogger(RegisterInstitute.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//try {
		RegisterDAO dao = new RegisterDAO();
		Institute institute = new Institute();
		
		institute.setInstitute_Name(request.getParameter("Name"));
//		institute.setPassword(request.getParameter("Password"));
		institute.setAffiliation_Date(request.getParameter("Date"));
		institute.setAddress(request.getParameter("Address"));
		institute.setNumber_Of_Seats(Integer.parseInt(request.getParameter("No_Of_Seats")));
		institute.setNumber_Of_Course(Integer.parseInt(request.getParameter("No_Of_Course")));
		
		
		

		boolean isExists;
		try {
			isExists = dao.validateInstitute(institute.getInstitute_Name()); // is this user already existed ? / not 

			if (isExists) {
				log.info("User already registered");
				RequestDispatcher dispatcher = request.getRequestDispatcher("..\\pages1\\InstituteRegister.jsp");
				request.setAttribute("Err",	"User already registered with the system");
				dispatcher.forward(request, response);
			} else 
			{
				
				institute.setPassword("NttData@"+ institute.getInstitute_Name());
				int finalRes = dao.registerInstitute(institute);
				
				if (finalRes > 0) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("..\\pages1\\InstituteLoginSuccess.jsp");
					request.setAttribute("success","User succesfully registered with the system");
					request.setAttribute("details", institute);
					dispatcher.forward(request, response);
					
				}
			}
		} catch (DAOAppException e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);
		}
//		}catch(NumberFormatException nfe) {
//			System.out.println("Invalid Format");
//		}
	}

}
