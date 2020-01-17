<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>
ul{
display:inline-flex;
list-style-type:none;
font-size:18px;
align:right;
}
li{
padding-right:20px;
}
.nav{
text-align:right;
}
</style>
<div class="nav">
<ul>
<li><a href="add_product.jsp">Add Product</a></li>
<li><form action= "searchprod">
    <input type="number" name="txtpid" placeholder="Enter the id">
    <input type="submit" value="Search">

</li>
<li><a href="getall">Show all products</a></li>

</ul>
</div>
</body>
</html>