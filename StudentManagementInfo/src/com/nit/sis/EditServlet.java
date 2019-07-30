package com.nit.sis;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//HttpSession session = request.getSession(false);
		//if(session != null)
		Cookie[] cookies = request.getCookies();
		if(cookies != null)
		{
			out.println("<center>");
			out.println("<h2>Student Information System</h2>");
			out.println("<h3>Welcome to Edit Profile</h3>");
			out.println("<a href='Home'>BACK</a>");
			out.println("</center>");
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
