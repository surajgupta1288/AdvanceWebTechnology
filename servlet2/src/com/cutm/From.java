package com.cutm;
//Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

//Extend HttpServlet class
public class From extends HttpServlet {
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