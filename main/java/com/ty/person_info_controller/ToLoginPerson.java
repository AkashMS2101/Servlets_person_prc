package com.ty.person_info_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.person_info.dao.PersonSignInDAO;

public class ToLoginPerson extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		PersonSignInDAO dao = new PersonSignInDAO();
		String dbPassword = dao.loginPerson(email);
		
		if(dbPassword.equals(password)){
			PrintWriter printWriter = resp.getWriter();
			printWriter.print("Logged IN");
		}else {
			PrintWriter printWriter = resp.getWriter();
			printWriter.print("invalid password");
		}
	}

}
