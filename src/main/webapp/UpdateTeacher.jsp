<%@page import="Entity.Teacher"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Teacher</title>
</head>
<body>
<%
	String id=request.getParameter("id");
	
	int id1=Integer.parseInt(id);
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("rutuja");
	EntityManager em=emf.createEntityManager();
	
	Teacher t=em.find(Teacher.class, id1);
%>

<form action="schoolupdateteacher" method="post">
<b><u>Update Details</u></b><br><br>
Id : &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" value="<%= t.getId() %>" name="id"><br><br>
Name : &nbsp&nbsp<input type="text" value="<%= t.getT_name() %>" name="name"><br><br>
Subject : <input type="text" value="<%= t.getSubject() %>" name="subject"><br><br>
Salary : &nbsp&nbsp<input type="text" value="<%= t.getSalary() %>" name="salary"><br><br>
<input type="Submit">
</form>
</body>
</html>