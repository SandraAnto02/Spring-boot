<%@page import="java.util.List"%>
<%@page import="com.example.demo.service.EmployeeService"%>
<%@page import="com.example.demo.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Employee List</h1>
    <table border="1">
        <tr>
            <th>Employee ID</th>
            <th>Name</th>
            <th>Salary</th>
            <th>Department</th>
        </tr>
       <% List<Employee> eList = (List<Employee>) request.getAttribute("employeeList");
       for(Employee e : eList) {%>
       <tr>
       		<td><%=e.getEid() %></td>
       		<td><%=e.getEname() %></td>
       		<td><%=e.getSalary() %></td>
       		<td><%=e.getDept() %></td>
       </tr>
       <%} %>
    </table>
</body>
</html>