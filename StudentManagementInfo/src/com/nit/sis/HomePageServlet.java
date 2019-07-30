package com.nit.sis;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null)
		//HttpSession session = request.getSession(false);
		//if(session != null)		
		{
			out.println("<center>");
			out.println("<h2>Student Information System</h2>");
			out.println("<h3>Welcome Mr." + cookies[0].getValue() +"</h3>");
			out.println("<h4><a href='View'>View Profile</a></h4>");
			out.println("<h4><a href='Edit'>Edit Profile</a></h4>");
			out.println("<h4><a href='Change'>Change Password</a></h4>");
			out.println("<h4><a href='Logout'>Logout</a></h4>");
			out.println("<center>");
		}
		else
		{
			out.println("<center>");
			out.println("<h4>Not yet logged in.</h4>");
			out.println("<h4>Click <a href='Login.html'> here </a> to login</h4>");
			out.println("</center>");
		}
		
	}

}
