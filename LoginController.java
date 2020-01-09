package com.deloitte;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setHeader("Cache Control", "no-cache no-store must revalidate");
    	String uName="Chetna";
		String password="1122";
		
		String inUName=req.getParameter("txtuname");
		String inPassword=req.getParameter("txtpassword");
		if(uName.equals(inUName)&& password.equals(inPassword)) {
			HttpSession ssn=req.getSession();
			ssn.setAttribute("user",inUName);
			res.sendRedirect("welcome.jsp");
		}
		
    }

}
