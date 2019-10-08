package com.facebookweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookweb.entity.FacebookEmployee;
import com.facebookweb.service.FacebookServiceInterface;


public class GlobalServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a=request.getParameter("ac");
		
		if(a.equals("registeration")) {
			String name=request.getParameter("name");
			String pass=request.getParameter("pass");
			String email=request.getParameter("email");
			String address=request.getParameter("address");
			
			FacebookEmployee fe=new FacebookEmployee();
			fe.setAddress(address);
			fe.setEmail(email);
			fe.setName(name);
			fe.setPass(pass);
			
			FacebookServiceInterface fs=FacebookServiceInterface.createObject("admin");
			int i=fs.createProfile(fe);
			String ss="registration fail";
			if(i>0) {
				ss="registration success";
			}
			
			request.setAttribute("result", ss);
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/regresult.jsp");
			rd.forward(request, response);
			
		}
		if(a.equals("login")) {
			
		}
	}

}
