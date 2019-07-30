package com.nit.sis;

import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();		

		//Reading form values 
		String studentId = request.getParameter("studentId");
		String studentName = request.getParameter("studentName");		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String emailId = request.getParameter("emailId");
		String mobileNo = request.getParameter("mobileNo");
		String gender = request.getParameter("gender");
		String[] languages = request.getParameterValues("language");
		String qualification = request.getParameter("qualification");
		String comments = request.getParameter("comments");

		String languageKnown ="";
		for(String language : languages)
		{
			languageKnown = languageKnown+ language + " ";
		}


		try 
		{
			//Step-I
			//Load the Driver 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "suraj1288");
			if(con != null)
			{
				//out.println("Connected Successfully");

				//Prepare the query and execute.
				String query = "INSERT INTO tblStudent VALUES(?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(query);

				//Assigning the values to parameters
				pstmt.setInt(1,Integer.parseInt(studentId));
				pstmt.setString(2,studentName);
				pstmt.setString(3,userName);
				pstmt.setString(4,password);
				pstmt.setString(5,emailId);
				pstmt.setString(6,mobileNo);
				pstmt.setString(7,gender);
				pstmt.setString(8,languageKnown);
				pstmt.setString(9,qualification);
				pstmt.setString(10,comments);

				//For any DML query(Insert, Update, Delete)
				int rows = pstmt.executeUpdate();

				if(rows > 0)
				{
					out.println("<center>");
					out.println("Registration done successfully");
					RequestDispatcher rd = request.getRequestDispatcher("Login.html");
					rd.include(request, response);
					out.println("</center>");
				}
				else
					out.println("Registration failed");

				con.close();
			}
			else
				out.println("Failed to connect to Database");
		} 
		catch (ClassNotFoundException e){		
			out.println(e.toString());
		} catch (SQLException e) {			
			e.printStackTrace();
		}

	}

}