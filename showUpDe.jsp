<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="com.deloitte.estore.model.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<Product> products=(List<Product>)session.getAttribute("products"); %>
<table>
<tr>
<th>Product Id.</th>
<th>Product Name</th>
<th>Price</th>
<th colspan=2>Delete Update</th>

</tr>
<%for(Product p:products){
	out.println("<tr><td>"+p.getProductId()+"</td>");
	out.println("<td>"+p.getProductName()+"</td>");
	out.println("<td>"+p.getPrice()+"</td>");
	 out.println("<td><a href=delete?pid="+p.getProductId()+">Delete</a></td></tr>");
	out.println("<td><a href=update?pid="+p.getProductId()+">Update</a></td></tr>");
   	
}
%>

</table>
</body>
</html>
