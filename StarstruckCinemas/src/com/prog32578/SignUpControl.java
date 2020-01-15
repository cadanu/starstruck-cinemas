package com.prog32578;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/signup")
public class SignUpControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static User user;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String url = "login.jsp";
		boolean valid = true;
		String fName = "";
		String lName = "";
		String email = "";
		String password = "";
		
		if(request.getParameter("first-name") != null || request.getParameter("first-name") != "") {
			fName = request.getParameter("first-name");
		} else valid = false;
		if(request.getParameter("last-name") != null || request.getParameter("last-name") != "") {
			lName = request.getParameter("last-name");
		} else valid = false;
		if(request.getParameter("email") != null || request.getParameter("email") != "") {
			email = request.getParameter("email");
		} else valid = false;
		if(request.getParameter("pss") != null || request.getParameter("pss") != "") {
			password = request.getParameter("pss");
		} else valid = false;
		
		
//		// auto increment id
//		String count = null;
//		try {
//			count = (CRUD.getCount("id", "users"));
//			if(count == null || count.isEmpty()) {
//				count = "0";
//			}
//		} catch(SQLException se) {
//			se.printStackTrace();
//		} catch(ClassNotFoundException cnfe) {
//			cnfe.printStackTrace();
//		}
//		int idAcc = Integer.parseInt(count) + 1;
		
		
		if (valid == true) {
			user = new User(fName, lName, email, password);
			request.setAttribute("user", user);
			url = "/welcome.jsp";
		} else {
			out.print("<b style=\"color:red\">Sign-Up unsuccessful, please try again.</b>");
			url = "signup.jsp";
		}
		
		try {
			CRUD.createUser(user);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}		
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
	
//	public static void main(String[] args) {
//		String id = user.getIdAcc();
//		String fName = user.getFirstName();
//		String lName = user.getLastName();
//		String email = user.getEmail();
//		String password = user.getPassword();
//		System.out.println(id + fName + lName + email + password);
//		
//	}
}
