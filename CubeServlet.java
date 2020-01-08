package com.deloitte;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/cube")
public class CubeServlet extends HttpServlet{
	@Override
	 public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
     {
    
    	 int num1=Integer.parseInt(req.getParameter("t1"));
    	 int num2=Integer.parseInt(req.getParameter("t2"));
    	 int sum= num1+num2;
    	 //int cube=sum*sum*sum;
    	 res.getWriter().println("Sum=  "+sum);
    	// res.getWriter().println("Cube=  "+cube);
    	
    	 RequestDispatcher rd= req.getRequestDispatcher("Cubes");//cube is the path
    	 req.setAttribute("sum",sum);
    	 rd.forward(req,res);
    	 
    	
    	
    	 
     }
		 
}