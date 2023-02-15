<%@page import="Entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Students</title>
</head>
<body>
<%  
	HttpSession hs=request.getSession();
	List<Student> s= (List) hs.getAttribute("viewStudents");
%>
<table cellpadding="20px" border="1">
<th>Id</th>
<th>Name</th>
<th>Stream</th>
<th>Fees</th>
<% for(Student s1:s) { %>
	<tr align="center">
	<td> <%= s1.getId() %> </td>
	<td> <%= s1.getS_name() %> </td>
	<td> <%= s1.getStream() %> </td>
	<td> <%= s1.getFees() %> </td>
	</tr>
<% } %>
</table>
<br>
<button type="submit"><a href="StudentCrud.html">Done</a></button>
</body>
</html>