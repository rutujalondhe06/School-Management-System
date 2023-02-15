<%@page import="Entity.Student"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student</title>
</head>
<body>
<%
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("rutuja");
	EntityManager em=emf.createEntityManager();
	
	String Id=request.getParameter("id");
	
	int id=Integer.parseInt(Id);
	Student s = em.find(Student.class, id);
%>
<form action="schoolupdatestudent" method="post">
<b><u>Update Details</u></b><br><br>
Id : &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" value="<%= s.getId() %>" name="id"><br><br>
Name : &nbsp&nbsp<input type="text" value="<%= s.getS_name() %>" name="name"><br><br>
Stream : <input type="text" value="<%= s.getStream() %>" name="stream"><br><br>
Fees : &nbsp&nbsp&nbsp&nbsp<input type="text" value="<%= s.getFees() %>" name="fees"><br><br>
<input type="Submit">
</form>
</body>
</html>