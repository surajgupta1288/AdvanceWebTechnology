package com.nit.sis;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ViewServlet extends HttpServlet {
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
			out.println("<h3>Welcome to View Profile</h3>");
			
			try 
			{	
				//Load and register the driver with
				//DriverManager Service.
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
				if(con != null)
				{
					//Prepare the query and execute
					String query = "SELECT * FROM tblStudent WHERE UserName=?";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, cookies[0].getValue());
					ResultSet rs = pstmt.executeQuery();
					if(rs.next())
					{ 
						out.println("<table align='center'>");
						out.println("<tr>");
						out.println("<td>Student Id</td>");
						out.println("<td>"+ rs.getInt(1)+"</td>");
						out.println("</tr>");
						out.println("<tr>");
						out.println("<td>Student Name</td>");
						out.println("<td>"+ rs.getString(2)+"</td>");
						out.println("</tr>");
						out.println("<tr>");
						out.println("<td>User ID</td>");
						out.println("<td>"+ rs.getString(3)+"</td>");
						out.println("</tr>");
						out.println("</table>");
					}
				}
			}
			catch(Exception e){ }				
			
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
