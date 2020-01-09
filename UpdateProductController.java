package com.deloitte.estore.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.estore.model.Product;
import com.deloitte.estore.service.ProductService;
import com.deloitte.estore.service.ProductServiceImpl;

@WebServlet("/update")
public class UpdateProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int productId=Integer.parseInt(req.getParameter("pid"));
	
		
		ProductService service=new ProductServiceImpl();
		Product p;
		
			 try {
				p=service.getProductById(productId);
				req.getSession().setAttribute("product", p);
				res.sendRedirect("updateprod.jsp");
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	
		
		
	}

}
