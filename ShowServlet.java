package com.deloitte;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ShowServlet extends HttpServlet {
     @Override
	 public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
     {
    	 //String name=req.getParameter("t1");
    	// res.getWriter().println("Hello  "+name);
    	 int num1=Integer.parseInt(req.getParameter("t1"));
    	 int num2=Integer.parseInt(req.getParameter("t2"));
    	 res.getWriter().println("Sum=  "+(num1+num2));
     }
		 
	 }

