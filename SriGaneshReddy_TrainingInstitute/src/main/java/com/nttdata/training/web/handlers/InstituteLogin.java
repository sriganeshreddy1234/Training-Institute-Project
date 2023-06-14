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
import com.nttdata.training.domain.Institute;

public class InstituteLogin implements HttpRequestHandler {

	public static Logger log = Logger.getLogger(InstituteLogin.class);

	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		String Inst_Name = request.getParameter("Name");
		String Password = request.getParameter("Password");
		
		
		int flag = -1;
		List institutes = null;
		LoginDAO dao = new LoginDAO();
		try {
			institutes = dao.validateInstitute(Inst_Name);
			log.info(institutes);
			for (Object object : institutes) {

				Institute institute = (Institute) object;
				if (institute.getPassword().equals(Password)) {
					flag = 0;
					break;
				}
			}
			
			
			
			log.info("Flag in login " + flag);
			if (flag == 0) {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("institute_home.jsp");
				request.setAttribute("Name", Inst_Name);
				dispatcher.forward(request, response);

			} else {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("InstituteLogin.jsp");
				request.setAttribute("Err",
						"Institute Name are password is incorrect");
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

