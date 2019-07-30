package com.cutm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Extend HttpServlet class
public class Form extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
	      out.println("<head>");
	      out.println("</head>");
	      out.println("<body bgcolor = cyan>");
	      out.println("<b>First Name</b>:");
	      out.println(request.getParameter("first_name"));
	      out.println("<br>");
	      out.println("<b>Last Name</b>:");
	      out.println(request.getParameter("last_name"));
	      out.println("</body>");
	      out.println("</html>");
		
		
	}
	
}