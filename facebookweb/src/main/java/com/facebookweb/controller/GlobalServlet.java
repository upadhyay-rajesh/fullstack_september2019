package com.facebookweb.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facebookweb.entity.FacebookEmployee;
import com.facebookweb.service.FacebookServiceInterface;

//@WebServlet("/GlobalServlet")
public class GlobalServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a=request.getParameter("ac");
		
		if(a.equals("registeration")) {
			String name=request.getParameter("name");
			String pass=request.getParameter("pass");
			String email=request.getParameter("email");
			String address=request.getParameter("address");
			
			FacebookEmployee fe=new FacebookEmployee();
			fe.setF_id((long)(Math.random()*10000));
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
			String name=request.getParameter("name");
			String pass=request.getParameter("pass");
			FacebookEmployee fe=new FacebookEmployee();
			fe.setName(name);
			fe.setPass(pass);
			
			FacebookServiceInterface fs=FacebookServiceInterface.createObject("admin");
			boolean b=fs.loginProfile(fe);
			
			if(b) {
				//request.setAttribute("nn", name);
				
				//ServletContext sc=getServletContext();
				HttpSession sc=request.getSession(true);
				
				//System.out.println(new Date(sc.getLastAccessedTime()));
				
				sc.setMaxInactiveInterval(1);
				
			//	sc.invalidate();
				
				sc.setAttribute("nn", name);
				
				
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/loginsuccess.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/loginfail.jsp");
				rd.forward(request, response);
			}
			
		}
		
		if(a.equals("friendlist")) {
			HttpSession sc=request.getSession(true);
			sc.getAttribute("nn");
		}
		if(a.equals("logout")) {
			HttpSession sc=request.getSession(true);
			sc.getAttribute("nn");
			System.out.println("lllll "+new Date(sc.getLastAccessedTime()));
			sc.invalidate();
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.html");
			rd.forward(request, response);
		}
	}

}













