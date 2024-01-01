<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>YO!!</h1>
<form action="/add">
<input type="text" name="ename" placeholder="Enter you name"><br>
<input type="text" name="eid" placeholder="Enter your id"><br>
<input type="text" name="salary" placeholder="Enter your Salary"><br>
<input type="text" name="dept" placeholder="Enter your dept"><br>
<input type="submit" value="Add" >
<input type="submit" value="Clear" ><br>
<a href="/view">View Employees</a>
</body>
</html>