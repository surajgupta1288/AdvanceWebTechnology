package com.cutm;

import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
public class DemoServlet2 extends HttpServlet{  
public void doGet(HttpServletRequest req,HttpServletResponse res)  
{  
try{  
  
res.setContentType("text/html");  
PrintWriter out=res.getWriter();  
  
ServletContext context=getServletContext();  
String n=(String)context.getAttribute("name");  
  
out.println("Welcome to "+n);  
out.close();  
  
}catch(Exception e)
{System.out.println(e);
}  
}}