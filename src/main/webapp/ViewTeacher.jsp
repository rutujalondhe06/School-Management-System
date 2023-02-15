<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="Entity.Teacher"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Teachers</title>
</head>
<body>
<%
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("rutuja");
	EntityManager em=emf.createEntityManager();
	
	Query q=em.createQuery("select t from Teacher t");
	List<Teacher> t=q.getResultList();
%>
<table cellpadding="20px" border="1">
<th>Id</th>
<th>Teacher Name</th>
<th>Subject</th>
<th>Salary</th>
<%  for(Teacher t1:t) { %>
	<tr align="center">
	<td> <%= t1.getId() %></td>
	<td> <%= t1.getT_name() %></td>
	<td> <%= t1.getSubject() %></td>
	<td> <%= t1.getSalary() %></td>
	</tr>	
<% } %>
</table>
<br>
<button type="submit"><a href="TeacherCrud.html">Done</a></button>
</body>
</html>