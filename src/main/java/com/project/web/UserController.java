package com.project.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/login"})
public class UserController extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		if(username.equals("root")&&password.equals("Prakash@1")) {
			HttpSession httpSession= req.getSession(); // Map collection...
			httpSession.setAttribute("currentUser", "ADMIN");
			res.sendRedirect("recent-transaction");
		}else {
			res.sendRedirect("login.html");
		}
		
	
	}
	
}