package com.prog32578;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;


//@WebServlet("/control")
public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final double hst = 0.13;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String url = "";
		RequestDispatcher dispatch = null;
		
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		double totals = 0.0;
		int inc = 1;
			
		while(inc<6) {
			
			if(request.getParameter("movie" + inc) != null && !request.getParameter("movie" + inc).isEmpty()) {
				if(makeOrder(request, inc) != null) {
					tickets.add(makeOrder(request, inc));
				}
			}
			
			inc++;
		}
		
		String summary = "";
		if(!tickets.isEmpty() && tickets != null) {
			url = "/summary.jsp";
			summary = "<h1>Here are the details of your Order.</h1><br><br>";
			
			for(int i=0; i<tickets.size(); i++) {
				summary += printer(tickets.get(i), request);
				totals = totals + tickets.get(i).getTotal();
				
			}
			summary += totalsString(totals).toString();
			//out.print(totalsString(totals));
			out.print("<body>" + summary);
			dispatch = request.getRequestDispatcher(url);
			dispatch.include(request, response);
		} else {
			url = "/index.jsp";
			out.print("<span style=\"color:red\"><h2><b>Please select a movie.</b></h2></span></body>");
			dispatch = request.getRequestDispatcher(url);
			dispatch.include(request, response);
		}
		
	}// end doPost
	
	private Ticket makeOrder(HttpServletRequest request, int incUpdate) {
		boolean valid = true;// evaluates to negative if any field is not filled
		//String url = "summary.jsp";
		String feature = "";
		String date = "";
		String time = "";
		String admit = "";
		int amount = 0;
		
		//ArrayList<String> movie1 = new ArrayList<String>();
		Ticket order = new Ticket();
		//RequestDispatcher dispatch = null;		
		
		if(request.getParameter("movie" + incUpdate) != null && request.getParameter("movie" + incUpdate) != "") {
			feature = request.getParameter("movie" + incUpdate); 	order.setFeatName(feature);
		} else valid = false;
		if(request.getParameter("date") != null && request.getParameter("date") != "") {
			date = request.getParameter("date");			order.setFeatDate(date);
		} else valid = false;
		if(request.getParameter("movie-time") != null && request.getParameter("movie-time") != "") {
			time = request.getParameter("movie-time");	order.setFeatTime(time);
		} else valid = false;
		if(request.getParameter("ticket-type") != null && request.getParameter("ticket-type") != "") {
			admit = request.getParameter("ticket-type");	order.setType(admit);
			//
			if(request.getSession() != null && !request.getSession().isNew()) {
				order.setMember(true);
				order.setPrice(admit, true);
			} 
			else order.setPrice(admit, false);// sets price based on ticket type in setPrice method
			//
		} else valid = false;
		if(request.getParameter("amount") != null && request.getParameter("amount") != "" && request.getParameter("amount") != "0") {
			amount = Integer.parseInt(request.getParameter("amount"));    order.setAmount(amount);
		}
		if(request.getSession() != null && !request.getSession().isNew()) {
			order.setMember(true);
		}
		// calculate total amount
		if(request.isRequestedSessionIdValid()) {
			order.setTotal(true);
		} 
		else order.setTotal(false);
		if(valid==false) {
			order = null;
		}
		return order;
	}
	
	private String printer(Ticket ticket, HttpServletRequest request) {
		String toPrint = "<div style=\"border:1px solid black\">" +
				"<br><span>Feature: " + ticket.getFeatName() + "</span><br>" +
				"<span>Date: " + ticket.getFeatDate() + " </span><br>" +
				"<span>Time: " + ticket.getFeatTime() + "</span><br>" +
				"<span>Ticket-type: " + ticket.getType() + "</span><br>" +
				"<span>Number of Tickets: " + ticket.getAmount() + "</span><br>";				
		
		if (ticket.isMember()) {
			toPrint += "<br><span style=\"color:red\">You've Recieved the members only 20% discount!</span>";
		}
		// price should update According to if statement
		toPrint += "<span>Price: $" + ticket.getPrice() + "</span></div><br><br>";
		
		return toPrint;
	}
	
	private String totalsString(double totals) {

		double tax = totals * 0.13;
		double totalAmount = totals + tax;
		String totalsString = "<br><span>Sub-total: $" + totals + "</span><br>" +
								"<span>HST: $" + String.valueOf(tax) + "</span><br>" +
								"<span>TOTAL: $" + totalAmount + "</span><br>";
		return toString();
	}	
}// end Controller


	
//	
//	url = "summary.jsp";
//}
//
//dispatch = request.getRequestDispatcher(url);
//dispatch.include(request, response);
