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

@WebServlet("/updatedata")
public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int productId=Integer.parseInt(req.getParameter("txtpid"));
		String productName=req.getParameter("txtpname");
		float price=Float.parseFloat(req.getParameter("txtprice"));
		
		ProductService service=new ProductServiceImpl();
		Product p=new Product(productId,productName,price);
	
		try {
			// p=service.getProductById(productId);
			 if(service.updateProduct(p)) {
				 res.sendRedirect("getall");
			 }
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
		
}
}