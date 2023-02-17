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

public class PersonController extends GenericServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		String fName = arg0.getParameter("firstname");
		String lName = arg0.getParameter("lastname");
		String Email = arg0.getParameter("email");
		String password = arg0.getParameter("password");
		long phone_num = Long.parseLong(arg0.getParameter("phonenum"));

		PersonSignIn personSignIn = new PersonSignIn();
		personSignIn.setFirst_name(fName);
		personSignIn.setSecond_name(lName);
		personSignIn.setEmail(Email);
		personSignIn.setPassword(password);
		personSignIn.setPhone(phone_num);

		PersonSignInDAO dao = new PersonSignInDAO();
		dao.savePerson(personSignIn);

		RequestDispatcher dispatcher = arg0.getRequestDispatcher("PersonSignedIn.html");
		dispatcher.forward(arg0, arg1);
	}
	
}
