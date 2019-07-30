package com.cutm;

//Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

// Extend HttpServlet class
public class Form extends HttpServlet {

	   // Method to handle GET method request.
	   public void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	      
	      // Set response content type
	      response.setContentType("text/html");

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
	   
	   public void doPost(HttpServletRequest request, HttpServletResponse response)
			      throws ServletException, IOException {

			      doGet(request, response);
			   }
}
