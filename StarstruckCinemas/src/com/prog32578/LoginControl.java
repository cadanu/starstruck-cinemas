package com.prog32578;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet("/login")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("welcome.jsp");
		response.setContentType("text/html");
		String url = "";
		RequestDispatcher dispatch = null;
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String password = request.getParameter("pss");
		
		HttpSession session = request.getSession(false);
		if(session != null)	
			session.setAttribute("email", email);
		
		try {
			if(CRUD.getLogin(email, password)) {
				out.print("<b style=\"color:red\">Login Successful</b>");
				url = "/index.jsp";
				dispatch = request.getRequestDispatcher(url);
				dispatch.include(request, response);
			}
			else {
				url = "/login.jsp";
				out.print("<b style=\"color:red\">Your login was unsuccessful. Please try again.</b>");
				dispatch = request.getRequestDispatcher(url);
				dispatch.include(request, response);
			}
		} catch(SQLException se) {
			se.printStackTrace();
		} catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}

}
