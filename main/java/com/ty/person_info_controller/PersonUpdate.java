package com.ty.person_info_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.ty.person_info.dao.PersonSignInDAO;
import com.ty.person_info.dto.PersonSignIn;

public class PersonUpdate extends GenericServlet{

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		String fName = arg0.getParameter("firstname");
		
		String email = arg0.getParameter("email");

		PersonSignInDAO dao = new PersonSignInDAO();
		dao.updatePerson(email, fName);

		RequestDispatcher dispatcher = arg0.getRequestDispatcher("PersonUpdateSuccessfull.html");
		dispatcher.forward(arg0,arg1);
	}

}
