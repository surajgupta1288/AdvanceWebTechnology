package com.nit.sis;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();		
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		try 
		{	
			//Load and register the driver with
			//DriverManager Service.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con024 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "system", "manager");
			if(con024 != null)
			{
				//Prepare the query.
				String query = "SELECT * FROM tblStudent WHERE UserName=? AND Password=?";
				PreparedStatement pstmt = con024.prepareStatement(query);
				pstmt.setString(1, userName);
				pstmt.setString(2, password);
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next())
					response.sendRedirect("Home");
					//out.println("<h2 align='center'>Login Successful.</h2");
				else
				{
					out.println("<h2 align='center'>Login Failed</h2>");
					RequestDispatcher rd = 
							request.getRequestDispatcher("Login.html");
					rd.include(request, response);
				}
				con024.close();
			}
			else
			{
				out.println("Not able to connect to database");
			}
			
		} 
		catch (ClassNotFoundException e) 
		{
			out.println(e);
		} 
		catch (SQLException e) 
		{
			out.println(e);
		}
		
	}

}
