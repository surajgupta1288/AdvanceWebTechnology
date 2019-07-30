package com.cutm;

import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
public class DemoServlet1 extends HttpServlet{  
public void doGet(HttpServletRequest req,HttpServletResponse res)  
{  
try{  
  
res.setContentType("text/html");  
PrintWriter out=res.getWriter();  
  
ServletContext context=getServletContext();  
context.setAttribute("name","suraj Gupta");  
  
out.println("Welcome to my Profile");  
out.println("<a href='servlet2'>visit</a>");  
out.close();  
  
}catch(Exception e)
{System.out.println(e);
}  
  
}}  