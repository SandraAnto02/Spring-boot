<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p style="text-align: center;width: 100%"><%@ include file="menu.jsp" %></p>
<form action="/add">
<input type="text" placeholder="Enter the product name" name="pname"><br>
<input type="text" placeholder="Enter the product ID" name="pid"><br>
<input type="text" placeholder="Enter the product description" name="pdes"><br>
<input type="text" placeholder="Enter the product price" name="pprice"><br>
<input type="text" placeholder="Enter the product quantity" name="pquantity"><br>
<input type="text" placeholder="Enter the product category" name="category"><br>
<input type="submit" value="add"><br>
<input type="reset" value="clear">
</form>
</body>
</html>