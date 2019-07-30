package com.nit.sis;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangePassword extends HttpServlet {
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
			out.println("<h3>Welcome to Change Password</h3>");
			out.println("</center>");
			out.println("<form action='' method=''>");
			out.println("<table align='center'>");
			out.println("<tr>");
			out.println("<td>Old Password</td>");
			out.println("<td> <input type='password' name='oldpassword'/> </td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>New Password</td>");
			out.println("<td> <input type='password' name='newpassword'/> </td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Confirm Password</td>");
			out.println("<td> <input type='password' name='conpassword'/> </td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td><input type='reset' value='Cancel'/></td>");
			out.println("<td><input type='submit' value='Change'/></td>");
			out.println("</tr>");		
			out.println("</table>");
			out.println("</form>");
		}
		else
		{
			out.println("<center>");
			out.println("<h4>Not yet logged in.</h4>");
			out.println("<h4>Click <a href='Login.html'> here </a> to login</h4>");
			out.println("</center>");
		}
		
		out.println("<center><a href='Home'>BACK</a></center>");
	}

}
