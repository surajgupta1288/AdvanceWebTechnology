package com.cutm;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int res=(int) request.getAttribute("RES");
		 PrintWriter out=response.getWriter();
		 if(res==0)
			 out.println("Something Wrong : Try again");
		 else
			 out.println("Data Suceesfully inserted");
		 
		 //retrive from table
		 List<Profile> list=ProfileDao.fetchAll(); 
	        for(Profile pr:list){ 
	        	 out.print("Userid"+pr.getUserid()+"Name "+pr.getName()+"Email "+pr.getEmail()+"Mobile "+pr.getMobile());
	        }
			 
	        }  
 public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
      doGet(request, response);
 }
}
